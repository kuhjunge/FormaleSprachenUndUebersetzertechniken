package collections.list;

import collections.Collection;

public interface Multiset<E extends Comparable<E>> extends Collection<E> {
	/**
	 * liefert die H�ufigkeit des Elementes
	 * @param element
	 * @return
	 */
	int count(E element);

	/**
	 * liefert die Anzahl der verschiedenen Elemente
	 * @return
	 */
	int distinct();

	/**
	 * liefert eine Stringrepr�sentation der Multimenge
	 * @return
	 */
	@Override
	String toString(); 
	
	/**
	 * Enfternt alle Elemente eines Types
	 * 
	 * @param e
	 */
	boolean removeTotal(E e);
}
