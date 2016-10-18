package collections.stack;

public class Zelle<E> {
	private E inhalt; // Der Inhalt
	/**
	 * Die n�chste Zelle
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
	 * Gibt das Objekt der n�chsten Zelle zur�ck
	 * 
	 * @return
	 */
	public Zelle<E> getNext() {
		return this.next;
	}

	/**
	 * Setzt das Objekt der n�chsten Zelle
	 * 
	 * @param n
	 */
	public void setNext(Zelle<E> n) {
		this.next = n;
	}

	/**
	 * Gibt den Inhalt zur�ck
	 * 
	 * @return Inhalt der Zelle
	 */
	public E getInhalt() {
		return this.inhalt;
	}
}