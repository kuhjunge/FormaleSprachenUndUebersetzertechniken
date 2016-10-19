package postFix;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import collections.stack.*;
import lexer.*;

public class Postfix {

	/**
	 * Startet die Verarbeitung eines Postfix Ausdrucks mit dem Lexer
	 * 
	 * @param eingabe
	 *            PostFix Ausdruck
	 * @return Postfix Wert
	 */
	public static double evalPostfix(String eingabe) {
		ANTLRInputStream input = new ANTLRInputStream(eingabe.toCharArray(), eingabe.length());
		ExprLexer n = new ExprLexer(input);
		return calculatePostfix(n);
	}

	/**
	 * Verarbeitet die Token, die der Lexer generiert
	 * 
	 * @param n
	 *            ExpressionLexer
	 * @return Postfix Wert
	 */
	private static double calculatePostfix(ExprLexer n) {
		Stack<Double> s = new ArrayStack<>();
		MathOperationFactory mof = MathOperationFactory.init();
		Token t = n.nextToken();
		while (t.getType() != Recognizer.EOF) {
			if (t.getType() == ExprLexer.INT || t.getType() == ExprLexer.FLOAT) {
				s.push(Double.parseDouble(t.getText()));
			} else {
				mof.executeCommand(t.getType(), s);
			}
			t = n.nextToken();
		}
		return s.popTop();
	}
}
