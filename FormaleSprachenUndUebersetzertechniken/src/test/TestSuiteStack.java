package test;

import static org.junit.Assert.*;

import org.junit.Test;

import collections.stack.ArrayStack;
import collections.stack.*;
import collections.stack.Stack;

public class TestSuiteStack {
	
	@Test
	public void arrayTestSize() {
		Stack<Character> a = new ArrayStack<>();
		sizeTest(a);
	}

	@Test
	public void listTestSize() {
		Stack<Character> a = new ListStack<>();
		sizeTest(a);
	}
	
	@Test
	public void arrayTest() {
		System.out.println("---- Start Array Test ----");
		Stack<Character> a = new ArrayStack<>();
		stackTest(a);
	}
	
	@Test
	public void listTest() {
		System.out.println("---- Start List Test ----");
		Stack<Character> a = new ListStack<>();
		stackTest(a);
	}
	
	private static void sizeTest(Stack<Character> a) {
		final String teststring = "Hello World";
		for (int i = 0; i < teststring.length(); i++) {
			a.push(teststring.charAt(i));
		}
		System.out.println(a.enthaelt() +" = " + teststring.length());
		assertTrue(a.enthaelt() == teststring.length());
	}
	

	private static void stackTest(Stack<Character> a) {
		final String teststring = "Hello World";
		String str = new StringBuffer(teststring).reverse().toString();

		try {
			System.out.println(a.top());
			fail("Sollte Fehlschlagen da'Stack leer!");
		} catch (StackFehler e) {
		}
		
		for (int i = 0; i < teststring.length(); i++) {
			a.push(teststring.charAt(i));
			System.out.println(a.top());
		}
		
		// erstelle kopie des Arraystack teststring.length()
		Stack<Character> b = new ArrayStack<>(a,a.enthaelt());

		/*
		 * try { a.push('!'); fail("Sollte Fehlschlagen da'Stack voll!"); }
		 * catch (StackFehler e) { }
		 */
		// Prüfe überlauf
		a.push('!');
		a.pop();

		System.out.println("--------");

		for (int i = 0; i < teststring.length(); i++) 
		{
			assertTrue(a.top() == str.charAt(i));
			System.out.println(a.popTop());
		}

		a.push('!');
		a.pop(); // pop Test

		try { // pop leer
			a.pop();
			fail("Sollte Fehlschlagen da'Stack leer!");
		} catch (StackFehler e) {
		}

		try { // top leer
			a.top();
			fail("Sollte Fehlschlagen da'Stack leer!");
		} catch (StackFehler e) {
		}

		try { // popTop leer
			System.out.println(a.popTop());
			fail("Sollte Fehlschlagen da'Stack leer!");
		} catch (StackFehler e) {
		}

		for (int i = 0; i < teststring.length(); i++) {
			a.push(teststring.charAt(i));
		}
		// Copytest

		a.multiPop(2);
		a.multiPop(9999);
		System.out.println("---- Array Test kopie ----");
		for (int i = 0; i < teststring.length(); i++) {
			System.out.println(b.top());
			assertTrue(b.top() == str.charAt(i));
			b.pop();
		}
		System.out.println("---- Ende  Array Test ----");
	}
}
