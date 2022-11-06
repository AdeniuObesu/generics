/**
 * 
 */
package org.adeniuobesu.generics;

/**
 * @author MOUKHAFI Anass
 * 
 * Oct 22, 2022
 */
public class Examples {
	public Examples() {
		exp01();
	}
	void exp01() {
		List<Integer> list = new LinkedList<>();
		list.add(3);
		list.add(2);
		list.add(10);
		list.add(31);
		list.add(22);
		
		int size = list.size();
		
//		for(int i=0; i < size; i++) {
//			System.out.println(" Element " + (i + 1) + " - " + list.get(i));
//		}
		int i=0;
		for(Integer item : list) {
			System.out.println( "Element in index " + i +" : "+ item);
			i++;
		}
		
	}
	public static void main(String[] args) {
		new Examples();
	}
}
