// Generated from ExprRecog.g4 by ANTLR 4.5.3
package exprRecognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprRecogParser}.
 */
public interface ExprRecogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprRecogParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(ExprRecogParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprRecogParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(ExprRecogParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprRecogParser#allTokens}.
	 * @param ctx the parse tree
	 */
	void enterAllTokens(ExprRecogParser.AllTokensContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprRecogParser#allTokens}.
	 * @param ctx the parse tree
	 */
	void exitAllTokens(ExprRecogParser.AllTokensContext ctx);
}