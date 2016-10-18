package collections;

public interface Collection<E> extends Iterable<E> {
	/**
	 * Gibt die Gr��e der Collection zur�ck
	 * 
	 * @return
	 */
	public int size(); 

	/**
	 * Gibt an ob die Collection leer ist
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Pr�ft ob die Collection ein bestimmtes Element enth�lt
	 * 
	 * @param e
	 * @return
	 */
	public boolean contains(E e); 

	/**
	 * F�gt ein Element hinzu
	 * 
	 * @param e
	 */
	public void add(E e);

	/**
	 * Enfternt ein Element
	 * 
	 * @param e
	 */
	public boolean remove(E e); 
	
	/**
	 * Leert die Liste
	 */
	public void clear(); 
}
