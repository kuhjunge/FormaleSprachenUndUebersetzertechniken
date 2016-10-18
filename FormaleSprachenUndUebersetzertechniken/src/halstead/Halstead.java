package halstead;

import collections.list.Multiset;

public class Halstead<E extends Comparable<E>> {
	private Multiset<E> operands, operator;
	double N1;
	double N2;
	double n1;
	double n2;
	double N;
	double n;
	double V;
	double D;
	double E;

	public Halstead(Multiset<E> tor, Multiset<E> nds) {
		this.operands = nds;
		this.operator = tor;
		this.N1 = this.operator.size();
		this.N2 = this.operands.size();
		this.n1 = this.operator.distinct();
		this.n2 = this.operands.distinct();
		this.N = this.N1 + this.N2;
		this.n = this.n1 + this.n2;
		this.V = this.N * (Math.log(this.n) / Math.log(2));
		this.D = ((int) this.n1 / 2) * ((int) this.N2 / (int) this.n2); // Int Cast ist notwendig um
													// die richtigen Zahlen zu
													// bekommen
		this.E = this.V * this.D;
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
