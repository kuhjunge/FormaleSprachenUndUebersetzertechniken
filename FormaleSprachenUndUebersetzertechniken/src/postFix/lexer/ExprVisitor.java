// Generated from Expr.g4 by ANTLR 4.6
package postFix.lexer;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(ExprParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(ExprParser.TestContext ctx);
}