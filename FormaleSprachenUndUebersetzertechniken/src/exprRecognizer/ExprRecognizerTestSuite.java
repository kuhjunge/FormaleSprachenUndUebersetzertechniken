package exprRecognizer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExprRecognizerTestSuite {
	public static final String end = "\n";
	@Test
	public void expr1() {
		ExprRecognizer exRec = new ExprRecognizer( "10 + 20" + end);
		assertTrue(exRec.isValid());
	}
	
	@Test
	public void expr2() {
		ExprRecognizer exRec = new ExprRecognizer("10 +swewe 20" + end);
		assertTrue(!exRec.isValid());
	}
	
	@Test
	public void expr3() {
		ExprRecognizer exRec = new ExprRecognizer("a = (10 + 20)*5+b " + end);
		assertTrue(exRec.isValid());
	}
	
	@Test
	public void expr4() {
		ExprRecognizer exRec = new ExprRecognizer("b > a" + end);
		assertTrue(exRec.isValid());
	}
	
	@Test
	public void expr5() {
		ExprRecognizer exRec = new ExprRecognizer("10^10"+ end);
		assertTrue(exRec.isValid());
	}

}
