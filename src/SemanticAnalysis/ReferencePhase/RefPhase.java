package SemanticAnalysis.ReferencePhase;

import Tuga.TugaBaseVisitor;
import SemanticAnalysis.ErrorsReport.ErrorReporter;
import SemanticAnalysis.SymbolTable.*;
import SemanticAnalysis.Type;
import Tuga.TugaParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.List;

public class RefPhase extends TugaBaseVisitor<Type> {
    private final ParseTreeProperty<Scope> scopes;
    private Scope currentScope;
    private final Scope globalScope;
    private final ErrorReporter reporter;

    private final ParseTreeProperty<Type> types = new ParseTreeProperty<>();

    public RefPhase(ParseTreeProperty<Scope> scopes, Scope globalScope, ErrorReporter reporter) {
        this.scopes = scopes;
        this.globalScope = globalScope;
        this.reporter = reporter;
    }

    private void setType(ParserRuleContext ctx, Type type) {
        types.put(ctx, type);
    }

    private Type visitAndSetType(ParserRuleContext ctx) {
        Type t = visit(ctx);
        if (t != null) setType(ctx, t);
        return t;
    }

    public ParseTreeProperty<Type> getTypes() {
        return types;
    }


    @Override
    public Type visitBloco(TugaParser.BlocoContext ctx) {
        currentScope = scopes.get(ctx);
        for (var inst : ctx.inst()) {
            visit(inst);
        }
        currentScope = currentScope.getEnclosingScope();
        return null;
    }

    @Override
    public Type visitVarDeclaration(TugaParser.VarDeclarationContext ctx) {
        return null;  // Ja validado na DefPhase
    }

    @Override
    public Type visitFunctionDeclaration(TugaParser.FunctionDeclarationContext ctx) {
        Symbol symbol = globalScope.resolve(ctx.VAR_NAME().getText());
        if (!(symbol instanceof FunctionSymbol function)) {
            return null; // ja foi reportado na DefPhase
        }

        //Entra no escopo do corpo da função
        currentScope = function.getBodyScope();
        visit(ctx.bloco());
        currentScope = currentScope.getEnclosingScope();

        return null;
    }

    @Override
    public Type visitFuncCall(TugaParser.FuncCallContext ctx) {
        Symbol symbol = currentScope.resolve(ctx.VAR_NAME().getText());
        if (!(symbol instanceof FunctionSymbol function)) {
            reporter.report(ctx, "'" + ctx.VAR_NAME().getText() + "' nao foi declarado");
            setType(ctx, Type.ERROR);
            return Type.ERROR;
        }

        List<VariableSymbol> params = function.getArguments();
        List<TugaParser.ExprContext> args = ctx.expr() != null ? ctx.expr() : List.of();
        if (args.size() != params.size()) {
            reporter.report(ctx, "'" + ctx.VAR_NAME().getText() + "' requer " + params.size() + " argumentos");
        } else {
            for (int i = 0; i < args.size(); i++) {
                Type expected = params.get(i).getType();
                Type actual = visitAndSetType(args.get(i));
                if (!isAssignable(expected, actual)) {
                    reporter.report(args.get(i), "'" + args.get(i).getText() + "' devia ser do tipo " + expected);
                }
            }
        }

        setType(ctx, function.getType());
        return function.getType();
    }

    @Override
    public Type visitVoidFunctionCall(TugaParser.VoidFunctionCallContext ctx) {
        Type returnType = visit(ctx.funcCall());
        if (returnType != Type.VOID) {
            reporter.report(ctx, "valor de '" + ctx.funcCall().VAR_NAME().getText() + "' tem de ser atribuido a uma variavel");
        }
        return null;
    }

    @Override
    public Type visitAfection(TugaParser.AfectionContext ctx) {
        Symbol symbol = currentScope.resolve(ctx.VAR_NAME().getText());
        if (symbol == null || !(symbol instanceof VariableSymbol variable)) {
            reporter.report(ctx, "'" + ctx.VAR_NAME().getText() + "' nao eh variavel");
            return Type.ERROR;
        }

        Type valueType = visit(ctx.expr());
        if (!isAssignable(variable.getType(), valueType)) {
            reporter.report(ctx, "operador '<-' eh invalido entre " + variable.getType() + " e " + valueType);
        }

        return variable.getType();
    }

