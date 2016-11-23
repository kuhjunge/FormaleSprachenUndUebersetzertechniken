package postFix;

import static org.junit.Assert.*;
import org.junit.Test;

import postFix.Exception.PostFixExpressionException;

public class TestSuitePostfix {

	public static final String end = "\n";

	@Test
	public void expTest() throws Exception {
		double test = Postfix.evalPostfix("4 5 ^" + end);
		System.out.println(test);
		assertTrue(test == 1024);
	}

	@Test
	public void expTestS() throws Exception {
		double test = Postfix.evalPostfix("4 5 EXP" + end);
		System.out.println(test);
		assertTrue(test == 1024);
	}
	
	@Test
	public void addTest() throws Exception {
		double test = Postfix.evalPostfix("4 5 +" + end);
		System.out.println(test);
		assertTrue(test == 9);
	}
	
	@Test
	public void addTestS() throws Exception {
		double test = Postfix.evalPostfix("4 5 ADD" + end);
		System.out.println(test);
		assertTrue(test == 9);
	}

	@Test
	public void subTest() throws Exception {
		double test = Postfix.evalPostfix("4 5 -" + end);
		System.out.println(test);
		assertTrue(test == -1);
	}

	@Test
	public void subTestS() throws Exception {
		double test = Postfix.evalPostfix("4 5 SUB" + end);
		System.out.println(test);
		assertTrue(test == -1);
	}
	
	@Test
	public void divTest() throws Exception {
		double test = Postfix.evalPostfix("4 5 /" + end);
		System.out.println(test);
		assertTrue(test == 0.8);
	}
	
	@Test
	public void divTestS() throws Exception {
		double test = Postfix.evalPostfix("4 5 DIV" + end);
		System.out.println(test);
		assertTrue(test == 0.8);
	}

	@Test
	public void mulTest() throws Exception {
		double test = Postfix.evalPostfix("4 5 *" + end);
		System.out.println(test);
		assertTrue(test == 20);
	}
	
	@Test
	public void mulTestS() throws Exception {
		double test = Postfix.evalPostfix("4 5 MUL" + end);
		System.out.println(test);
		assertTrue(test == 20);
	}

	@Test
	public void negTestS() throws Exception {
		double test = Postfix.evalPostfix("4 INV" + end);
		System.out.println(test);
		assertTrue(test == -4);
	}
	
	@Test
	public void negTest() throws Exception {
		double test = Postfix.evalPostfix("4 #" + end);
		System.out.println(test);
		assertTrue(test == -4);
	}

	@Test
	public void neg2Test() throws Exception {
		double test = Postfix.evalPostfix(" -4 " + end);
		System.out.println(test);
		assertTrue(test == -4);
	}

	@Test
	public void neg3Test() throws Exception {
		double test = Postfix.evalPostfix(" -0.4 " + end);
		System.out.println(test);
		assertTrue(test == -0.4);
	}

	@Test
	public void neg5Test() throws Exception {
		double test = Postfix.evalPostfix(" -4 -5 - " + end);
		System.out.println(test);
		assertTrue(test == 1);
	}

	@Test
	public void facTest() throws Exception {
		double test = Postfix.evalPostfix(" 5 !" + end);
		System.out.println(test);
		assertTrue(test == 120);
	}

	@Test
	public void facTestS() throws Exception {
		double test = Postfix.evalPostfix(" 5 FAC" + end);
		System.out.println(test);
		assertTrue(test == 120);
	}
	
	@Test
	public void completeTest1() throws Exception {
		double test = Postfix.evalPostfix("3 # 3 8 4 / 2 ^ * 9 - +" + end);
		System.out.println(test);
		assertTrue(test == 0.0);
	}

	@Test
	public void completeTest2() throws Exception {
		double test = Postfix.evalPostfix("2 4 + ! 11 4 + /" + end);
		System.out.println(test);
		assertTrue(test == 48.0);
	}

	@Test
	public void completeTest3() throws Exception {
		double test = Postfix.evalPostfix("4 5 ^ 5 2 * / 10 +" + end);
		System.out.println(test);
		assertTrue(test == 112.4);
	}

	@Test
	public void completeTest4() throws Exception {
		double test = Postfix.evalPostfix("4 5 ^ 5 2 * / 4! +" + end);
		System.out.println(test);
		assertTrue(test == 126.4);
	}

	@Test
	public void doubleTest() throws Exception {
		double test = Postfix.evalPostfix("4.0 5 ^ 5.0 2 * / 4! +" + end);
		System.out.println(test);
		assertTrue(test == 126.4);
	}

	@Test
	public void double2Test() throws Exception {
		double test = Postfix.evalPostfix(".4 0.5 +" + end);
		System.out.println(test);
		assertTrue(test == 0.9);
	}

	@Test
	public void simon1Test() throws Exception { // ( -(((10 + 2 - 5) * 2) + 6) /
												// 20) ^ 1
		double test = Postfix.evalPostfix("10 2 + 5 - 2 * # 6 + 20 / 1 ^" + end);
		System.out.println(test);
		assertTrue(test == -0.4);
	}

	@Test
	public void simon2Test() throws Exception {
		double test = Postfix.evalPostfix("10 2 +" + end);
		System.out.println(test);
		assertTrue(test == 12);
	}
	
	@Test(expected = PostFixExpressionException.class)
	public void errorTest1() throws Exception {
		Postfix.evalPostfix("" + end);
	}
	
	@Test(expected = PostFixExpressionException.class)
	public void errorTest2() throws Exception {
		Postfix.evalPostfix("+" + end);
	}
}
