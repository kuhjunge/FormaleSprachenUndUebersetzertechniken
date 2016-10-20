package postFix.Exception;

public class UnknownMathOperationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 801349577801137546L;

	/**
	 * Konstruktor
	 * @param s
	 */
	public UnknownMathOperationException(String s){
		super(s);
	}

}
