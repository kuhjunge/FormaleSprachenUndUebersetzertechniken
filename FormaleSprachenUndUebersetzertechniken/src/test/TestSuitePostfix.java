package test;

import static org.junit.Assert.*;

import org.junit.Test;

import postFix.Postfix;

public class TestSuitePostfix {

	public static final String end = "\n";
	@Test
	public void expTest() {
		double test = Postfix.evalPostfix("4 5 ^" + end);
		System.out.println(test);
		assertTrue(test == 1024);
	}
	
	@Test
	public void addTest() {
		double test = Postfix.evalPostfix("4 5 +" + end);
		System.out.println(test);
		assertTrue(test == 9);
	}
	
	@Test
	public void subTest() {
		double test = Postfix.evalPostfix("4 5 -" + end);
		System.out.println(test);
		assertTrue(test == -1);
	}
	
	@Test
	public void divTest() {
		double test = Postfix.evalPostfix("4 5 /" + end);
		System.out.println(test);
		assertTrue(test == 0.8);
	}
	
	@Test
	public void mulTest() {
		double test = Postfix.evalPostfix("4 5 *" + end);
		System.out.println(test);
		assertTrue(test == 20);
	}
	
	@Test
	public void negTest() {
		double test = Postfix.evalPostfix("4 #" + end);
		System.out.println(test);
		assertTrue(test == -4);
	}
	
	@Test
	public void neg2Test() {
		double test = Postfix.evalPostfix(" -4 " + end);
		System.out.println(test);
		assertTrue(test == -4);
	}
	
	@Test
	public void neg3Test() {
		double test = Postfix.evalPostfix(" -0.4 " + end);
		System.out.println(test);
		assertTrue(test == -0.4);
	}
	
	@Test
	public void neg5Test() {
		double test = Postfix.evalPostfix(" -4 -5 - " + end);
		System.out.println(test);
		assertTrue(test == 1);
	}
	
	@Test
	public void facTest() {
		double test = Postfix.evalPostfix(" 5 !" + end);
		System.out.println(test);
		assertTrue(test == 120);
	}
	
	@Test
	public void completeTest1() {
		double test = Postfix.evalPostfix("3 # 3 8 4 / 2 ^ * 9 - +"+ end);
		System.out.println(test);
		assertTrue(test == 0.0);
	}

	@Test
	public void completeTest2() {
		double test = Postfix.evalPostfix("2 4 + ! 11 4 + /"+ end);
		System.out.println(test);
		assertTrue(test == 48.0);
	}

	@Test
	public void completeTest3() {
		double test = Postfix.evalPostfix("4 5 ^ 5 2 * / 10 +"+ end);
		System.out.println(test);
		assertTrue(test == 112.4);
	}

	@Test
	public void completeTest4() {
		double test = Postfix.evalPostfix("4 5 ^ 5 2 * / 4! +"+ end);
		System.out.println(test);
		assertTrue(test == 126.4);
	}
	
	@Test
	public void doubleTest() {
		double test = Postfix.evalPostfix("4.0 5 ^ 5.0 2 * / 4! +"+ end);
		System.out.println(test);
		assertTrue(test == 126.4);
	}

	@Test
	public void double2Test() {
		double test = Postfix.evalPostfix(".4 0.5 +" + end);
		System.out.println(test);
		assertTrue(test == 0.9);
	}
	
	@Test
	public void simon1Test() { // ( -(((10 + 2 - 5) * 2) + 6) / 20) ^ 1
		double test = Postfix.evalPostfix("10 2 + 5 - 2 * # 6 + 20 / 1 ^" + end);
		System.out.println(test);
		assertTrue(test == -0.4);
	}
	
	
	@Test
	public void simon2Test() {
		double test = Postfix.evalPostfix("10 2 +" + end);
		System.out.println(test);
		assertTrue(test == 12);
	}
	
}
