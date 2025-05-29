// Generated from C:/3ANO_2VEZ/Compiladores/Tuga/Tuga/src/Tuga.g4 by ANTLR 4.13.1
package Tuga;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TugaParser}.
 */
public interface TugaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TugaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TugaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TugaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(TugaParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(TugaParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(TugaParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(TugaParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(TugaParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(TugaParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(TugaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(TugaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TugaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TugaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Print}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterPrint(TugaParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitPrint(TugaParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Afection}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterAfection(TugaParser.AfectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Afection}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitAfection(TugaParser.AfectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Block}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterBlock(TugaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitBlock(TugaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterWhile(TugaParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitWhile(TugaParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(TugaParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(TugaParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterReturn(TugaParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitReturn(TugaParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidFunctionCall}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterVoidFunctionCall(TugaParser.VoidFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidFunctionCall}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitVoidFunctionCall(TugaParser.VoidFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Empty}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(TugaParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Empty}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(TugaParser.EmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(TugaParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(TugaParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(TugaParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(TugaParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void enterEnquanto(TugaParser.EnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#enquanto}.
	 * @param ctx the parse tree
	 */
	void exitEnquanto(TugaParser.EnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link TugaParser#seSenao}.
	 * @param ctx the parse tree
	 */
	void enterSeSenao(TugaParser.SeSenaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link TugaParser#seSenao}.
	 * @param ctx the parse tree
	 */
	void exitSeSenao(TugaParser.SeSenaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVariable(TugaParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVariable(TugaParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegation(TugaParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegation(TugaParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(TugaParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(TugaParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code E}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterE(TugaParser.EContext ctx);
	/**
	 * Exit a parse tree produced by the {@code E}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitE(TugaParser.EContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OU}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOU(TugaParser.OUContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OU}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOU(TugaParser.OUContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational(TugaParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational(TugaParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(TugaParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(TugaParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Double}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDouble(TugaParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDouble(TugaParser.DoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(TugaParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(TugaParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equility}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquility(TugaParser.EquilityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equility}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquility(TugaParser.EquilityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpr(TugaParser.FunctionCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpr(TugaParser.FunctionCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivMod(TugaParser.MultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivMod(TugaParser.MultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(TugaParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(TugaParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentheses(TugaParser.ParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentheses(TugaParser.ParenthesesContext ctx);
}