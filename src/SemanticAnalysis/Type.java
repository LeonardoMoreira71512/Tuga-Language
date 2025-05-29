package SemanticAnalysis;

public enum Type {
    INT,
    DOUBLE,
    STRING,
    BOOLEAN,
    VOID,
    ERROR;

    public boolean isNumeric() {
        return this == INT || this == DOUBLE;
    }

    @Override
    public String toString() {
        return switch (this) {
            case INT -> "inteiro";
            case DOUBLE -> "real";
            case STRING -> "string";
            case BOOLEAN -> "booleano";
            case VOID -> "vazio";
            case ERROR -> "error";
        };
    }
}
