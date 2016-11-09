package halstead;

public class HalsteadData {
	public double N1 = 0;
	public double N2 = 0;
	public double n1 = 0;
	public double n2 = 0;
	public double N = 0;
	public double n = 0;
	public double V = 0;
	public double D = 0;
	public double E = 0;

	public HalsteadData() {
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("N Programmlänge: " + this.N + "\r\n");
		ret.append("  Ges Operator " + this.N1+ "\r\n"); // N1
		ret.append("  Ges Operanten: " + this.N2+ "\r\n"); // N2
		ret.append("n Vokabulargröße: " + this.n+ "\r\n");
		ret.append("  Dis Operator: " + this.n1+ "\r\n"); // n1
		ret.append("  Dis Operanten: " + this.n2+ "\r\n"); // n2
		ret.append("V Volumen des Programms: " + this.V+ "\r\n"); // Funktion 20 -
														// 1000 | Datei
														// 100 - 8000
		ret.append("D Schwierigkeitsgrad: " + this.D + "\r\n");
		ret.append("L Programmniveau: " + (1 / this.D)+ "\r\n");
		ret.append("E Implementierungsaufwand: " + this.E+ "\r\n");
		ret.append("T Implementierungszeit: " + (this.E / 18)+ "\r\n");
		return ret.toString();
	}
}