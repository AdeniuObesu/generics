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
			else next.add(item);
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
		T removed;
		if(index == 0) {
			removed = value;
			if(next == null) { //Remove the first node & get rid of the linkedList
				value = null;
			} else { //Remove the first node and keep track of the remaining parts
				value = next.value;
				next = next.next;
			}
			return removed;
		} else if(index == 1) {
			if(next == null) // Nothing to remove
				return null;
			// Remove the second node
			removed = next.value;
			next = next.next;
			return removed;
		} else if(next != null)
			// index not in [0-1] and the next node has a next
			return next.remove(index - 1);
		// index not in [0-1] and the next node has no next
		else return null;
	}
	
	@Override
	public boolean isEmpty() {
		return (value == null && next == null);
	}
	
	@Override
	public boolean contains(Object o) {
		if(o == null)
			return false;
		else {
			if(value.equals(o))
				return true;
			if(next == null)
				return false;
			return next.contains(o);
		}
	}
	
	@Override
	public void clear() {
		value = null;
		if(next != null)
			next.clear();
			next = null;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o instanceof LinkedList) {
			@SuppressWarnings("unchecked")
			List<T> obj = (List<T>) o;
			if(size() != obj.size())
				return false;
			for(int i=0; i<size(); i++) {
				if(! get(i).equals(obj.get(i)) )
					return false;
			}
		}
		return true;
	}
	
	@Override
	public int indexOf(Object o) {
		int index = 0;
		if(o == null) {
			for(LinkedList<T> cursor = this; cursor != null; cursor = cursor.next, index ++) {
				if(cursor.value == null)
					return index;
			}
		} else {
			for(LinkedList<T> cursor = this; cursor != null; cursor = cursor.next, index ++) {
				if(o.equals(cursor.value))
					return index;
			}
		}
		return -1;
	}
}
