package collections.list;

import java.util.Iterator;

/**
 * MultiSet List
 * 
 * @author Kuhjunge
 * 
 * @param <T>
 */
public class LinkedListMultiset<T extends Comparable<T>> implements Multiset<T> {
	/**
	 * Linked List zur Internen Verwaltung der Liste
	 */
	private LinkedList<Entry<T>> link;

	/**
	 * Konstruktor
	 */
	public LinkedListMultiset() {
		this.link = new LinkedListDouble<>();
	}
	/**
	 * Mit LinkedList.TRANSPOSE / NORMAL / FRONT kann die Einfügetechnik modifiziert werden
	 * @param oit
	 */
	public LinkedListMultiset(int oit) {
		this.link = new LinkedListDouble<>(oit);
	}

	@Override
	public Iterator<T> iterator() {
		LinkedList<T> it = new LinkedList<>();
		Iterator<Entry<T>> z = this.link.iterator();
		while (z.hasNext()) {
			Entry<T> x = z.next();
			for (int i = 0; i < x.count; i++) {
				it.add(x.content);
			}
		}
		return it.iterator();
	}

	// liefert die Häufigkeit des Elementes
	@Override
	public int count(T element) {
		Iterator<Entry<T>> z = this.link.iterator();
		while (z.hasNext()) {
			Entry<T> x = z.next();
			if (x.content == element) {
				return x.count;
			}
		}
		return 0;
	}

	// liefert die Anzahl der verschiedenen Elemente
	@Override
	public int distinct() {
		Iterator<Entry<T>> z = this.link.iterator();
		int anzahl = 0;
		while (z.hasNext()) {
			anzahl++;
			z.next();
		}
		return anzahl;
	}

	// liefert eine Stringrepräsentation der Multimenge
	@Override
	public String toString() {
		Iterator<Entry<T>> z = this.link.iterator();
		StringBuilder ret = new StringBuilder();
		ret.append('(');
		while (z.hasNext()) {
			Entry<T> x = z.next();
			ret.append(x.toString() + ", ");
		}
		return ret.substring(0, ret.length() - 2) + ")";
	}

	@Override
	public int size() {
		Iterator<Entry<T>> z = this.link.iterator();
		int anzahl = 0;
		while (z.hasNext()) {
			Entry<T> x = z.next();
			anzahl += x.count;
		}
		return anzahl;
	}

	@Override
	public boolean isEmpty() {
		return this.link.isEmpty();
	}

	@Override
	public boolean contains(T e) {
		Entry<T> a = new Entry<>();
		a.content = e;
		this.link.contains(a);
		return this.link.contains(a);
	}

	@Override
	public void add(T e) {
		Entry<T> a = new Entry<>();
		a.content = e;
		this.link.goTo(a);
		if (!this.link.atEnd()) {
			this.link.get().count++;
		} else {
			this.link.add(a);
		}
	}

	@Override
	public boolean removeTotal(T e) {
		Entry<T> a = new Entry<>();
		a.content = e;
		if (this.link.contains(a)) {
			this.link.remove(a);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(T e) {
		Entry<T> a = new Entry<>();
		a.content = e;
		if (this.link.contains(a)) {
			this.link.goTo(a);
			if (this.link.get().count < 2) {
				this.link.remove(a);
			} else {
				this.link.get().count--;
			}
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		this.link.clear();
	}
}
