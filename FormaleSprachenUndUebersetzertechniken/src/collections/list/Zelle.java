package collections.list;

public class Zelle<E extends Comparable<E>> {
	private E content; // Der Inhalt
	/**
	 * Die n�chste Zelle
	 */
	private Zelle<E> next;
	/**
	 * Die vorherige Zelle
	 */
	private Zelle<E> prev;
	
	/**
	 * Der Konstruktor, welcher die Zelle erstellt
	 * 
	 * @param e
	 *            Die Zelle
	 */
	public Zelle() {
		this.content = null;

	}

	/**
	 * Der Konstruktor, welcher die Zelle erstellt
	 * 
	 * @param e
	 *            Die Zelle
	 */
	public Zelle(E e) {
		this.content = e;

	}

	/**
	 * Der Konstruktor, welcher die Zelle erstellt
	 * 
	 * @param e
	 *            der Inhalt
	 * @param n
	 *            die n�chste Zelle
	 */
	public Zelle(E e, Zelle<E> n) {
		this.content = e;
		this.next = n;
	}

	/**
	 * Der Konstruktor, welcher die Zelle erstellt
	 * 
	 * @param e
	 *            der Inhalt
	 * @param next
	 *            die n�chste Zelle
	 * @param prev
	 *            die letzte Zelle
	 */
	public Zelle(E e, Zelle<E> next, Zelle<E> prev) {
		this.content = e;
		this.next = next;
		this.prev = prev;
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
	 * Gibt das Objekt der letzten Zelle zur�ck
	 * 
	 * @return
	 */
	public Zelle<E> getPrev() {
		return this.prev;
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
	 * Setzt das Objekt der letzten Zelle
	 * 
	 * @param n
	 */
	public void setPrev(Zelle<E> n) {
		this.prev = n;
	}

	/**
	 * Die Methode compareTo liefert einen Wert kleiner 0, wenn das Objekt
	 * �kleiner�; gr��er 0, wenn es �gr��er�, und gleich 0, wenn es �gleich� dem
	 * als Argument �bergebenen Objekt w ist.
	 * */
	public int compareTo(E o) {
		return this.content.compareTo(o);
	}

	/**
	 * Gibt den Inhalt zur�ck
	 * 
	 * @return Inhalt der Zelle
	 */
	public E getInhalt() {
		return this.content;
	}
	
	@Override
	public String toString()
	{
		return this.content.toString();	
	}
}