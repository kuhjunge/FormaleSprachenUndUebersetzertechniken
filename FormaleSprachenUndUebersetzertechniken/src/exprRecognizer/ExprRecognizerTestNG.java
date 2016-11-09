package exprRecognizer;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class ExprRecognizerTestNG {
	@SuppressWarnings("static-method")
	@Test(dataProvider = "dp")
	public void f(String input, Boolean b, String output) {
		Boolean erg = ExprRecognizer.isValid(input);
		Assert.assertEquals(erg, b);
		Assert.assertTrue(ExprRecognizer.getTreeString(input).contains(output));
	}

	@SuppressWarnings("static-method")
	@DataProvider
	public Object[][] dp() {
		final String end = "\n";
		return new Object[][] { 
				new Object[] { "10 + 20" + end, true, "" },
				new Object[] { "10 +swewe 20" + end, false, "" }, 
				new Object[] { "a = (10 + 20)*5+b " + end, true, "" },
				new Object[] { "b > a" + end, true, "" }, 
				new Object[] { "10^10" + end, true, "" } 
				};
	}
}
