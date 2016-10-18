package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.runtime.*;
import org.junit.Test;

import collections.list.*;
import halstead.*;

import static org.junit.Assert.*;

public class TestSuiteHalstead {
	
	public static void halstead(String file, String name) throws IOException {
		System.out.println();
		System.out.println("Test " + name);
		halstead(file);
	}
	
	public static void halstead(String file) throws IOException {
		Multiset<String> listOperator = new LinkedListMultiset<>(
				LinkedList.FRONT);
		Multiset<String> listOperant = new LinkedListMultiset<>(
				LinkedList.FRONT);
		CharStream input = null;
		File bla = new File(file);
		System.setIn(new FileInputStream(bla));
		input = new ANTLRInputStream(System.in);
		HalsteadLexer lex = new HalsteadLexer(input);
		Token t = lex.nextToken();
		while (t == null || t.getType() != HalsteadLexer.EOF) {// Token.EOF
																// works as
			if (t.getType() == HalsteadLexer.OPERATOR) {
				listOperator.add(t.getText());
			}
			if (t.getType() == HalsteadLexer.OPERAND) {
				listOperant.add(t.getText());
			}
			t = lex.nextToken();
		}

		Halstead<String> h = new Halstead<>(listOperator,listOperant);
		System.out.println(h);
	}
	
	@Test
	public void test() {
		try {
			final String pfad = "C:\\Users\\Kuhjunge\\Documents\\Kuhjunge\\Documents\\Study\\_archive\\Inf II\\Praktika\\Halstead mit LinkedListMultiset\\";
			halstead(pfad + "ggt1.c", "ggt1");
			halstead(pfad + "ggt2.c", "ggt2");
			halstead(pfad + "Beispiel2.c", "Beispiel2");
			halstead(pfad + "main.c", "main");
			halstead(pfad + "eval1.c", "eval1");
			halstead(pfad + "extract.c", "extract");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Fehler!");
		}
	}
}
