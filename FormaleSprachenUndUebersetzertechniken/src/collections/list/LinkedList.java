package collections.list;

import java.util.Iterator;

import collections.Collection;

/**
 * Eine LinkList
 * 
 * @author Kuhjunge
 * 
 * @param <E>
 */
public class LinkedList<E extends Comparable<E>> implements Collection<E> {
	protected Zelle<E> anker;
	protected Zeiger<E> cursor;
	public static final int NORMAL = 0;
	public static final int TRANSPOSE = 1;
	public static final int FRONT = 2;
	protected int insertType = NORMAL;

	/**
	 * @return einen Iterator
	 */
	@Override
	public Iterator<E> iterator() {
		return new Cursor(this.anker);
	}

	/**
	 * Der Konstruktor
	 */
	public LinkedList() {
		this.anker = new Zelle<>(null, null);
		this.cursor = new Cursor(this.anker);
	}

	/**
	 * Mit LinkedList.TRANSPOSE / NORMAL / FRONT kann die Einfügetechnik modifiziert werden
	 * @param insertType
	 */
	public LinkedList(int it) {
		this.anker = new Zelle<>(null, null);
		this.cursor = new Cursor(this.anker);
		this.insertType = it;
	}

	/**
	 * Gibt die Größe der Liste zurück
	 * 
	 * @return anzahl
	 */
	@Override
	public int size() {
		Iterator<E> z = iterator();
		int anzahl = 0;
		while (z.hasNext()) {
			z.next();
			anzahl++;
		}
		return anzahl;
	}

	/**
	 * Prüft ob die Liste leer ist
	 */
	@Override
	public boolean isEmpty() {
		return this.anker.getNext() == null;
	}

	/**
	 * Prüft ob ein bestimmter Wert enthalten ist
	 */
	@Override
	public boolean contains(E e) {
		this.cursor.goTo(e);
		if (this.cursor.atEnd()) {
			return false;
		}
		this.cursor.goToFirst();
		return true;
	}

	/**
	 * Fügt ein Element der Liste hinzu
	 */
	@Override
	public void add(E e) {
		switch (this.insertType) {
		case TRANSPOSE:
			addTranspose(e);
			break;
		case FRONT:
			addFront(e);
			break;
		default:
			addNormal(e);
			break;
		}
	}

	/**
	 * Fügt ein Element der Liste hinzu
	 */
	public void addNormal(E e) {
		this.cursor.add(e);
	}

	/**
	 * Fügt Elemente hinzu, setzt Sie an den Anfang der Liste (MoveToFront)
	 * 
	 * @param e
	 */
	private void addFront(E e) {
		this.cursor.goTo(e);
		if (!this.cursor.atEnd()) {
			E a = this.cursor.get();
			this.cursor.remove();
			this.cursor.goToFirst();
			this.cursor.add(a);
		} else {
			this.cursor.add(e);
		}
	}

	/**
	 * Fügt Elemente hinzu, setzt es einen Schritt nach vorne (Transpose) Wenn
	 * ein Element gefunden wurde, vertausche es mit seinem Vorgänger.
	 * 
	 * @param e
	 */
	private void addTranspose(E e) {
		this.cursor.goTo(e);
		if (!this.cursor.atEnd()) {
			E a = this.cursor.get();
			this.cursor.remove();
			this.cursor.goToPrev();
			this.cursor.add(a);
		} else {
			this.cursor.add(e);
		}
	}

	/**
	 * Entfernt ein Element
	 */
	@Override
	public boolean remove(E e) {
		return this.cursor.removebool();
	}

	/**
	 * Löscht die Liste
	 */
	@Override
	public void clear() {
		this.anker = new Zelle<>(null, null);
	}

	/**
	 * Zählt die Elemente in der Liste
	 * 
	 * @param element
	 * @return
	 */
	// liefert die Häufigkeit des Elementes
	public int count(E element) {
		Iterator<E> z = iterator();
		int anzahl = 0;
		while (z.hasNext()) {
			if (element == z.next())
				anzahl++;
		}
		return anzahl;
	}

	/**
	 * Gibt eine Stringrepresentation zurück
	 */
	// liefert eine Stringrepräsentation der Multimenge
	@Override
	public String toString() {

		Cursor z = new Cursor(this.anker);
		z.goToFirst();
		StringBuilder ret = new StringBuilder();
		ret.append('{');
		while (!z.atEnd()) {
			ret.append(z.toString() + ", ");
			z.goToNext();
		}
		return ret.substring(0, ret.length() - 2) + "}";
	}

	/**
	 * Gibt den Zeiger Zurück
	 * 
	 * @return
	 */
	// Navigation
	public E get() {
		if (this.cursor.atEnd()){
			return null;
		}
		return this.cursor.get();
	}

	/**
	 * Lässt den Zeiger an die erste Position springen
	 */
	public void goToFirst() {
		this.cursor.goToFirst();
	}

	/**
	 * Geht mit den zeiger nur nächsten Position
	 */
	public void goToNext() {
		this.cursor.goToNext();
	}

	/**
	 * Geht mit den zeiger nur vorherigen Position
	 */
	public void goToPrev() {
		this.cursor.goToPrev();
	}

	/**
	 * Prüft ob die Liste bereits am Ende ist
	 * 
	 * @return
	 */
	public boolean atEnd() {
		return this.cursor.atEnd();
	}

	/**
	 * Geht zu einer Bestimmten Stelle in der Liste
	 * 
	 * @param e
	 */
	public void goTo(E e) {
		this.cursor.goTo(e);
	}

	/**
	 * Klasse Cursor zur Verwaltung einer Zeigerfunktion
	 * 
	 * @author Kuhjunge
	 * 
	 */
	protected class Cursor implements Zeiger<E> {
		protected Zelle<E> z;

		/**
		 * Konstruktor
		 * 
		 * @param z
		 */
		protected Cursor(Zelle<E> z) {
			this.z = z;
		}

		// Navigation

		@Override
		public void goToFirst() {
			this.z = LinkedList.this.anker;
		}

		@Override
		public void goToNext() {
			if (!atEnd())
				this.z = this.z.getNext();
		}

		@Override
		public void goToPrev() {
			if (this.z != LinkedList.this.anker) {
				Zelle<E> e = LinkedList.this.anker;
				while (e.getNext() != this.z) {
					e = e.getNext();
				}
				this.z = e;
			}
		}

		@Override
		public boolean atEnd() {
			return this.z.getNext() == null;
		}

		@Override
		public void goTo(E e) {
			goToFirst();
			while (!atEnd() && e.compareTo(get()) != 0)
				goToNext();
		}

		// Listenmodifikation und Inspektion

		@Override
		public void add(E e) {
			this.z.setNext(new Zelle<>(e, this.z.getNext()));
			goToNext();
		}

		@Override
		public boolean removebool() {
			if (this.z.getNext() != null) {
				this.z.setNext(this.z.getNext().getNext());
				return true;
			}
			return false;
		}

		@Override
		public void remove() {
			removebool();
		}

		@Override
		public E get() {
			return this.z.getNext().getInhalt();
		}

		// Implementation von Iterator
		@Override
		public boolean hasNext() {
			return !atEnd();
		}

		@Override
		public E next() {
			E e = get();
			goToNext();
			return e;
		}

		// Eigene Implimentation
		@Override
		public String toString() {
			return this.z.getNext() + "";
		}
	}
}
