package collections;

public interface Collection<E> extends Iterable<E> {
	/**
	 * Gibt die Größe der Collection zurück
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
	 * Prüft ob die Collection ein bestimmtes Element enthält
	 * 
	 * @param e
	 * @return
	 */
	public boolean contains(E e); 

	/**
	 * Fügt ein Element hinzu
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
