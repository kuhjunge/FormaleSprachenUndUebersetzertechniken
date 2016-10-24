package muell.exprLexer;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import collections.stack.*;
import postFix.lexer.*;

public class PostFixOld {

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
				switch (t.getType()) {
				case ExprLexer.PLUS:
					add(s);
					break;
				case ExprLexer.MINUS:
					sub(s);
					break;
				case ExprLexer.INV:
					inv(s);
					break;
				case ExprLexer.MUL:
					mul(s);
					break;
				case ExprLexer.DIV:
					div(s);
					break;
				case ExprLexer.EXP:
					pow(s);
					break;
				case ExprLexer.FAC:
					fac(s);
					break;
				default:
					break;
				}
			}
			t = n.nextToken();
		}
		return s.popTop();
	}

	private static void add(Stack<Double> s) {
		s.push(s.popTop() + s.popTop());
	}

	private static void fac(Stack<Double> s) {
		double erg = 1;
		double var = s.popTop();
		for (double i = 1; i <= var; i++) {
			erg = erg * i;
		}
		s.push(erg);
	}

	private static void pow(Stack<Double> s) {
		double e = s.popTop();
		double f = s.popTop();
		s.push(Math.pow(f, e));
	}

	private static void div(Stack<Double> s) {
		double a = s.popTop();
		double b = s.popTop();
		s.push(b / a);
	}

	private static void mul(Stack<Double> s) {
		s.push(s.popTop() * s.popTop());
	}

	private static void inv(Stack<Double> s) {
		s.push(s.popTop() * (-1));
	}

	private static void sub(Stack<Double> s) {
		double c = s.popTop();
		double d = s.popTop();
		s.push(d - c);
	}
}
