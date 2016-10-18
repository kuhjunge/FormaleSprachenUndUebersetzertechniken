package collections.stack;

public interface Stack<E> {
	boolean istLeer();

	void push(E e);

	void pop();

	E top();

	E popTop();
	
	E pop2ndTop();

	void multiPop(int anzahl);

}