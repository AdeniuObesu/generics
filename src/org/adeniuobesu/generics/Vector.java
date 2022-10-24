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
		return (T) data[index];
	}

	@Override
	public int size() {
		return data.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	synchronized public T remove(int index) {
		if(index >= data.length)
			return null;
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

}
