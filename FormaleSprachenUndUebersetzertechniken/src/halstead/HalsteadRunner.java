package halstead;

import java.io.File;
import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

import collections.list.LinkedList;
import collections.list.LinkedListMultiset;
import collections.list.Multiset;
import halstead.lexer.CLexer;
import muell.HalsteadLexer;

public class HalsteadRunner {

	public static HalsteadData halstead(String file) {
		Multiset<String> listOperator = new LinkedListMultiset<>(LinkedList.FRONT);
		Multiset<String> listOperant = new LinkedListMultiset<>(LinkedList.FRONT);
		CharStream input = null;
		File bla = new File(file);
		try (FileInputStream str = new FileInputStream(bla)) {
			System.setIn(str);
			input = new ANTLRInputStream(System.in);
			CLexer lex = new CLexer(input);
			Token t = lex.nextToken();
			while (t == null || t.getType() != CLexer.EOF) {// Token.EOF
				if (t.getType() == CLexer.OPERATOR) {
					listOperator.add(t.getText());
				}
				if (t.getType() == CLexer.OPERAND) {
					listOperant.add(t.getText());
				}
				t = lex.nextToken();
			}
			System.out.println(listOperator + "  :: " + listOperator.size());
			System.out.println(listOperant + "  :: " + listOperant.size());
			Halstead<String> h = new Halstead<>(listOperator, listOperant);
			System.out.println(h);
			return h.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static HalsteadData halsteadOld(String file) {
		Multiset<String> listOperator = new LinkedListMultiset<>(LinkedList.FRONT);
		Multiset<String> listOperant = new LinkedListMultiset<>(LinkedList.FRONT);
		org.antlr.runtime.CharStream input = null;
		File bla = new File(file);
		try (FileInputStream str = new FileInputStream(bla)) {
			System.setIn(str);
			input = new org.antlr.runtime.ANTLRInputStream(System.in);
			HalsteadLexer lex = new HalsteadLexer(input);
			org.antlr.runtime.Token t = lex.nextToken();
			while (t == null || t.getType() != HalsteadLexer.EOF) {// Token.EOF
				if (t.getType() == HalsteadLexer.OPERATOR) {
					listOperator.add(t.getText());
				}
				if (t.getType() == HalsteadLexer.OPERAND) {
					listOperant.add(t.getText());
				}
				t = lex.nextToken();
			}
			System.out.println(listOperator + "  :: " + listOperator.size());
			System.out.println(listOperant + "  :: " + listOperant.size());
			Halstead<String> h = new Halstead<>(listOperator, listOperant);
			System.out.println(h);
			return h.getData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
