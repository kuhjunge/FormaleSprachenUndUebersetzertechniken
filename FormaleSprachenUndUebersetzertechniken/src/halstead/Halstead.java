package halstead;

import collections.list.Multiset;

public class Halstead<E extends Comparable<E>> {
	private Multiset<E> operands, operator;
	private HalsteadData data = new HalsteadData();

	public Halstead(Multiset<E> tor, Multiset<E> nds) {
		this.operands = nds;
		this.operator = tor;
		this.data.N1 = this.operator.size();
		this.data.N2 = this.operands.size();
		this.data.n1 = this.operator.distinct();
		this.data.n2 = this.operands.distinct();
		this.data.N = this.data.N1 + this.data.N2;
		this.data.n = this.data.n1 + this.data.n2;
		this.data.V = this.data.N * (Math.log(this.data.n) / Math.log(2));
		this.data.D = ((int) this.data.n1 / 2) * ((int) this.data.N2 / (int) this.data.n2); // Int Cast ist notwendig um
													// die richtigen Zahlen zu
													// bekommen
		this.data.E = this.data.V * this.data.D;
	}
	
	public HalsteadData getData(){
		return this.data;
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("N Programmlänge: " + this.data.N + "\r\n");
		ret.append("  Ges Operator " + this.data.N1+ "\r\n"); // N1
		ret.append("  Ges Operanten: " + this.data.N2+ "\r\n"); // N2
		ret.append("n Vokabulargröße: " + this.data.n+ "\r\n");
		ret.append("  Dis Operator: " + this.data.n1+ "\r\n"); // n1
		ret.append("  Dis Operanten: " + this.data.n2+ "\r\n"); // n2
		ret.append("V Volumen des Programms: " + this.data.V+ "\r\n"); // Funktion 20 -
														// 1000 | Datei
														// 100 - 8000
		ret.append("D Schwierigkeitsgrad: " + this.data.D + "\r\n");
		ret.append("L Programmniveau: " + (1 / this.data.D)+ "\r\n");
		ret.append("E Implementierungsaufwand: " + this.data.E+ "\r\n");
		ret.append("T Implementierungszeit: " + (this.data.E / 18)+ "\r\n");
		return ret.toString();
	}

}
