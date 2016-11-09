package exprRecognizer;

public class ExprRecognizer {

	private ExprDataCalculator data = null;

	public ExprRecognizer(String expr) {
		calc(expr);
	}

	private void calc(String expr) {
		this.data = new ExprDataCalculator(expr);
	}

	public String getTreeString() {
		return this.data.strRepresentation;
	}

	public boolean isValid() {
		if (this.data.err != true) {
			return true;
		}
		return false;
	}

}
