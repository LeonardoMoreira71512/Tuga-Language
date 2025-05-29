package SemanticAnalysis.SymbolTable;

import SemanticAnalysis.Type;
import org.antlr.v4.runtime.Token;

public class Symbol {
    Token token;
    Type type;
    Scope scope;

    public Symbol(Token token, Type type) {
        this.token = token;
        this.type = type;
    }

    public String getName() {
        return token.getText();
    }

    public Type getType() {
        return type;
    }

    public String toString() {
        return '<' + getName() + ":" + type + '>';
    }
}

