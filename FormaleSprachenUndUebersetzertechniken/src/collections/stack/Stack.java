package collections.stack;

public interface Stack<E> {
	/**
	 * Ist der Stack leer?
	 * 
	 * @return
	 */
	boolean istLeer();

	/**
	 * Legt E auf den Stack
	 * 
	 * @param e
	 */
	void push(E e);

	/**
	 * Entfernt das Oberste Element des Stacks
	 */
	void pop();

	/**
	 * Zeigt das erste Element
	 * 
	 * @return
	 */
	E top();

	/**
	 * Entfernt das erste Element vom Stack und gibt es zurück
	 * 
	 * @return
	 */
	E popTop();

	/**
	 * gibt das zweite Element, welches unter dem ersten Element zurück
	 * 
	 * @return
	 */
	E pop2ndTop();

	/**
	 * Entfernt eine bestimmte Anzahl von Elemente vom Stack
	 * 
	 * @param anzahl
	 */
	void multiPop(int anzahl);

}