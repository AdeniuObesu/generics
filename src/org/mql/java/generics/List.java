package org.mql.java.generics;

/**
 * @author MOUKHAFI Anass
 * 
 * Oct 24, 2022
 */
public interface List<T> extends Iterable<T> {
	void add(T item);
	
	T get(int index);
	
	int size();
	
	T remove(int index);
	
	boolean isEmpty();
	
	
	// Features I added
	
	boolean contains(Object o);
	
	boolean containsAll(List<T> list);
	
	void clear();
	
	boolean equals(Object o);
	
	int indexOf(Object o);
	
	int indexOf(Object o, int index);
	
	T set(int index, T o);

	List<T> subList(int from, int to);
	
	default Object[] toArray() {
		int size = size();
		Object[] array = new Object[size];
		for(int i=0; i<size; i++) {
			array[i] = get(i);
		}
		return array;
	}
	
	void add(int index, T item);
}
