package SemanticAnalysis.SymbolTable;
import SemanticAnalysis.Type;
import org.antlr.v4.runtime.Token;


public class VariableSymbol extends Symbol {
    private final boolean isParameter;
    private int offset;
    private boolean isGlobal;

    public VariableSymbol(Token token, Type type) {
        this(token, type, false);
    }

    public VariableSymbol(Token token, Type type, boolean isParameter) {
        super(token, type);
        this.isParameter = isParameter;
    }

    public boolean isParameter() {
        return isParameter;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
