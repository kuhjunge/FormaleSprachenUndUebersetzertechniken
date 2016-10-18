package collections.list;

public class Entry<E extends Comparable<E>> implements Comparable<Entry<E>>{  
	public E content ;
	public int count = 1;

	@Override
	public int compareTo(Entry<E> o) {
		return this.content.compareTo(o.content);
	}
	
	@Override
	public String toString()
	{
		return this.content + ":" + this.count;
	}

}
