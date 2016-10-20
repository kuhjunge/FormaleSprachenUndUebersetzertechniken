package postFix.stack;

public interface IStackAdapter<E>  {
	/**
	 * Gibt die Anzahl der Elemente zurück
	 * @return
	 */
	int size();
	
	/**
	 * Ist der Stack leer?
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * Legt E auf den Stack
	 * 
	 * @param e
	 */
	void push(E e);

	/**
	 * Entfernt das erste Element vom Stack und gibt es zurück
	 * 
	 * @return
	 */
	E pop();

	/**
	 * gibt das zweite Element, welches unter dem ersten Element zurück
	 * 
	 * @return
	 */
	E pop2nd();
}
