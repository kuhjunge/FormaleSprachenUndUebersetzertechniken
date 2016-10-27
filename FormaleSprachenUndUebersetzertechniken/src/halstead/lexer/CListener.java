// Generated from C.g4 by ANTLR 4.5.3
package halstead.lexer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CParser}.
 */
public interface CListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(CParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(CParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link CParser#allTokens}.
	 * @param ctx the parse tree
	 */
	void enterAllTokens(CParser.AllTokensContext ctx);
	/**
	 * Exit a parse tree produced by {@link CParser#allTokens}.
	 * @param ctx the parse tree
	 */
	void exitAllTokens(CParser.AllTokensContext ctx);
}