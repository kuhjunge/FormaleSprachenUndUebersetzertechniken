package exprRecognizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExprRecognizerTestSuite {
	public static final String end = "\n";
	@Test
	public void expr1() {
		assertTrue(ExprRecognizer.isValid( "10 + 20" + end));
	}
	
	@Test
	public void expr2() {
		assertTrue( !ExprRecognizer.isValid( "10 +swewe 20" + end) );
	}
	
	@Test
	public void expr3() {
		assertTrue(ExprRecognizer.isValid( "a = (10 + 20)*5+b " + end));
	}
	
	@Test
	public void expr4() {
		assertTrue(ExprRecognizer.isValid( "b > a" + end));
	}
	
	@Test
	public void expr5() {
		assertTrue(ExprRecognizer.isValid("10^10"+ end));
	}

}
