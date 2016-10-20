package postFix;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import lexer.*;
import postFix.Exception.PostFixExpressionException;
import postFix.Exception.UnknownMathOperationException;
import postFix.stack.IStackAdapter;
//import postFix.stack.StackCustom;
import postFix.stack.StackStandard;

public class Postfix {

	/**
	 * Startet die Verarbeitung eines Postfix Ausdrucks mit dem Lexer
	 * 
	 * @param eingabe
	 *            PostFix Ausdruck
	 * @return Postfix Wert
	 *  @throws UnknownMathOperationException 
	 * @throws PostFixExpressionException 
	 */
	public static double evalPostfix(String eingabe) throws UnknownMathOperationException, PostFixExpressionException {
		ANTLRInputStream input = new ANTLRInputStream(eingabe.toCharArray(), eingabe.length());
		ExprLexer n = new ExprLexer(input);
		if (eingabe.length() < 2){
			throw new PostFixExpressionException("Ausdruck ist zu kurz");
		}
		return calculatePostfix(n);
	}

	/**
	 * Verarbeitet die Token, die der Lexer generiert
	 * 
	 * @param n
	 *            ExpressionLexer
	 * @return Postfix Wert
	 * @throws UnknownMathOperationException 
	 * @throws PostFixExpressionException 
	 */
	private static double calculatePostfix(ExprLexer n) throws  PostFixExpressionException{
		IStackAdapter<Double> s = new StackStandard<>();
		MathOperationFactory mof = MathOperationFactory.init();
		Token t = n.nextToken();
		while (t.getType() != Recognizer.EOF) {
			if (t.getType() == ExprLexer.INT || t.getType() == ExprLexer.FLOAT) {
				s.push(Double.parseDouble(t.getText()));
			} else {
				tryCommand(s, mof, t);
			}
			t = n.nextToken();
		}
		return getFinalStackNumber(s);
	}

	private static void tryCommand(IStackAdapter<Double> s, MathOperationFactory mof, Token t)
			throws PostFixExpressionException  {
		try {
		mof.executeCommand(t.getType(), s);
		} catch(Exception e){
			throw new PostFixExpressionException("Ausdruck nicht gültig! (" + e.getMessage()+")");
		}
	}

	private static Double getFinalStackNumber(IStackAdapter<Double> s) throws PostFixExpressionException {
		if (s.isEmpty() || s.size() > 1){
			throw new PostFixExpressionException("Stack enthält zu viel oder zu wenige Elemente");
		}
		return s.pop();
	}
}
