package SemanticAnalysis.ErrorsReport;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

public class ErrorReporter {
    private final List<SemanticError> errors = new ArrayList<>();
    private final Set<Integer> reportedLines = new HashSet<>();

    public void report(ParserRuleContext ctx, String message) {
        int line = ctx.getStart().getLine();
        if (!reportedLines.contains(line)) {
            errors.add(new SemanticError(ctx, message));
            reportedLines.add(line);
        }
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void showErrors() {
        errors.stream()
                .sorted(Comparator.comparingInt(e -> e.ctx().getStart().getLine()))
                .forEach(System.out::println);
    }
}
