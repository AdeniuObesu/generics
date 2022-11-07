/**
 * 
 */
package org.adeniuobesu.generics;

/**
 * @author MOUKHAFI Anass
 *
 * Nov 7, 2022
 */
public class LinkedSet<T> implements Set<T> {

	private T value;
	LinkedSet<T> next;
	
	private LinkedSet(T value) {
		this.value = value;
	}
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
