package SemanticAnalysis.DefinitionPhase;

import SemanticAnalysis.ErrorsReport.ErrorReporter;
import SemanticAnalysis.SymbolTable.*;
import SemanticAnalysis.Type;
import Tuga.TugaBaseListener;
import Tuga.TugaParser;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayDeque;
import java.util.Deque;

public class DefPhase extends TugaBaseListener {
    public final ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    private final ErrorReporter reporter;
    public Scope globalScope;
    private Scope currentScope;
    private FunctionSymbol currentFunction;
    private int nextLocalOffset = 0;
    private final Deque<Integer> offsetStack = new ArrayDeque<>();

    public DefPhase(ErrorReporter reporter) {
        this.reporter = reporter;
    }

    @Override
    public void enterProgram(TugaParser.ProgramContext ctx) {
        globalScope = new Scope(null, "global");
        currentScope = globalScope;
    }

    @Override
    public void exitProgram(TugaParser.ProgramContext ctx) {
        Symbol principal = globalScope.resolve("principal");

        boolean isValid = principal instanceof FunctionSymbol func &&
                func.getArguments().isEmpty() &&
                func.getType() == Type.VOID;

        if (!isValid) {
            var lastFunc = ctx.functionDeclaration(ctx.functionDeclaration().size() - 1);
            var fimToken = lastFunc.bloco().FIM().getSymbol();
            int lastLine = fimToken.getLine() + 1;

            var fakeToken = new CommonToken(fimToken);
            fakeToken.setLine(lastLine);
            var fakeCtx = new ParserRuleContext();
            fakeCtx.start = fakeToken;

            reporter.report(fakeCtx, "falta funcao principal()");
        }
    }


    @Override
    public void enterFunctionDeclaration(TugaParser.FunctionDeclarationContext ctx) {
        Token token = ctx.VAR_NAME().getSymbol();
        Type returnType = getTypeFromText(ctx.type() != null ? ctx.type().getText() : "vazio");
        String functionName = token.getText();

        if (currentScope.resolve(functionName) != null) {
            reporter.report(ctx, "'" + functionName + "' ja foi declarado");
        } else {
            FunctionSymbol function = new FunctionSymbol(token, returnType);
            if (ctx.arguments() != null) {
                int paramOffset = -ctx.arguments().parameter().size();
                for (var paramCtx : ctx.arguments().parameter()) {
                    Type paramType = getTypeFromText(paramCtx.type().getText());
                    Token paramToken = paramCtx.VAR_NAME().getSymbol();
                    String paramName = paramToken.getText();

                    if (function.hasArgument(paramName)) {
                        reporter.report(paramCtx, "'" + paramName + "' ja foi declarado");
                    } else {
                        VariableSymbol param = new VariableSymbol(paramToken, paramType, true);
                        param.setOffset(paramOffset++);
                        param.setGlobal(false);
                        function.addArgument(param);
                    }
                }
            }

            currentScope.define(function);
            currentFunction = function;
        }
    }

    @Override
    public void enterBloco(TugaParser.BlocoContext ctx) {
        Scope newScope = new Scope(currentScope);

        if (currentFunction != null && currentFunction.getBodyScope() == null) {
            newScope.setName(currentFunction.getName());
            for (VariableSymbol arg : currentFunction.getArguments()) {
                newScope.define(arg);
            }
            currentFunction.setBodyScope(newScope);
            nextLocalOffset = 2;
        }

        offsetStack.push(nextLocalOffset);
        currentScope = newScope;
        scopes.put(ctx, currentScope);
    }


    @Override
    public void exitBloco(TugaParser.BlocoContext ctx) {
        nextLocalOffset = offsetStack.pop();
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitVarDeclaration(TugaParser.VarDeclarationContext ctx) {
        Type type = getTypeFromText(ctx.type().getText());
        for (var varNode : ctx.VAR_NAME()) {
            Token token = varNode.getSymbol();
            String name = token.getText();
            if (currentScope.resolve(name) != null) {
                reporter.report(ctx, "'" + name + "' ja foi declarado");
            } else {
                VariableSymbol var = new VariableSymbol(token, type);
                var.setOffset(nextLocalOffset++);
                currentScope.define(var);
            }
        }
    }

    private Type getTypeFromText(String text) {
        return switch (text) {
            case "inteiro" -> Type.INT;
            case "real" -> Type.DOUBLE;
            case "string" -> Type.STRING;
            case "booleano" -> Type.BOOLEAN;
            case "vazio" -> Type.VOID;
            default -> Type.ERROR;
        };
    }

}
