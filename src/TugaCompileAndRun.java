import CodeGenerator.CodeGen;
import SVM.Svm;
import SVM.SvmUtil;
import SemanticAnalysis.DefinitionPhase.DefPhase;
import SemanticAnalysis.ErrorsReport.ErrorReporter;
import SemanticAnalysis.ReferencePhase.RefPhase;
import SemanticAnalysis.ErrorsReport.MyErrorListener;
import Tuga.TugaLexer;
import Tuga.TugaParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.*;

public class TugaCompileAndRun {
    static boolean showLexerErrors = false;
    static boolean showParserErrors = false;
    static boolean showTypeCheckingErrors = true;
    static boolean showAsmGeneratedCode = true;
    static boolean showByteCodes = false;
    static boolean showStackTrace = true;

    public static void main(String[] args) {
        try {
            CharStream input = args.length > 0 ?
                    CharStreams.fromFileName(args[0]) :
                    CharStreams.fromStream(System.in);

            TugaLexer lexer = new TugaLexer(input);
            MyErrorListener errorListener = new MyErrorListener(showLexerErrors, showParserErrors);
            lexer.removeErrorListeners();
            lexer.addErrorListener(errorListener);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            TugaParser parser = new TugaParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);

            ParseTree tree = parser.program();
            if (errorListener.getNumLexerErrors() > 0) {
                System.out.println("Input tem erros lexicais");
                return;
            }

            if (errorListener.getNumParsingErrors() > 0) {
                System.out.println("Input tem erros de parsing");
                return;
            }

            ErrorReporter reporter = new ErrorReporter();

            ParseTreeWalker walker = new ParseTreeWalker();
            DefPhase defPhase = new DefPhase(reporter);
            walker.walk(defPhase, tree);

            RefPhase refPhase = new RefPhase(defPhase.scopes, defPhase.globalScope, reporter);
            refPhase.visit(tree);

            if (reporter.hasErrors()) {
                if (showTypeCheckingErrors) reporter.showErrors();
                return;
            }

            CodeGen codeGen = new CodeGen(refPhase.getTypes(), defPhase.globalScope, defPhase.scopes);
            codeGen.visit(tree);
            if(showAsmGeneratedCode)
                codeGen.dumpCode();

            codeGen.saveBytecodes("bytecodes.bc");

            if(showByteCodes)
                Util.ByteCodeReader.readBytecodeFile("bytecodes.bc");

            byte[] bytecodes = SvmUtil.loadBytecodes("bytecodes.bc");
            Svm vm = new Svm(bytecodes, showStackTrace);
            vm.setFunctionInfos(codeGen.getFunctionInfos());

            vm.run();
        } catch (IOException e) {
            System.err.println("Erro a ler input: " + e.getMessage());
        }
    }
}