package collections.stack;

public class Zelle<E> {
	private E inhalt; // Der Inhalt
	/**
	 * Die nächste Zelle
	 */
	private Zelle<E> next;

	/**
	 * Der Konstruktor, welcher die Zelle erstellt
	 * 
	 * @param e
	 *            Die Zelle
	 */
	Zelle(E e) {
		this.inhalt = e;
	}

	/**
	 * Gibt das Objekt der nächsten Zelle zurück
	 * 
	 * @return
	 */
	public Zelle<E> getNext() {
		return this.next;
	}

	/**
	 * Setzt das Objekt der nächsten Zelle
	 * 
	 * @param n
	 */
	public void setNext(Zelle<E> n) {
		this.next = n;
	}

	/**
	 * Gibt den Inhalt zurück
	 * 
	 * @return Inhalt der Zelle
	 */
	public E getInhalt() {
		return this.inhalt;
	}
}