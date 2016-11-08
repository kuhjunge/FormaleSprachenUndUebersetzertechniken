package exprRecognizer;

public class ExprRecognizer {

	private static String oldExpr = "";
	private static ExprDataCalculator data = null;

	private static void calc(String expr) {
		if (oldExpr != expr){
			data = new ExprDataCalculator(expr);
		}
	}

	public static String getTreeString(String expr) {
		calc(expr);
		return data.strRepresentation;
	}

	public static boolean isValid(String expr) {
		calc(expr);
		if (data.err != true) {
			return true;
		}
		return false;
	}

}
