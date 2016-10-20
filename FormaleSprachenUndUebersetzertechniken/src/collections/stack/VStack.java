package collections.stack;

public abstract class VStack<E> implements Stack<E>{
	
	public E pop2ndTop() {
		E wert = popTop();
		E zweiterWert = popTop();
		push(wert);
		return zweiterWert;
	}

	public boolean isEmpty(){
		return istLeer();
	}

	public void add(E e){
		push(e);
	}
	
	public void clear() {
		while (!istLeer()) {
			pop();
		}
	}
}
