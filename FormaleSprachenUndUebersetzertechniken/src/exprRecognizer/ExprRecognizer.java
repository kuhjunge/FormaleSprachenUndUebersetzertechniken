package exprRecognizer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ExprRecognizer {

/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}*/
	
	public static String getTreeString(String expression){
		ParseTree tree = getTree(expression);
//		System.out.println(tree.toStringTree(parser));
		return tree.toStringTree();
	}
	
	public static boolean isValid(String expression){
		ParseTree tree = getTree(expression);
		if (tree.getChild(0).getChildCount()> 0){
			return true;
		}
		return false;
	}

	private static ParseTree getTree(String expression) {
		ExprRecogLexer lexer = new ExprRecogLexer(new ANTLRInputStream(expression) );
		
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		// create a parser that feeds off the tokens buffer
		ExprRecogParser parser = new ExprRecogParser(tokens);
		
		ParseTree tree = parser.allTokens(); // begin parsing at init rule
		return tree;
	}

}
