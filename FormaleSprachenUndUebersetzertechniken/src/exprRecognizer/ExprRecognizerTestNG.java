package exprRecognizer;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class ExprRecognizerTestNG {
	@SuppressWarnings("static-method")
	@Test(dataProvider = "dp")
	public void f(String input, Boolean b, String output) {
		ExprRecognizer exRec = new ExprRecognizer(input);
		Boolean erg = exRec.isValid();
		Assert.assertEquals(erg, b);
		String str = exRec.getTreeString();
		Assert.assertNotNull(str);
		System.out.println(str);
		Assert.assertTrue((exRec.getTreeString()).contains(output));
	}

	@SuppressWarnings("static-method")
	@DataProvider
	public Object[][] dp() {
		final String end = "\n";
		return new Object[][] { 
			new Object[] { " 10 + 20 " + end		,true, 	"(expr (expr 10) + (expr 20))" },
			new Object[] { " 10 + swewe 20 " + end	,false,	" " }, 
			new Object[] { "a=(10+20)*5+b" + end	,true, 	"(expr (expr a) = (expr (expr (expr ( (expr (expr 10) + (expr 20)) )) * (expr 5)) + (expr b)))" },
			new Object[] { "b > a" + end			,true, 	"(expr (expr b) > (expr a))" },
			new Object[] { "6 > 7 ^ 1 + 5" + end	,true, 	"(expr (expr 6) > (expr (expr (expr 7) ^ (expr 1)) + (expr 5)))" }, 
			new Object[] { "10^10^10" + end			,true, 	"(expr (expr 10) ^ (expr (expr 10) ^ (expr 10)))" },
			new Object[] { "10 + - 20" + end		,false,	" " } 	
			};
	}
}
