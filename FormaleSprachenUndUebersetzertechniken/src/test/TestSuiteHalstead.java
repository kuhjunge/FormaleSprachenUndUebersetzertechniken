package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.junit.Test;

import collections.list.*;
import halstead.*;
import muell.HalsteadLexer;
import halstead.lexer.*;


import static org.junit.Assert.*;

public class TestSuiteHalstead {
	
	public static void halsteadOld(String file, String name) {
		System.out.println();
		System.out.println("Test " + name);
		halsteadOld(file);
	}
	
	public static void halstead(String file, String name) {
		System.out.println();
		System.out.println("Test " + name);
		halstead(file);
	}

	public static void halsteadOld(String file){
		Multiset<String> listOperator = new LinkedListMultiset<>(
				LinkedList.FRONT);
		Multiset<String> listOperant = new LinkedListMultiset<>(
				LinkedList.FRONT);
		org.antlr.runtime.CharStream input = null;
		File bla = new File(file);
		try( FileInputStream str = new FileInputStream(bla) ){
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
		Halstead<String> h = new Halstead<>(listOperator,listOperant);
		System.out.println(h);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void halstead(String file){
		Multiset<String> listOperator = new LinkedListMultiset<>(
				LinkedList.FRONT);
		Multiset<String> listOperant = new LinkedListMultiset<>(
				LinkedList.FRONT);
		CharStream input = null;
		File bla = new File(file);
		try( FileInputStream str = new FileInputStream(bla) ){
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
		Halstead<String> h = new Halstead<>(listOperator,listOperant);
		System.out.println(h);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	public void testOld() {
		try {
			final String pfad = "C:\\Users\\Kuhjunge\\Documents\\Kuhjunge\\Documents\\Study\\_archive\\Inf II\\Praktika\\Halstead mit LinkedListMultiset\\";
			halsteadOld(pfad + "ggt1.c", "ggt1");
			halsteadOld(pfad + "ggt2.c", "ggt2");
			halsteadOld(pfad + "Beispiel2.c", "Beispiel2");
			halsteadOld(pfad + "main.c", "main");
			halsteadOld(pfad + "eval1.c", "eval1");
			halsteadOld(pfad + "extract.c", "extract");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Fehler!");
		}
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
