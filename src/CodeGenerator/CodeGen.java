package CodeGenerator;
import SemanticAnalysis.SymbolTable.FunctionSymbol;
import SemanticAnalysis.SymbolTable.Scope;
import SemanticAnalysis.SymbolTable.Symbol;
import SemanticAnalysis.SymbolTable.VariableSymbol;
import Tuga.TugaBaseVisitor;
import Tuga.TugaParser;
import SVM.*;
import SemanticAnalysis.Type;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class CodeGen extends TugaBaseVisitor<Void> {
    private final List<Instruction> code = new ArrayList<>();
    private final ConstantPool constantPool = new ConstantPool();
    private final ParseTreeProperty<Type> types;
    private final Map<String, Integer> functionAddrs = new HashMap<>();
    private final Scope globalScope;
    private Scope currentScope;
    private FunctionSymbol currentFunction = null;
    private final ParseTreeProperty<Scope> scopes;
    private final List<CallPlaceholder> callPlaceholders = new ArrayList<>();

    public CodeGen(ParseTreeProperty<Type> types, Scope globalScope, ParseTreeProperty<Scope> scopes) {
        this.types = types;
        this.globalScope = globalScope;
        this.currentScope = globalScope;
        this.scopes = scopes;
    }

    private static class CallPlaceholder {
        int instructionIndex;
        String functionName;

        CallPlaceholder(int instructionIndex, String functionName) {
            this.instructionIndex = instructionIndex;
            this.functionName = functionName;
        }
    }

    public Map<Integer, Svm.FunctionInfo> getFunctionInfos() {
        Map<Integer, Svm.FunctionInfo> infos = new HashMap<>();
        for (var entry : functionAddrs.entrySet()) {
            String functionName = entry.getKey();
            int address = entry.getValue();

            Symbol symbol = globalScope.resolve(functionName);
            if (symbol instanceof FunctionSymbol funcSymbol) {
                int numArgs = funcSymbol.getArguments().size();
                infos.put(address, new Svm.FunctionInfo(address, numArgs));
            }
        }
        return infos;
    }

    public void saveBytecodes(String filename) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            out.writeInt(constantPool.size());
            for (Object value : constantPool.getConstants()) {
                if (value instanceof Double d) {
                    out.writeByte(1);
                    out.writeDouble(d);
                } else if (value instanceof String s) {
                    out.writeByte(3);
                    out.writeInt(s.length());
                    for (char c : s.toCharArray()) {
                        out.writeChar(c);
                    }
                }
            }
            for (Instruction i : code) {
                i.writeTo(out);
            }
        }
    }

    public void dumpCode() {
        System.out.println("*** Constant pool ***");
        List<Object> constants = constantPool.getConstants();
        for (int i = 0; i < constants.size(); i++) {
            Object val = constants.get(i);
            if (val instanceof String s)
                System.out.println(i + ": \"" + s + "\"");
            else
                System.out.println(i + ": " + val);
        }

        System.out.println("*** Instructions ***");
        for (int i = 0; i < code.size(); i++) {
            System.out.println(i + ": " + code.get(i));
        }
    }

    private void emit(OpCode op) {
        code.add(new InstructionNoArg(op));
    }

    private void emit(OpCode op, int arg) {
        code.add(new Instruction1Arg(op, arg));
    }

    private Type getType(ParserRuleContext ctx) {
        return types.get(ctx);
    }

    @Override
    public Void visitProgram(TugaParser.ProgramContext ctx) {
        prepareGlobalVariables(ctx);

        int callIndex = code.size();
        emit(OpCode.CALL, -1);
        emit(OpCode.HALT);

        for (var func : ctx.functionDeclaration()) {
            String functionName = func.VAR_NAME().getText();
            functionAddrs.put(functionName, -1);
        }

        for (var func : ctx.functionDeclaration()) {
            String functionName = func.VAR_NAME().getText();
            functionAddrs.put(functionName, code.size());
            visit(func);
        }

        Integer principalAddr = functionAddrs.get("principal");
        if (principalAddr == null) {
            throw new RuntimeException("Funcao principal() nao encontrada");
        }
        ((Instruction1Arg) code.get(callIndex)).setArg(principalAddr);

        for (CallPlaceholder placeholder : callPlaceholders) {
            Integer addr = functionAddrs.get(placeholder.functionName);
            if (addr == null || addr == -1) {
                throw new RuntimeException("Endereco da funcao '" + placeholder.functionName + "' nao encontrado");
            }
            ((Instruction1Arg) code.get(placeholder.instructionIndex)).setArg(addr);
        }

        return null;
    }

    private void prepareGlobalVariables(TugaParser.ProgramContext ctx) {
        Map<Type, List<VariableSymbol>> byType = new LinkedHashMap<>();
        Set<Type> order = new LinkedHashSet<>();
        for (Type t : Type.values()) byType.put(t, new ArrayList<>());

        for (var decl : ctx.varDeclaration()) {
            Type type = switch (decl.type().getText()) {
                case "inteiro" -> Type.INT;
                case "real" -> Type.DOUBLE;
                case "string" -> Type.STRING;
                case "booleano" -> Type.BOOLEAN;
                default -> Type.ERROR;
            };
            order.add(type);
            for (var varNode : decl.VAR_NAME()) {
                VariableSymbol var = new VariableSymbol(varNode.getSymbol(), type);
                var.setGlobal(true);
                byType.get(type).add(var);
            }
        }

        int offset = 0;
        for (Type type : order) {
            List<VariableSymbol> vars = byType.get(type);
            if (!vars.isEmpty()) {
                emit(OpCode.GALLOC, vars.size());
                for (VariableSymbol var : vars) {
                    var.setOffset(offset++);
                    globalScope.define(var);
                }
            }
        }
    }

    @Override
    public Void visitFunctionDeclaration(TugaParser.FunctionDeclarationContext ctx){
        FunctionSymbol func = (FunctionSymbol) globalScope.resolve(ctx.VAR_NAME().getText());
        currentScope = func.getBodyScope();
        currentFunction = func;

        int localCount = (int) currentScope.getSymbols().values().stream()
                .filter(s -> s instanceof VariableSymbol v && !v.isParameter())
                .count();

        for (var decl : ctx.bloco().varDeclaration()) {
            visit(decl);
        }

        boolean hasReturnInside = false;

        for (var inst : ctx.bloco().inst()) {
            int blockStartIndex = code.size();
            visit(inst);
            if (code.size() > blockStartIndex &&
                    code.get(code.size() - 1) instanceof Instruction1Arg i &&
                    (i.getOpcode() == OpCode.RET || i.getOpcode() == OpCode.RETVAL)) {
                hasReturnInside = true;
            }
        }

        if (localCount > 0 && !hasReturnInside) {
            emit(OpCode.POP, localCount);
        }

        if (func.isVoid() && !hasReturnInside) {
            emit(OpCode.RET, func.getArguments().size());
        }

        currentScope = globalScope;
        currentFunction = null;
        return null;
    }

    @Override
    public Void visitBloco(TugaParser.BlocoContext ctx) {
        Scope blocoScope = scopes.get(ctx);
        currentScope = blocoScope;

        int blockLocalCount = (int) blocoScope.getSymbols().values().stream()
                .filter(s -> s instanceof VariableSymbol v && !v.isParameter())
                .count();

        for (var decl : ctx.varDeclaration()) {
            visit(decl);
        }

        boolean hasReturnInside = false;

        for (var inst : ctx.inst()) {
            int blockStartIndex = code.size();
            visit(inst);

            if (code.size() > blockStartIndex &&
                    code.get(code.size() - 1) instanceof Instruction1Arg i &&
                    (i.getOpcode() == OpCode.RET || i.getOpcode() == OpCode.RETVAL)) {
                hasReturnInside = true;
            }
        }

        if (blockLocalCount > 0 && !hasReturnInside) {
            emit(OpCode.POP, blockLocalCount);
        }

        currentScope = currentScope.getEnclosingScope();
        return null;
    }

    @Override
    public Void visitVarDeclaration(TugaParser.VarDeclarationContext ctx) {
        int count = 0;
        for (var varNode : ctx.VAR_NAME()) {
            Symbol sym = currentScope.resolve(varNode.getText());
            if (sym instanceof VariableSymbol var && !var.isGlobal()) {
                count++;
            }
        }

        if (count > 0) {
            emit(OpCode.LALLOC, count);
        }

        return null;
    }

    @Override
    public Void visitFuncCall(TugaParser.FuncCallContext ctx) {
        Symbol symbol = currentScope.resolve(ctx.VAR_NAME().getText());
        if (!(symbol instanceof FunctionSymbol function)) {
            throw new RuntimeException("Endereco da funcao '" + ctx.VAR_NAME().getText() + "' nao encontrado");
        }

        List<TugaParser.ExprContext> args = ctx.expr();
        List<VariableSymbol> params = function.getArguments();

        for (int i = 0; i < args.size(); i++) {
            TugaParser.ExprContext argCtx = args.get(i);
            Type expectedType = params.get(i).getType();
            visitAndConvertTo(argCtx, expectedType);
        }

        int callInstIndex = code.size();
        emit(OpCode.CALL, -1);
        callPlaceholders.add(new CallPlaceholder(callInstIndex, ctx.VAR_NAME().getText()));

        return null;
    }

    @Override
    public Void visitVoidFunctionCall(TugaParser.VoidFunctionCallContext ctx) {
        visit(ctx.funcCall());
        return null;
    }

    @Override
    public Void visitReturn(TugaParser.ReturnContext ctx) {
        if (currentFunction == null)
            throw new RuntimeException("Retorno fora de função");

        int paramCount = currentFunction.getArguments().size();

        if (ctx.expr() != null) {
            visit(ctx.expr());
            Type exprType = getType(ctx.expr());
            Type expectedType = currentFunction.getType();

            if (exprType != expectedType) {
                if (expectedType == Type.DOUBLE && exprType == Type.INT) {
                    emit(OpCode.ITOD);
                } else {
                    throw new RuntimeException("Tipo de retorno inesperado: " + exprType + " esperado: " + expectedType);
                }
            }

            emit(OpCode.RETVAL, paramCount);
        } else {
            emit(OpCode.RET, paramCount);
        }

        return null;
    }

    @Override
    public Void visitAfection(TugaParser.AfectionContext ctx) {
        visit(ctx.expr());
        String varName = ctx.VAR_NAME().getText();
        Symbol sym = currentScope.resolve(varName);
        if (sym instanceof VariableSymbol var) {
            emit(var.isGlobal() ? OpCode.GSTORE : OpCode.LSTORE,var.getOffset());
        }
        return null;
    }

    @Override
    public Void visitVariable(TugaParser.VariableContext ctx) {
        String varName = ctx.VAR_NAME().getText();
        Symbol sym = currentScope.resolve(varName);
        if (sym instanceof VariableSymbol var) {
            emit(var.isGlobal() ? OpCode.GLOAD : OpCode.LLOAD,var.getOffset());
        }
        return null;
    }

    @Override
    public Void visitEnquanto(TugaParser.EnquantoContext ctx) {
        int loopStart = code.size();
        visit(ctx.expr());
        int jumpfIndex = code.size();
        emit(OpCode.JUMPF, -1);

        visit(ctx.inst());
        emit(OpCode.JUMP, loopStart);

        int loopEnd = code.size();
        ((Instruction1Arg) code.get(jumpfIndex)).setArg(loopEnd);

        return null;
    }

    @Override
    public Void visitSeSenao(TugaParser.SeSenaoContext ctx) {
        visit(ctx.expr());

        int jumpfIndex = code.size();
        emit(OpCode.JUMPF, -1);
        visit(ctx.inst(0));

        if (ctx.inst().size() > 1) {
            int jumpIndex = code.size();
            emit(OpCode.JUMP, -1);

            int elseStart = code.size();
            ((Instruction1Arg) code.get(jumpfIndex)).setArg(elseStart);
            visit(ctx.inst(1));

            int end = code.size();
            ((Instruction1Arg) code.get(jumpIndex)).setArg(end);
        } else {
            int end = code.size();
            ((Instruction1Arg) code.get(jumpfIndex)).setArg(end);
        }

        return null;
    }

    @Override
    public Void visitPrint(TugaParser.PrintContext ctx) {
        visit(ctx.expr());
        Type t = getType(ctx.expr());

        if (t == null && ctx.expr().getChild(0) instanceof TugaParser.FuncCallContext f) {
            FunctionSymbol func = (FunctionSymbol) globalScope.resolve(f.VAR_NAME().getText());
            t = func.getType();
        }

        if (t == null) throw new RuntimeException("Tipo desconhecido para expressao em print");

        emit(switch (t) {
            case INT -> OpCode.IPRINT;
            case DOUBLE -> OpCode.DPRINT;
            case STRING -> OpCode.SPRINT;
            case BOOLEAN -> OpCode.BPRINT;
            default -> throw new RuntimeException("Tipo nao suportado em print: " + t);
        });

        return null;
    }

    public Void visitInt(TugaParser.IntContext ctx){
        int value = Integer.parseInt(ctx.getText());
        emit(OpCode.ICONST, value);
        return null;
    }

    public Void visitDouble(TugaParser.DoubleContext ctx) {
        double value = Double.parseDouble(ctx.getText());
        int index = constantPool.add(value);
        emit(OpCode.DCONST, index);
        return null;
    }

    public Void visitString(TugaParser.StringContext ctx) {
        String s = ctx.getText();
        s = s.substring(1, s.length() - 1);
        int index = constantPool.add(s);
        emit(OpCode.SCONST, index);
        return null;
    }

    public Void visitBoolean(TugaParser.BooleanContext ctx) {
        emit(ctx.getText().equals("verdadeiro") ? OpCode.TCONST : OpCode.FCONST);
        return null;
    }

    public Void visitParentheses(TugaParser.ParenthesesContext ctx) {
        visit(ctx.expr());
        return null;
    }

    public Void visitNegation(TugaParser.NegationContext ctx) {
        visit(ctx.expr());
        Type t = getType(ctx.expr());
        emit(ctx.op.getText().equals("-") ? (t == Type.INT ? OpCode.IUMINUS : OpCode.DUMINUS) : OpCode.NOT);
        return null;
    }


    public Void visitAddSub(TugaParser.AddSubContext ctx) {
        Type t1 = getType(ctx.expr(0));
        Type t2 = getType(ctx.expr(1));
        String op = ctx.op.getText();

        if (t1 == Type.STRING || t2 == Type.STRING) {
            visitAndConvertTo(ctx.expr(0), Type.STRING);
            visitAndConvertTo(ctx.expr(1), Type.STRING);
            emit(OpCode.SCONCAT);
        } else if (t1 == Type.DOUBLE || t2 == Type.DOUBLE) {
            visitAndConvertTo(ctx.expr(0), Type.DOUBLE);
            visitAndConvertTo(ctx.expr(1), Type.DOUBLE);
            emit(op.equals("+") ? OpCode.DADD : OpCode.DSUB);
        } else {
            visit(ctx.expr(0));
            visit(ctx.expr(1));
            emit(op.equals("+") ? OpCode.IADD : OpCode.ISUB);
        }
        return null;
    }

    private OpCode convertToString(Type t) {
        return switch (t) {
            case INT -> OpCode.ITOS;
            case DOUBLE -> OpCode.DTOS;
            case BOOLEAN -> OpCode.BTOS;
            default -> throw new RuntimeException("Cannot convert type to string: " + t);
        };
    }

    private void visitAndConvertTo(TugaParser.ExprContext ctx, Type target) {
        visit(ctx);
        Type actual = getType(ctx);
        if (actual != target) {
            if (target == Type.DOUBLE && actual == Type.INT) emit(OpCode.ITOD);
            else if (target == Type.STRING) emit(convertToString(actual));
        }
    }

    public Void visitMultDivMod(TugaParser.MultDivModContext ctx) {
        String op = ctx.op.getText();
        if (op.equals("%")) {
            visit(ctx.expr(0));
            visit(ctx.expr(1));
            emit(OpCode.IMOD);
            return null;
        }

        Type t1 = getType(ctx.expr(0));
        Type t2 = getType(ctx.expr(1));
        if (t1 == Type.DOUBLE || t2 == Type.DOUBLE) {
            visitAndConvertTo(ctx.expr(0), Type.DOUBLE);
            visitAndConvertTo(ctx.expr(1), Type.DOUBLE);
            emit(op.equals("*") ? OpCode.DMULT : OpCode.DDIV);
        } else {
            visit(ctx.expr(0));
            visit(ctx.expr(1));
            emit(op.equals("*") ? OpCode.IMULT : OpCode.IDIV);
        }
        return null;
    }

    public Void visitRelational(TugaParser.RelationalContext ctx) {

        Type t1 = getType(ctx.expr(0));
        Type t2 = getType(ctx.expr(1));
        String op = ctx.op.getText();
        boolean isDouble = t1 == Type.DOUBLE || t2 == Type.DOUBLE;

        if (op.equals(">") || op.equals(">=")) {
            visitAndConvertTo(ctx.expr(1), isDouble ? Type.DOUBLE : Type.INT);
            visitAndConvertTo(ctx.expr(0), isDouble ? Type.DOUBLE : Type.INT);
        } else {
            visitAndConvertTo(ctx.expr(0), isDouble ? Type.DOUBLE : Type.INT);
            visitAndConvertTo(ctx.expr(1), isDouble ? Type.DOUBLE : Type.INT);
        }

        OpCode opcode = switch (op) {
            case "<" , ">" -> isDouble ? OpCode.DLT : OpCode.ILT;
            case "<=", ">=" -> isDouble ? OpCode.DLEQ : OpCode.ILEQ;
            default -> throw new RuntimeException("Unknown relational op: " + op);
        };
        emit(opcode);
        return null;
    }

    public Void visitEquility(TugaParser.EquilityContext ctx) {
        Type t1 = getType(ctx.expr(0));
        Type t2 = getType(ctx.expr(1));
        String op = ctx.op.getText();
        boolean isEqual = op.equals("igual");

        if ((t1 == Type.DOUBLE || t2 == Type.DOUBLE) && (t1 == Type.INT || t2 == Type.INT)) {
            visitAndConvertTo(ctx.expr(0), Type.DOUBLE);
            visitAndConvertTo(ctx.expr(1), Type.DOUBLE);
            emit(isEqual ? OpCode.DEQ : OpCode.DNEQ);
        } else {
            visit(ctx.expr(0));
            visit(ctx.expr(1));

            OpCode opcode = switch (t1) {
                case INT -> isEqual ? OpCode.IEQ : OpCode.INEQ;
                case DOUBLE -> isEqual ? OpCode.DEQ : OpCode.DNEQ;
                case BOOLEAN -> isEqual ? OpCode.BEQ : OpCode.BNEQ;
                case STRING -> isEqual ? OpCode.SEQ : OpCode.SNEQ;
                default -> throw new RuntimeException("Unsupported type: " + t1);
            };
            emit(opcode);
        }
        return null;
    }

    public Void visitE(TugaParser.EContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        emit(OpCode.AND);
        return null;
    }

    public Void visitOU(TugaParser.OUContext ctx) {
        visit(ctx.expr(0));
        visit(ctx.expr(1));
        emit(OpCode.OR);
        return null;
    }
}