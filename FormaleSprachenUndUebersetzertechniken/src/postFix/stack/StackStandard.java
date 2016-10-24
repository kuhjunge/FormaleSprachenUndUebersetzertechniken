package postFix.stack;

import java.util.Stack;

public class StackStandard<E> implements IStackAdapter<E> {
	Stack<E> s = new Stack<>();
	
	@Override
	public int size() {
		return this.s.size();
	}

	@Override
	public boolean isEmpty() {
		return this.s.isEmpty();
	}

	@Override
	public void push(E e) {
		this.s.push(e);
	}

	@Override
	public E pop() {
		return this.s.pop();
	}

	@Override
	public E pop2nd() {
		E wert = pop();
		E zweiterWert = pop();
		push(wert);
		return zweiterWert;
	}

}