    private boolean isAssignable(Type expected, Type actual) {
        return expected == actual || (expected == Type.DOUBLE && actual == Type.INT);
    }

    @Override
    public Type visitVariable(TugaParser.VariableContext ctx) {
        Symbol symbol = currentScope.resolve(ctx.VAR_NAME().getText());
        if (!(symbol instanceof VariableSymbol variable)) {
            reporter.report(ctx, "'" + ctx.VAR_NAME().getText() + "' nao eh variavel");
            setType(ctx, Type.ERROR);
            return Type.ERROR;
        }
        setType(ctx, variable.getType());
        return variable.getType();
    }

    @Override
    public Type visitInt(TugaParser.IntContext ctx) {
        setType(ctx, Type.INT);
        return Type.INT;
    }

    @Override
    public Type visitDouble(TugaParser.DoubleContext ctx) {
        setType(ctx, Type.DOUBLE);
        return Type.DOUBLE;
    }

    @Override
    public Type visitString(TugaParser.StringContext ctx) {
        setType(ctx, Type.STRING);
        return Type.STRING;
    }

    @Override
    public Type visitBoolean(TugaParser.BooleanContext ctx) {
        setType(ctx, Type.BOOLEAN);
        return Type.BOOLEAN;
    }

    @Override
    public Type visitPrint(TugaParser.PrintContext ctx) {
        visit(ctx.expr());
        return null;
    }

    @Override
    public Type visitReturn(TugaParser.ReturnContext ctx) {
        Type returnValueType = Type.VOID;

        if (ctx.expr() != null) {
            returnValueType = visitAndSetType(ctx.expr());
        }

        Scope scope = currentScope;
        while (scope != null && !(scope.resolve_local(scope.getName()) instanceof FunctionSymbol)) {
            scope = scope.getEnclosingScope();
        }

        if (scope != null && scope.resolve_local(scope.getName()) instanceof FunctionSymbol function) {
            Type expectedReturnType = function.getType();
            if (!isAssignable(expectedReturnType, returnValueType)) {
                reporter.report(ctx, "funcao '" + function.getName() + "' devia retornar " + expectedReturnType + " mas retorna " + returnValueType);
            }
        }

        return null;
    }

    @Override
    public Type visitEmpty(TugaParser.EmptyContext ctx) {
        return null;
    }


    @Override
    public Type visitAddSub(TugaParser.AddSubContext ctx) {
        Type t1 = visitAndSetType(ctx.expr(0));
        Type t2 = visitAndSetType(ctx.expr(1));
        String op = ctx.op.getText();

        if (op.equals("+") && (t1 == Type.STRING || t2 == Type.STRING)) {
            setType(ctx, Type.STRING);
            return Type.STRING;
        }

        if (t1 != null && t2 != null && t1.isNumeric() && t2.isNumeric()) {
            Type result = (t1 == Type.DOUBLE || t2 == Type.DOUBLE) ? Type.DOUBLE : Type.INT;
            setType(ctx, result);
            return result;
        }

        reporter.report(ctx, "operador '" + op + "' eh invalido entre " + t1 + " e " + t2);
        setType(ctx, Type.ERROR);
        return Type.ERROR;
    }

    @Override
    public Type visitMultDivMod(TugaParser.MultDivModContext ctx) {
        Type t1 = visitAndSetType(ctx.expr(0));
        Type t2 = visitAndSetType(ctx.expr(1));
        String op = ctx.op.getText();

        if (t1 != null && t2 != null && t1.isNumeric() && t2.isNumeric()) {
            if (op.equals("%")) {
                if (t1 == Type.INT && t2 == Type.INT) {
                    setType(ctx, Type.INT);
                    return Type.INT;
                } else {
                    reporter.report(ctx, "Operador '%' so pode ser aplicado a inteiros, mas recebeu " + t1 + " e " + t2);
                    return Type.ERROR;
                }
            }
            Type result = (t1 == Type.DOUBLE || t2 == Type.DOUBLE) ? Type.DOUBLE : Type.INT;
            setType(ctx, result);
            return result;
        }

        reporter.report(ctx, "operador '" + op + "' eh invalido entre " + t1 + " e " + t2);
        setType(ctx, Type.ERROR);
        return Type.ERROR;
    }

