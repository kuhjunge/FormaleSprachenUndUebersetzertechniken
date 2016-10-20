package collections.stack;

/**
 * Klasse zur Verwaltung von Stacks auf List Basis + Erweiterung Multipop
 * 
 * @author Kuhjunge
 * 
 * @param <E>
 */
public class ListStack<E> extends VStack<E> {
	private Zelle<E> top;

	/**
	 * Prüft ob der Stack leer ist
	 * 
	 * @return True falls leer, sonst false
	 */
	@Override
	public boolean istLeer() {
		return this.top == null;
	}

	/**
	 * legt einen Wert auf den Stack
	 */
	@Override
	public void push(E e) {
		Zelle<E> neueZelle = new Zelle<>(e);
		neueZelle.setNext(this.top);
		this.top = neueZelle;
	}

	/**
	 * Löscht das oberste Element des Stacks
	 */
	@Override
	public void pop() throws StackFehler {
		if (istLeer())
			throw new StackFehler("Stack ist leer!");
		Zelle<E> nexttop = this.top.getNext();
		this.top = nexttop;
	}

	/**
	 * Gibt das erste Element des Stacks zurück und löscht es anschließend
	 * 
	 * @return das oberste Element des Stacks
	 */
	@Override
	public E popTop() throws StackFehler {
		if (istLeer())
			throw new StackFehler("Stack ist leer!");
		E wert = this.top.getInhalt();
		Zelle<E> nexttop = this.top.getNext();
		this.top = nexttop;
		return wert;

	}

	/**
	 * Gibt das erste Element des Stacks zurück
	 * 
	 * @return das oberste Element des Stacks
	 */
	@Override
	public E top() throws StackFehler {
		if (istLeer())
			throw new StackFehler("Stack ist leer!");
		return this.top.getInhalt();
	}

	/**
	 * MultiPop löscht mehrere Elemente vom Stack
	 * 
	 * @param anzahl
	 *            Die Anzahl der zu löschende Elemente
	 */
	@Override
	public void multiPop(int anzahl) {
		int anz = anzahl;
		while (anz != 0 && !istLeer()) {
			Zelle<E> nexttop = this.top.getNext();
			this.top = nexttop;
			anz--;
		}
	}

	@Override
	public int enthaelt() {
		int i = 0;
		Zelle<E> x = this.top;
		while (x != null){
			x = x.getNext();
			i++;
		}
		return i;
	}
}