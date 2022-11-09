/**
 * 
 */
package org.mql.java.generics;

import org.mql.java.generics.util.Iterable;

/**
 * @author MOUKHAFI Anass
 *
 * Nov 7, 2022
 */
public interface Set<T> extends Iterable<T>{
	int size();
	
	boolean remove(T item);
	
	boolean add(T item);
	
	boolean contains(T item);

	boolean isEmpty();
	
	void clear();
}
