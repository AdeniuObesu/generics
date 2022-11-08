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
	
	public LinkedSet(){
		value = null;
		next = null;
	}
	
	public LinkedSet(T value) {
		this.value = value;
		this.next = null;
	}
	
	public boolean isEmpty() {
		return (value == null);
		// for us this is an enough condition for emptiness
	}
	
	@Override
	public int size() {
		if(value == null)
			return 0;
		else if(next != null)
			return 1 + next.size();
			else
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
				next.add(item); // Then just pass the item through
			else {
				LinkedSet<T> node;
				node = new LinkedSet<>(value); // Node has the current value
				this.value = item;
				this.next = node;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(T item) {
		if(value == null)
			return false;
		else if(next == null) {
			return (value.equals(item));
		} else {
			if(value.equals(item))
				return true;
		}
		return next.contains(item);
	}
	
	@Override
	public void clear() {
		if(!isEmpty()) {
			value = null;
			next.clear();
			next = null;
		}
	}
	
	@Override
	public String toString() {
		String charSequence = "LinkedSet contains ";
		if(size() == 0)
			return charSequence.concat("no elements.");
		for(LinkedSet<T> cursor = this; cursor.next!=null;) {
			charSequence = charSequence + cursor.value + "-";
			cursor = cursor.next;
		}
		return charSequence;
	}
}
