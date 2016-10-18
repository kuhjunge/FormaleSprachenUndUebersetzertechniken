package collections.list;


public class LinkedListDouble<E extends Comparable<E>> extends LinkedList<E> {
	//protected Cursor cursor;
	/**
	 * Geht mit den zeiger zur letzten Position
	 */
	
	public LinkedListDouble() {
		super();
		this.anker = new Zelle<>();
		this.cursor = new Cursor2(this.anker);
	}
	/**
	 * Mit LinkedList.TRANSPOSE / NORMAL / FRONT kann die Einfügetechnik modifiziert werden
	 * @param it
	 */
	public LinkedListDouble(int it) {
		super();
		this.anker = new Zelle<>();
		this.cursor = new Cursor2(this.anker);
		this.insertType = it;
	}
	
	class Cursor2 extends LinkedList<E>.Cursor {
		protected Cursor2(Zelle<E> z) {
			super(z);
			LinkedListDouble.this.cursor = new Cursor(LinkedListDouble.this.anker);
		}
		
		// Navigation

		/**
		 * Setzt den Zeiger an die letzte Stelle in der Verketteten Liste
		 */
		@Override
		public void goToPrev() {
			if (this.z != LinkedListDouble.this.anker)
				this.z = this.z.getPrev();
		}

		// Listenmodifikation und Inspektion

		@Override
		public void add(E e) {
			Zelle<E> n = new Zelle<>(e, this.z.getNext(), this.z);
			this.z.setNext(n);
			if (n.getNext() != null) {
				n.getNext().setPrev(n);
			}
			goToNext();
		}

		@Override
		public boolean removebool() {
			if (this.z.getNext() != null) {
				Zelle<E> r = this.z.getNext().getNext();
				this.z.setNext(r);
				if (r != null) {
					r.setPrev(this.z); // zurück
				}
				return true;
			}
			return false;
		}
	}
}
