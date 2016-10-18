package collections.list;

import java.util.Iterator;

public interface Zeiger<E> extends Iterator<E> {
	
	/**
	 * Setzt den Zeiger an die erste Stelle in der Verketteten Liste
	 */
	void goToFirst();

	/**
	 * Setzt den Zeiger an die nächste Stelle in der Verketteten Liste
	 */
	void goToNext() ;
	
	/**
	 * Setzt den Zeiger an die voherige Stelle in der Verketteten Liste
	 */
	void goToPrev();

	/**
	 * Prüft ob der Zeiger der Verketteten Liste an der Lezten Stelle ist
	 * @return
	 */
	boolean atEnd();

	/**
	 * Setzt den Zeiger an die Stelle in der Verketteten Liste wo das gesuchte Element ist oder an das Ende
	 * @param e
	 */
	void goTo(E e);

	// Listenmodifikation und Inspektion

	/**
	 * Fügt ein Element der Liste an der aktuellen Position hinzu
	 * @param e
	 */
	void add(E e);

	/**
	 * Entfernt ein Element aus der Liste an der aktuellen Position
	 */
	public boolean removebool() ;
	/**
	 * Entfernt ein Element aus der Liste an der aktuellen Position
	 */
	@Override
	public void remove();

	/**
	 * Gibt das aktuelle Element zurück
	 * @return
	 */
	public E get();

	// Implementation von Iterator
	/**
	 * Prüft ob noch ein WErt in der verketteten Liste kommt
	 */
	@Override
	public boolean hasNext() ;

	/**
	 * Gibt das aktuelle Element zurück und springt ein Element in der Liste weiter
	 */
	@Override
	public E next();

}
