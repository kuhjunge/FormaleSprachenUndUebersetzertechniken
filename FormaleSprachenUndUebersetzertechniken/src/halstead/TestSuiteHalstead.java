package halstead;

import org.junit.Test;

import halstead.*;
import static org.junit.Assert.*;

public class TestSuiteHalstead {
	final String pfad = "C:\\Users\\Kuhjunge\\Documents\\Kuhjunge\\Documents\\Study\\_archive\\Inf II\\Praktika\\Halstead mit LinkedListMultiset\\";

	final Double[] ggt1 = {30.0, 15.0, 15.0, 15.0, 11.0, 4.0, 117.20671786825557,15.0, 1758.1007680238336};
	final Double[] ggt2 = {35.0,17.0,18.0,15.0,9.0,6.0,136.74117084629816,12.0,1640.894050155578};
	final Double[] Beispiel2 = {390.0,213.0,177.0,68.0,25.0,43.0,2374.1105080876328,48.0,113957.30438820636};
	final Double[] main = {39.0,20.0,19.0,22.0,10.0,12.0,173.9178331268546,5.0,869.589165634273};
	final Double[] eval1 = {279.0,157.0,122.0,52.0,22.0,30.0,1590.4226813613648,44.0,69978.59797990005};
	final Double[] extract = {55.0,29.0,26.0,21.0,10.0,11.0,241.57745825283183,10.0,2415.774582528318};
	
	@Test
	public void ggt1(){
		runHalstead("ggt1.c", this.ggt1);
	}
	
	@Test
	public void ggt2(){
		runHalstead("ggt2.c", this.ggt2);
	}
	
	@Test
	public void beispiel2(){
		runHalstead("Beispiel2.c", this.Beispiel2);
	}
	
	@Test
	public void maintest(){
		runHalstead("main.c", this.main);
	}
	
	@Test
	public void eval1(){
		runHalstead("eval1.c", this.eval1);
	}
	
	@Test
	public void extract(){
		runHalstead("extract.c", this.extract);
	}

	public void runHalstead(String file, Double[] arr) {
		HalsteadData hd = HalsteadRunner.halstead(this.pfad + file);
		if (hd == null) {
			fail("Keine Auswertung stattgefunden, IO Fehler?");
		} else {
			checkHalstead(hd, arr);
		}
	}
	
	private static void checkHalstead(HalsteadData hd, Double[] data) {
		assertTrue(hd.N == data[0]);
		assertTrue(hd.N1 == data[1]);
		assertTrue(hd.N2 == data[2]);
		assertTrue(hd.n == data[3]);
		assertTrue(hd.n1 == data[4]);
		assertTrue(hd.n2 == data[5]);
		assertTrue(hd.V == data[6]);
		assertTrue(hd.D == data[7]);
		assertTrue(hd.E == data[8]);
	}
}
