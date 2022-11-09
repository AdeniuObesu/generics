package org.mql.java.generics;

import java.util.Iterator;

/**
 * @author MOUKHAFI Anass
 * 
 * Oct 24, 2022
 */
public class Vector<T> implements List<T> {
	private Object[] data;
	
	public Vector() {
		data = new Object[0];
	}
	
	@Override
	public Object clone() {
		LinkedList<T> clone = new LinkedList<>();
		int size = size();
		for(int i=0; i<size; i++)
			clone.add(get(i));
		return clone;
	}
	
	private boolean isElementIndex(int index) {
		return ( index > -1 && index < data.length);
	}
	private String outOfBoundsMsg(int index) {
		return "Index : " + index + " , Size : "+size();
	}
	private void checkElementIndex(int index) {
		if(!isElementIndex(index))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}
	@Override
	synchronized public void add(T item) {
		Object[] temp = new Object[data.length + 1];
		for(int i = 0; i<data.length; i++)
			temp[i] = data[i];
		temp[temp.length-1] = item;
		data = temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		checkElementIndex(index);
		return (T) data[index];
	}

	@Override
	public int size() {
		return data.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	synchronized public T remove(int index) {
		checkElementIndex(index);
		Object[] temp = new Object[data.length - 1];
		
		for(int i = 0; i < index; i++)
			temp[i] = data[i];
		
		for(int i = index+1; i<data.length; i++)
			temp[i-1] = data[i];
		// Get the item removed
		Object item = data[index];
		// Reference the new array by the actual array
		data = temp;
		return (T) item;
	}

	@Override
	public boolean isEmpty() {
		return (data.length == 0);
	}
	
	@Override
	public boolean contains(Object o) {
		if(o == null)
			return false;
		for(Object element : data) {
			if(element.equals(o))
				return true;
		}
		return false;
	}

	@Override
	public void clear() {
		if(! isEmpty() )
			for(int i = data.length-1; i>0; i--)
				data[i] = null;
		data = new Object[0];
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o instanceof Vector) {
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
		if(o==null) {
			for(int i=index; i<data.length; i++) {
				if(data[i] == null)
					return i;
			}
		} else {
			for(int i=index; i<data.length; i++) {
				if(o.equals(data[i]))
					return i;
			}
		}
		return -1;
	}
	
	@Override
	public T set(int index, T o) {
		checkElementIndex(index);
		T oldVal = get(index);
		data[index] = o;
		return oldVal;
	}

	@Override
	public synchronized org.mql.java.generics.util.Iterator<T> iterator() {
		return new Iter();
	}
	private class Iter implements org.mql.java.generics.util.Iterator<T> {
		private int cursor = 0; // Index of the next element to return
		private int lastReturned = -1; // Index of the recently returned element, -1 if no such
		
		public Iter() {
		}
		@Override
		public boolean hasNext() {
			return cursor != size();
		}
		@Override
		public T next() {
			// TODO: This section of code is critical and must be Thread-safe
			int i = cursor;
			cursor = i + 1;
			lastReturned = i;
			return get(lastReturned);
		}
	}
	/*
	 * returns all the elements lies within a given range [from - to]
	 * */
	@Override
	public List<T> subList(int from, int to) {
		if(from > to || from < 0 || to >= size()) // Then nothing to return
			return null;
		List<T> subList = new Vector<>();
		for(int i = from; i <= to; i++)
			subList.add(get(i));
		return subList;
	}
	@Override
	synchronized public void add(int index, T item) {
		checkElementIndex(index);
		if(item != null) {
			int size = size();
			Object[] tmp = new Object[size+1];
			for(int i=0; i<index; i++) {
				tmp[i] = data[i];
			}
			tmp[index] = item;
			for(int i=index+1; i<=data.length; i++) {
				tmp[i] = data[i-1];
			}
			data = tmp;
		}
		//TODO make add(T item) call add(int index, T item) in order for them to behave the same way
	}
	
	@Override
	public String toString() {
		String charSequence ="Vector contains ";
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
	
	@Override
	public boolean containsAll(List<T> list) {
		int size = size();
		for(int i=0; i<size;) {
			if(!this.contains(get(i)))
				return false;
			++i;
		}
		return true;
	}
}
