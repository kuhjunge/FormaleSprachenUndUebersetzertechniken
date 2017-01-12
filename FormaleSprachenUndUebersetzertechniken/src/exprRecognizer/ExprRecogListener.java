// Generated from ExprRecog.g4 by ANTLR 4.6
package exprRecognizer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprRecogParser}.
 */
public interface ExprRecogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprRecogParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ExprRecogParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprRecogParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ExprRecogParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprRecogParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprRecogParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprRecogParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprRecogParser.ExprContext ctx);
}