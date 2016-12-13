// Generated from Expr.g4 by ANTLR 4.5.3
package postFix.lexer;
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
	void enterR(ExprParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(ExprParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(ExprParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(ExprParser.TestContext ctx);
}