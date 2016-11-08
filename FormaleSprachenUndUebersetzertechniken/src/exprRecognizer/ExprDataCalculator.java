package exprRecognizer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ExprDataCalculator {
	
	boolean err = true;
	public ExprRecogParser parser;
	public ParseTree tree;
	public String strRepresentation = "";
	
	public ExprDataCalculator(String str){
		this.err = false;
		ExprRecogLexer lexer = new ExprRecogLexer(new ANTLRInputStream(str));
		lexer.addErrorListener(ExprRecogErrorListener.INSTANCE);
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		//this.err = checkErr();
		// create a parser that feeds off the tokens buffer
		this.parser = new ExprRecogParser(tokens);
		this.parser.addErrorListener(ExprRecogErrorListener.INSTANCE);
		this.tree = this.parser.stat(); // begin parsing at init rule
		this.err = checkErr();
		this.strRepresentation = this.tree.toStringTree(this.parser);
	}
	
	public static boolean checkErr() {
		boolean err = false;
		if (ExprRecogErrorListener.err) {
			err = true;
		}
		ExprRecogErrorListener.clearErr();
		return err;
	}
}
