// Generated from C:/3ANO_2VEZ/Compiladores/Tuga/Tuga/src/Tuga.g4 by ANTLR 4.13.1
package Tuga;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TugaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TugaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TugaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TugaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(TugaParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(TugaParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(TugaParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(TugaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TugaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Print}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(TugaParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Afection}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfection(TugaParser.AfectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(TugaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(TugaParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfElse}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(TugaParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(TugaParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidFunctionCall}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidFunctionCall(TugaParser.VoidFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Empty}
	 * labeled alternative in {@link TugaParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(TugaParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(TugaParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(TugaParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#enquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnquanto(TugaParser.EnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link TugaParser#seSenao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeSenao(TugaParser.SeSenaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(TugaParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(TugaParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(TugaParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code E}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(TugaParser.EContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OU}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOU(TugaParser.OUContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(TugaParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code String}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(TugaParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble(TugaParser.DoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(TugaParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equility}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquility(TugaParser.EquilityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCallExpr}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpr(TugaParser.FunctionCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultDivMod}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivMod(TugaParser.MultDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(TugaParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parentheses}
	 * labeled alternative in {@link TugaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentheses(TugaParser.ParenthesesContext ctx);
}