package postFix.stack;

import collections.stack.ArrayStack;
import collections.stack.Stack;

public class StackCustom<E> implements IStackAdapter<E> {
	Stack<E> s = new ArrayStack<>();
	
	@Override
	public int size() {
		return this.s.enthaelt();
	}

	@Override
	public boolean isEmpty() {
		return this.s.istLeer();
	}

	@Override
	public void push(E e) {
		this.s.push(e);
	}

	@Override
	public E pop() {
		return this.s.popTop();
	}

	@Override
	public E pop2nd() {
		E wert = pop();
		E zweiterWert = pop();
		push(wert);
		return zweiterWert;
	}

}
