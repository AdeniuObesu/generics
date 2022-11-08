package org.adeniuobesu.generics;

import java.util.Iterator;


/**
 * @author MOUKHAFI Anass
 * LinkedList cannot start with a null element.
 * If the first element is null, it means the linkedlist is empty.
 * Oct 24, 2022
 */
public class LinkedList<T> implements List<T> {
	
	private T value;
	private LinkedList<T> next;
	
	public LinkedList() {
		this.value = null;
		this.next = null;
	}

	public LinkedList(T value) {
		this.value = value;
		this.next = null;
	}
	
	public Object clone() {
		List<T> clone = new LinkedList<>();
		int size = size();
		for(int i=0; i<size; i++)
			clone.add(get(i));
		return clone;
	}
	
	/*
	 * Tells if the argument is the index of an existing element
	 * */
	private boolean isElementIndex(int index) {
		return (index > -1 && index < size());
	}
	/*
	 * Constructs an IndexOutOfBoundsException detail message
	 * */
	private String outOfBoundsMsg(int index) {
		return "Index : " + index + ", Size :" + size();
	}
	
	private void checkElementIndex(int index) {
		if(!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}
	
	@Override
	public void add(T item) {
		if(isEmpty()) {
			if(item != null)
				value = item;
		}
		else {
			if( next==null )
				next = new LinkedList<T>(item);
			else
				next.add(item);
		}
	}

	@Override
	public T get(int index) {
		checkElementIndex(index);
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
		checkElementIndex(index);
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
		return indexOf(o, 0);
	}
	
	@Override
	public int indexOf(Object o, int index) {
		int position = 0;
		if(o == null) {
			for(LinkedList<T> cursor = this; cursor != null; cursor = cursor.next, ++position) {
				if(index > position) {
					continue;
				} else {
					if(cursor.value == null) {
						return position;
					}
				}
			}
		} else {
			for(LinkedList<T> cursor = this; cursor != null; cursor = cursor.next, ++position) {
				if(index > position) {
					continue;
				} else {
					if(o.equals(cursor.value))
						return position;
				}
			}
		}
		return -1;
	}

	@Override
	public T set(int index, T o) {
		checkElementIndex(index);
		T oldVal = null;
		if(index == 0) {
			oldVal = value;
			value = o;
		} else {
			next.set(index - 1, o);
		}
		return oldVal;
	}
	

	@Override
	public Iterator<T> iterator() {
		return new Iter();
	}
	private class Iter implements Iterator<T> {
		private LinkedList<T> cursor;
		private LinkedList<T> lastReturned;
		private int index = 0;
		
		public Iter() {
			cursor = LinkedList.this;
			lastReturned = null;
		}
		@Override
		public boolean hasNext() {
			return ( index < size() );
		}
		@Override
		public T next() {
			lastReturned = cursor;
			cursor = cursor.next;
			++index;
			return lastReturned.value;
		}
	}
	
	@Override
	public List<T> subList(int from, int to) {
		if(from > to || from < 0 || to >= size())
			return null;
		List<T> subList = new LinkedList<>();
		for(int i=from; i<=to; i++) {
			subList.add(get(i));
		}
		return subList;
	}
	/*
	 * Adds an element in the range [0 - (size()-1)]
	 * */
	@Override
	public void add(int index, T item) {
		checkElementIndex(index);
		if(index == 0) {
			LinkedList<T> node;
			node = new LinkedList<>(this.value);
			node.next = next;
			value = item;
			next = node;
		} else next.add(index - 1, item);
	}
	
	@Override
	public String toString() {
		String charSequence ="LinkedList contains ";
		int size = size();
		if(size == 0)
			return charSequence.concat("no elements.");
		charSequence = charSequence.concat(size() + " elements : (");
		for(int i=0; i<size; i++) {
			charSequence = charSequence.concat(get(i)+"");
			if(i!=size-1)
				charSequence = charSequence.concat("-");
		}
		return charSequence.concat(").");
	}
}
