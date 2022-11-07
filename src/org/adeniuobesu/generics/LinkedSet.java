/**
 * 
 */
package org.adeniuobesu.generics;

/** LinkedSet class does not contains neither duplicates nor null values
 * @author MOUKHAFI Anass
 *
 * Nov 7, 2022
 */
public class LinkedSet<T> implements Set<T> {

	private T value;
	private LinkedSet<T> next;
	
	public LinkedSet(T value) {
		this.value = value;
		this.next = null;
	}
	
	@Override
	public int size() {
		if(next != null)
			return 1 + next.size();
		return 1;
	}

	@Override
	public boolean remove(T item) {
		if(item != null && contains(item)) {
			for(LinkedSet<T> cursor = this; cursor!=null;) {
				if(cursor.value.equals(item)) {
					cursor.value = cursor.next.value;
					cursor.next = cursor.next.next;
					return true; // Element removed
				}
				cursor = cursor.next;
			}
		}
		return false;
	}

	@Override
	public boolean add(T item) {
		if(item != null && !contains(item)) {
			if(next != null)
				next.add(item);
			else {
				LinkedSet<T> node;
				node = new LinkedSet<>(this.value); // Node has the current value
				this.value = item;
				this.next = node;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(T item) {
		if(next == null) {
			if(!value.equals(item))
				return false;
		} else {
			if(value.equals(item))
				return true;
		}
		return next.contains(item);
	}
	
	@Override
	public String toString() {
		String line = "";
		for(LinkedSet<T> cursor = this; cursor!=null; cursor = cursor.next) {
			line = line.concat("-" + cursor.value);
			
		}
		return line;
	}
}
