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
	// Tests all LinkedList's features
	private void exp01() {
		integerLinkedList = new LinkedList<>();
		integerLinkedList.add(2);
		integerLinkedList.add(15);
		integerLinkedList.add(3);
		integerLinkedList.add(2, 4);
		integerLinkedList.add(2, 8);
		System.out.println(integerLinkedList);
		integerLinkedList.clear();
		System.out.println(integerLinkedList);
		integerLinkedList = null;
	}
	
	// Tests all Vector's features
	private void exp02() {
		
	}
	
	// Tests all LinkedSet's implemented features
	private void exp03() {
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
