package collections.stack;

/**
 * Klasse zur Verwaltung von Stacks auf Array Basis + Erweiterung Multipop() +
 * Erweiterung Default Konstruktor ohne Parameter + Erweiterung Automatische
 * Vergr��erung des Arrays bei �berlauf
 * 
 * @author Kuhjunge
 * 
 * @param <E>
 */
public class ArrayStack<E> extends VStack<E> {
	private E[] array;
	private int top;

	@SuppressWarnings("unchecked")
	/**
	 * Generiert einen ArrayStack mit der angegebenen Kapazit�t
	 * @param kapazit�t
	 */
	public ArrayStack(int kapazit�t) {
		int kapa = kapazit�t;
		if (kapazit�t < 1) {
			kapa = 1;
		}
		this.array = (E[]) new Object[kapa];
		this.top = -1;
	}


	/**
	 * Generiert einen ArrayStack mit der  Kapazit�t von 5
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		int kapazit�t = 5;
		this.array = (E[]) new Object[kapazit�t];
		this.top = -1;
	}

	@SuppressWarnings("unchecked")
	/**
	 * Generiert einen ArrayStack aus einem vorhandenen ArrayStack
	 */
	public ArrayStack(Stack<E> s, int kapazit�t) {

		this.array = (E[]) new Object[kapazit�t];
		this.top = -1;
		for (int i = kapazit�t - 1; i >= 0; i--) {
			if (!s.istLeer()) {
				this.array[i] = s.popTop();
				this.top++;
			}
		}
		for (int i = 0; i <= (kapazit�t - 1); i++) {
			s.push(this.array[i]);
		}
	}

	@Override
	public boolean istLeer() {
		return this.top == -1;
	}

	/**
	 * Pr�ft ob der String voll ist
	 * 
	 * @return True falls voll, sonst false
	 */
	public boolean istVoll() {
		return this.top + 1 == this.array.length;
	}

	/**
	 * legt einen Wert auf den Stack
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void push(E e) { // throws StackFehler {
		// if (istVoll()) throw new StackFehler("Stack ist voll!");
		if (istVoll()) { // Erweiterung, Stackgr��e verdoppeln bei vollem Stack
			E[] alt = this.array;
			E[] neu = (E[]) new Object[alt.length * 2];
			int i = 0;
			for (E x : alt) {
				neu[i] = x;
				i++;
			}
			this.array = neu;
		}
		this.array[++this.top] = e;
	}

	/**
	 * L�scht das oberste Element des Stacks
	 */
	@Override
	public void pop() throws StackFehler {
		if (istLeer())
			throw new StackFehler("Stack ist leer!");
		this.array[this.top--] = null; // Element l�schen
	}

	/**
	 * Gibt das erste Element des Stacks zur�ck
	 * 
	 * @return das oberste Element des Stacks
	 */
	@Override
	public E top() throws StackFehler {
		if (istLeer())
			throw new StackFehler("Stack ist leer!");
		return this.array[this.top];
	}

	/**
	 * Gibt das erste Element des Stacks zur�ck und l�scht es anschlie�end
	 * 
	 * @return das oberste Element des Stacks
	 */
	@Override
	public E popTop() throws StackFehler {
		if (istLeer())
			throw new StackFehler("Stack ist leer!");
		E e = this.array[this.top];
		this.array[this.top--] = null;
		return e;
	}

	// Erweiterung Multipop
	/**
	 * MultiPop l�scht mehrere Elemente vom Stack
	 * 
	 * @param anzahl
	 *            Die Anzahl der zu l�schende Elemente
	 */
	@Override
	public void multiPop(int anzahl) {
		int i = anzahl;
		while (i != 0 && !istLeer()) {
			this.array[this.top--] = null; // Element l�schen
			i--;
		}
	}

	public int size() {
		return this.top + 1;
	}

	public boolean contains(E e) {
		boolean erg = false;
		for(E element : this.array) {
			if (element == e){
				erg = true;
			}
		}
		return erg;
	}


	@Override
	public int enthaelt() {
		return size();
	}




}
