package halstead;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

/**
 *  AssertJ angucken
 */
public class TestNGHalstead {
	@SuppressWarnings("static-method")
	@Test(dataProvider = "dp")
	public void f(Double[] n, String s) {
		HalsteadData hd = HalsteadRunner.halstead(s);
		Assert.assertNotNull(hd);
		Assert.assertTrue(hd.N == n[0]);

		Assert.assertEquals(hd.N, n[0], 0);

		Assert.assertTrue(hd.N1 == n[1]);
		Assert.assertTrue(hd.N2 == n[2]);
		Assert.assertTrue(hd.n == n[3]);
		Assert.assertTrue(hd.n1 == n[4]);
		Assert.assertTrue(hd.n2 == n[5]);
		Assert.assertTrue(hd.V == n[6]);
		Assert.assertTrue(hd.D == n[7]);
		Assert.assertTrue(hd.E == n[8]);
		System.out.println(hd.toString());
	}

	@SuppressWarnings("static-method")
	@DataProvider
	public Object[][] dp() {
		final String pfad = "C:\\Users\\Kuhjunge\\Documents\\Kuhjunge\\Documents\\Study\\_archive\\Inf II\\Praktika\\Halstead mit LinkedListMultiset\\";
		final Double[] ggt1 = { 30.0, 15.0, 15.0, 15.0, 11.0, 4.0, 117.20671786825557, 15.0, 1758.1007680238336 };
		final Double[] ggt2 = { 35.0, 17.0, 18.0, 15.0, 9.0, 6.0, 136.74117084629816, 12.0, 1640.894050155578 };
		final Double[] Beispiel2 = { 390.0, 213.0, 177.0, 68.0, 25.0, 43.0, 2374.1105080876328, 48.0,
				113957.30438820636 };
		final Double[] main = { 39.0, 20.0, 19.0, 22.0, 10.0, 12.0, 173.9178331268546, 5.0, 869.589165634273 };
		final Double[] eval1 = { 279.0, 157.0, 122.0, 52.0, 22.0, 30.0, 1590.4226813613648, 44.0, 69978.59797990005 };
		final Double[] extract = { 55.0, 29.0, 26.0, 21.0, 10.0, 11.0, 241.57745825283183, 10.0, 2415.774582528318 };

		return new Object[][] { 
			new Object[] { ggt1, pfad + "ggt1.c" },
			new Object[] { ggt2, pfad + "ggt2.c" },
				new Object[] { Beispiel2, pfad + "Beispiel2.c" },
				new Object[] { main, pfad + "main.c" },
				new Object[] { eval1, pfad + "eval1.c" },
				new Object[] { extract, pfad + "extract.c" }, };
	}
}
