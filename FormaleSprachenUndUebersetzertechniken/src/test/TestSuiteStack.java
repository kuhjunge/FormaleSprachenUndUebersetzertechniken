package test;

import static org.junit.Assert.*;

import org.junit.Test;

import collections.stack.ArrayStack;
import collections.stack.*;
import collections.stack.Stack;

public class TestSuiteStack {

	@Test
	public void arrayTest() {
		System.out.println("---- Start Array Test ----");
		String teststring = "Hello World";
		Stack<Character> a = new ArrayStack<>(teststring.length());
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
		
		// erstelle kopie des Arraystack
		Stack<Character> b = new ArrayStack<>(a,teststring.length());
		Stack<Character> c = new ArrayStack<>();
		Stack<Character> d = new ArrayStack<>(-1);
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

	@Test
	public void listTest() {
		System.out.println("---- Start List Test ----");
		Stack<Character> a = new ListStack<>();
		String teststring = "Hello World";
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

		// Überprüfung auf überlauf bei push fällt weg, da flexible Größe
		/*
		 * try { a.push('!'); fail("Sollte Fehlschlagen da'Stack voll!"); }
		 * catch (StackFehler e) { }
		 */

		System.out.println("--------");

		for (int i = 0; i < teststring.length(); i++) {
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

		a.multiPop(9999);


	}
}
