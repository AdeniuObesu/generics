/**
 * 
 */
package org.adeniuobesu.generics;

/**
 * @author MOUKHAFI Anass
 *
 * Nov 7, 2022
 */
public interface Set<T> {
	int size();
	
	boolean remove(T item);
	
	boolean add(T item);
	
	boolean contains(T item);

	boolean isEmpty();
}
