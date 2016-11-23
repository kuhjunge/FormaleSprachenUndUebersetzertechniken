// Generated from Expr.g4 by ANTLR 4.4
package postFix.lexer;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull ExprParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull ExprParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(@NotNull ExprParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(@NotNull ExprParser.TestContext ctx);
}