package SemanticAnalysis.ErrorsReport;

import org.antlr.v4.runtime.ParserRuleContext;

public record SemanticError(ParserRuleContext ctx, String message) {
    public String toString() {
        if (ctx == null) return message;
        return "erro na linha " + ctx.getStart().getLine() + ":" + " " + message;
    }
}