    @Override
    public Type visitSeSenao(TugaParser.SeSenaoContext ctx) {
        Type condType = visit(ctx.expr());
        if (condType != Type.BOOLEAN) {
            reporter.report(ctx, "expressao de 'se' nao eh do tipo booleano");
        }
        visit(ctx.inst(0));
        if (ctx.inst().size() > 1) {
            visit(ctx.inst(1));
        }
        return null;
    }

    @Override
    public Type visitEnquanto(TugaParser.EnquantoContext ctx) {
        Type condType = visit(ctx.expr());
        if (condType != Type.BOOLEAN) {
            reporter.report(ctx, "expressao de 'enquanto' nao eh do tipo booleano");
        }
        visit(ctx.inst());
        return null;
    }

    @Override
    public Type visitParentheses(TugaParser.ParenthesesContext ctx) {
        Type t = visitAndSetType(ctx.expr());
        setType(ctx, t);
        return t;
    }

    @Override
    public Type visitRelational(TugaParser.RelationalContext ctx) {
        Type t1 = visitAndSetType(ctx.expr(0));
        Type t2 = visitAndSetType(ctx.expr(1));

        if (t1 != null && t2 != null && t1.isNumeric() && t2.isNumeric()) {
            setType(ctx, Type.BOOLEAN);
            return Type.BOOLEAN;
        }

        reporter.report(ctx, "Operador '" + ctx.op.getText() + "' requer operandos numericos, mas recebeu " + t1 + " e " + t2);
        return Type.ERROR;
    }

    @Override
    public Type visitEquility(TugaParser.EquilityContext ctx) {
        Type t1 = visitAndSetType(ctx.expr(0));
        Type t2 = visitAndSetType(ctx.expr(1));

        if ((t1 == Type.BOOLEAN && t2 == Type.BOOLEAN) ||
                (t1.isNumeric() && t2.isNumeric()) ||
                (t1 == Type.STRING && t2 == Type.STRING)) {
            setType(ctx, Type.BOOLEAN);
            return Type.BOOLEAN;
        }

        reporter.report(ctx, "Operador '" + ctx.op.getText() + "' invalido entre tipos " + t1 + " e " + t2);
        return Type.ERROR;
    }

    @Override
    public Type visitE(TugaParser.EContext ctx) {
        Type t1 = visitAndSetType(ctx.expr(0));
        Type t2 = visitAndSetType(ctx.expr(1));

        if (t1 == Type.BOOLEAN && t2 == Type.BOOLEAN) {
            setType(ctx, Type.BOOLEAN);
            return Type.BOOLEAN;
        }

        reporter.report(ctx, "Operador 'e' requer operandos booleanos, mas recebeu " + t1 + " e " + t2);
        return Type.ERROR;
    }

    @Override
    public Type visitOU(TugaParser.OUContext ctx) {
        Type t1 = visitAndSetType(ctx.expr(0));
        Type t2 = visitAndSetType(ctx.expr(1));

        if (t1 == Type.BOOLEAN && t2 == Type.BOOLEAN) {
            setType(ctx, Type.BOOLEAN);
            return Type.BOOLEAN;
        }

        reporter.report(ctx, "Operador 'ou' requer operandos booleanos, mas recebeu " + t1 + " e " + t2);
        return Type.ERROR;
    }

    @Override
    public Type visitNegation(TugaParser.NegationContext ctx) {
        Type t = visitAndSetType(ctx.expr());
        String op = ctx.op.getText();

        if (op.equals("-")) {
            if (t == Type.INT || t == Type.DOUBLE) {
                setType(ctx, t);
                return t;
            }
            reporter.report(ctx, "Operador '-' so pode ser aplicado a inteiros ou reais, mas recebeu " + t);
        } else if (op.equals("nao")) {
            if (t == Type.BOOLEAN) {
                setType(ctx, Type.BOOLEAN);
                return Type.BOOLEAN;
            }
            reporter.report(ctx, "Operador 'nao' so pode ser aplicado a booleanos, mas recebeu " + t);
        }
        return Type.ERROR;
    }
}
