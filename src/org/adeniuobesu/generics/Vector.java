package org.adeniuobesu.generics;
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
}
