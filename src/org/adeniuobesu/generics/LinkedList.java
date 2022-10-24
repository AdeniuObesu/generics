package org.adeniuobesu.generics;
/**
 * @author MOUKHAFI Anass
 * 
 * Oct 24, 2022
 */
public class LinkedList<T> implements List<T> {
	
	private T value;
	private LinkedList<T> next;
	
	public LinkedList() {
		value = null;
		next = null;
	}

	public LinkedList(T value) {
		this.value = value;
		next = null;
	}

	@Override
	public void add(T item) {
		if(isEmpty())
			value = item;
		else if( next==null )
			next = new LinkedList<T>(item);
			else
				next.add(item);
	}

	@Override
	public T get(int index) {
		if(index == 0) return value;
		else if(next != null) return next.get(index - 1);
		else return null;
	}

	@Override
	public int size() {
		if(isEmpty()) return 0;
		else  if(next == null) return 1;
		else return next.size() + 1;
	}

	@Override
	public T remove(int index) {
		if(isEmpty()) return null;
		if(index == 0) {
			T removed = value;
			if(next == null) {
				value = null;
			} else {
				value = next.value;
				next = next.next;
			}
			return removed;
		} else if(index == 1) {
			if(next == null)
				return null;
			T removed = next.value;
			next = next.next;
			return removed;
		} else if(next != null)
			return next.remove(index - 1);
		else return null;
	}
	@Override
	public boolean isEmpty() {
		return (value == null && next == null);
	}
}
