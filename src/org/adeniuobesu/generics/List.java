package org.adeniuobesu.generics;

public interface List<T> {
	void add(T item);
	T get(int index);
	int size();
	T remove(int index);
}
