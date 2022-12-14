/**
 * 
 */
package org.mql.java.generics;

/** Elle s'agit de la classe principale des tests
 * Regroupant l'ensemble des traitements sur :
 * - LinkedList et ses fonctionnalites.
 * - Vector et ses fonctionnalites.
 * - L'implementation LinkedSet de Set et ses eventuelles fonctionnalites.
 * 
 * @author MOUKHAFI Anass
 *
 * Nov 8, 2022
 */
public class Main {
	
	List<Integer> list;
	Set<Integer> set;
	// We'll need a temporary list to compare it with our main list [LinkedList, Vector]
	List<Integer> tempList;
	
	public Main() {
		exp01();
		exp02();
		exp03();
	}
	// Tests all LinkedList's features
	private void exp01() {
		list = new LinkedList<>();
		
		System.out.println(list.isEmpty()); // prints true
		list.add(3);
		System.out.println(list.isEmpty()); // prints false
		list.add(0, 4); // 4-3
		
		List<Integer> tempList = new LinkedList<>();
		tempList.add(4);
		tempList.add(7);
		
		System.out.println(list.contains(4)); //prints true
		System.out.println(list.contains(null)); // prints false
		System.out.println(list.contains(8)); // prints false
		
		System.out.println(list.size()); //prints 2
		
		System.out.println(list); // prints (4-3).
		
		list.add(1, 7); // list (4-7-3) & tempList (4-7)
		// Compare elements's existence
		System.out.println(list.containsAll(tempList)); // prints true
		System.out.println(list.equals(tempList)); // prints false
		tempList.add(3);
		System.out.println(list.equals(tempList)); // prints true
		
		System.out.println(list.set(0, 12)); // removes 4 and sets 12
		System.out.println(list.get(0)); // prints 12
		list.add(19);// Our list is now containing (12-7-3-19)
		
		System.out.println(list.subList(1, 3)); // subList contains (7-3-19)
		System.out.println(list.remove(1)); // removes and prints 7
		
		System.out.println(list.indexOf(12)); // prints 0
		System.out.println(list); // 12-3-19
		System.out.println(list.indexOf(19, 1)); // starts searching from position 1 returns 2
		
		list.clear(); // empties (clears) the list
		System.out.println(list); // prints LinkedList contains no elements.
		list = null;
		tempList.clear();
		tempList = null;
	}
	
	// Tests all Vector's features
	private void exp02() {
		list = new Vector<>();
		
		System.out.println(list.isEmpty()); // prints true
		list.add(3);
		System.out.println(list.isEmpty()); // prints false
		list.add(0, 4); // 4-3
//		
		List<Integer> tempList = new Vector<>();
		tempList.add(4);
		tempList.add(7);
//		
		System.out.println(list.contains(4)); //prints true
		System.out.println(list.contains(null)); // prints false
		System.out.println(list.contains(8)); // prints false
//		
		System.out.println(list.size()); //prints 2
//		
		System.out.println(list); // prints (4-3).
//		
		list.add(1, 7); // list (4-7-3) & tempList (4-7)
//		// Compare elements's existence
		System.out.println(list.containsAll(tempList)); // prints true
		System.out.println(list.equals(tempList)); // prints false
		tempList.add(3);
		System.out.println(list.equals(tempList)); // prints true
//		
		System.out.println(list.set(0, 12)); // removes 4 and sets 12
		System.out.println(list.get(0)); // prints 12
		list.add(19);// Our list is now containing (12-7-3-19)
//		
		System.out.println(list.subList(1, 3)); // subList contains (7-3-19)
		System.out.println(list.remove(1)); // removes and prints 7
//		
		System.out.println(list.indexOf(12)); // prints 0
		System.out.println(list); // 12-3-19
		System.out.println(list.indexOf(19, 1)); // starts searching from position 1 returns 2
//		
		list.clear(); // empties (clears) the list
		System.out.println(list); // prints LinkedList contains no elements.
		list = null;
		tempList.clear();
		tempList = null;
	}
	
	// Tests all LinkedSet's implemented features
	private void exp03() {
		set = new LinkedSet<Integer>();
		System.out.println(set.isEmpty()); // prints true
		set.add(6);
		System.out.println(set.contains(3)); // prints false
		System.out.println(set.contains(null)); // prints false
		System.out.println(set.contains(6)); // prints true
		set.add(7); // 6-7

		System.out.println(set.remove(2)); // prints false because the set doesn't contain 2
		System.out.println(set.remove(null));
		// prints false because the set doesn't contain any null values
		System.out.println(set.remove(6)); // prints true and 6 is removed
		
		System.out.println(set); // 7 remains in our list
		set.clear();
		System.out.println(set); // prints LinkedSet contains no elements.
		set = null;
		//END
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
