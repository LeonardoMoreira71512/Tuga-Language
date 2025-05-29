package SemanticAnalysis.SymbolTable;

import SemanticAnalysis.Type;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

public class FunctionSymbol extends Symbol {
    private final List<VariableSymbol> arguments = new ArrayList<>();
    private Scope bodyScope;

    public FunctionSymbol(Token token, Type type) {
        super(token, type);
    }

    public void setBodyScope(Scope scope) {
        this.bodyScope = scope;
    }

    public Scope getBodyScope() {
        return this.bodyScope;
    }

    public void addArgument(VariableSymbol param) {
        arguments.add(param);
    }

    public List<VariableSymbol> getArguments() {
        return arguments;
    }

    public boolean hasArgument(String name) {
        return arguments.stream().anyMatch(arg -> arg.getName().equals(name));
    }

    public boolean isVoid() {
        return this.getType() == Type.VOID;
    }

    @Override
    public String toString() {
        return "function " + super.toString() + " with params " + arguments;
    }
}
