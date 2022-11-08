/**
 * 
 */
package org.adeniuobesu.generics;

/** Elle s'agit de la classe principale des tests
 * qui regroupe l'ensemble des traitements sur :
 * LinkedList et ses fonctionnalites.
 * Vector et ses fonctionnalites.
 * L'implementation LinkedSet de Set et ses eventuelles fonctionnalites.  
 * @author MOUKHAFI Anass
 *
 * Nov 8, 2022
 */
public class Main {
	
	List<Integer> integerLinkedList, integerVector;
	Set<Integer> integerLinkedSet;
	
	public Main() {
		exp01();
		exp02();
		exp03();
	}
	// Tests LinkedList
	private void exp01() {
		integerLinkedList = new LinkedList<>();
		integerLinkedList.add(3);
		integerLinkedList.add(2);
		integerLinkedList.add(15);
		integerLinkedList.add(3);
		System.out.println(integerLinkedList);
		integerLinkedList.clear();
		System.out.println(integerLinkedList);
		integerLinkedList = null;
	}
	
	// Tests Vector
	private void exp02() {
		
	}
	
	// Tests LinkedSet
	private void exp03() {
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
