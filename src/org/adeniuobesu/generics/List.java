package org.adeniuobesu.generics;
/**
 * @author MOUKHAFI Anass
 * 
 * Oct 24, 2022
 */
public interface List<T> {
	void add(T item);
	
	T get(int index);
	
	int size();
	
	T remove(int index);
	
	boolean isEmpty();
	
	/*
	 * Things I added
	 * */
	
	boolean contains(Object o);
	
	void clear();
	
	boolean equals(Object o);
	
	int indexOf(Object o);
}
