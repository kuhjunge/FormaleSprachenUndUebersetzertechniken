package collections.stack;

public abstract class VStack<E> implements Stack<E>{
	@Override
	public E pop2ndTop() {
		E wert = popTop();
		E zweiterWert = popTop();
		push(wert);
		return zweiterWert;
	}
}
