package postFix;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import collections.stack.*;
import lexer.*;

public class Postfix {

	public static double evalPostfix(String eingabe) {
		ANTLRInputStream input = new ANTLRInputStream(eingabe.toCharArray(), eingabe.length());
		ExprLexer n = new ExprLexer(input);
		return calculatePostfix(n);
	}

	private static double calculatePostfix(ExprLexer n) {
		Stack<Double> s = new ArrayStack<>();
		Token t = n.nextToken();
		while (t.getType() != Recognizer.EOF) {
			if (t.getType() == ExprLexer.INT) {
				s.push(Double.parseDouble(t.getText()));
			} else {
				MathOperationFactory mof= MathOperationFactory.init();
				mof.executeCommand(t.getType(), s);
			}
			t = n.nextToken();
		}
		return s.popTop();
	}
}
