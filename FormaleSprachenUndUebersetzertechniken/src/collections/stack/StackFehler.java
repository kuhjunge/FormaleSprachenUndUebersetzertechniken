package collections.stack;
public class StackFehler extends RuntimeException {
	/**
	 * Fehlerklasse zur Verwaltung von Stackfehlern
	 */
	private static final long serialVersionUID = 1L;
	String message;

	StackFehler(String m) {
		this.message = m;
	}
}