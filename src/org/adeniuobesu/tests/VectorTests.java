package org.adeniuobesu.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.adeniuobesu.generics.List;
import org.adeniuobesu.generics.Vector;
import org.adeniuobesu.model.Complexe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * @author MOUKHAFI Anass
 * 
 * Oct 24, 2022
 */
@DisplayName("Tests de Vector")
public class VectorTests {
	List<Integer> listInteger;
	Vector<Complexe> listComplexe;
	
	@BeforeEach
	void setUp() {
		listInteger = new Vector<>();
		listComplexe = new Vector<>();
	}
	
	@Test
	@DisplayName("Test de clone")
	void testClone() {
		Complexe c = new Complexe(9, 3);
		listComplexe.add(c);
		listComplexe.add(new Complexe(2, 4));
		@SuppressWarnings("unchecked")
		List<Complexe> copy = (List<Complexe>) listComplexe.clone();
		
		assertAll(
				() -> assertEquals(copy.get(0), c),
				() -> assertEquals(copy.size(), 2)
			);
	}
	
	@Test
	@DisplayName("Test de la taille d'un vector")
	void testSize() {
		// ASSIGN | ACT | ASSERT (AAA)
		assertEquals( 0, listInteger.size());
	}
	
	@Test
	@DisplayName("Test d'ajout dans vector")
	void testAdd() {
		listInteger.add(3);
		listInteger.add(2);
		assertEquals(2, listInteger.size());
	}
	
	@Test
	@DisplayName("Test de retrait de vector")
	void testRemove() {
		listInteger.add(20);
		listInteger.add(25);
		listInteger.add(31);
		listInteger.add(12);
		listInteger.add(18);
		
		int e0 = (int) listInteger.remove(0);
		int e1 = (int) listInteger.remove(3);
		
		assertAll(
			() -> assertEquals(20, e0),
			() -> assertEquals(18, e1),
			() -> assertEquals(3, listInteger.size()),
			() -> assertThrowsExactly(
					IndexOutOfBoundsException.class,
					() -> {
						listInteger.remove(5);
					}
				)
		);
	}
	
	@Test
	@DisplayName("Test de contains")
	void testContains() {
		Complexe element = new Complexe(4, 1);
		
		listComplexe.add(element);
		
		assertTrue(listComplexe.contains(element));
	}
	
	@Test
	@DisplayName("Test de clear")
	void testClear() {
		listComplexe.add(new Complexe());
		listComplexe.add(new Complexe(3, 2));
		listComplexe.add(new Complexe(2, 1));
		
		listComplexe.clear();
		
		assertEquals(0, listComplexe.size());
	}
	
	@Test
	@DisplayName("Test de equals")
	void testEquals() {
		listComplexe.add(new Complexe());
		listComplexe.add(new Complexe(3, 2));
		
		List<Complexe> listComplexe_ = new Vector<>();

		listComplexe_.add(new Complexe());
		listComplexe_.add(new Complexe(3, 2));
		
		
		assertTrue(listComplexe.equals(listComplexe_));
	}
	
	@Test
	@DisplayName("Test de indexOf")
	void testIndexOf() {
		Complexe c = new Complexe(21, 10);

		listComplexe.add(new Complexe(3, 34));
		listComplexe.add(c);
		listComplexe.add(new Complexe());

		assertEquals(1, listComplexe.indexOf(c));
		assertEquals(-1, listComplexe.indexOf(null));
	}
	
	@Test
	@DisplayName("Test de indexOf a partir d'un index")
	void testIndexOfStartingFromAnIndex() {
		Complexe c = new Complexe(21, 10);

		listComplexe.add(new Complexe(3, 34));
		listComplexe.add(c);
		listComplexe.add(new Complexe());
		listComplexe.add(null);
		listComplexe.add(new Complexe(4, 16));
		listComplexe.add(new Complexe(3, 9));

		assertEquals(1, listComplexe.indexOf(c, 1));
		assertEquals(3, listComplexe.indexOf(null, 1));
		assertEquals(-1, listComplexe.indexOf(null, 4));
	}
	
	@Test
	@DisplayName("Test de set Element a un index")
	void testSetElementInIndex() {
		Complexe c = new Complexe(21, 10);

		listComplexe.add(new Complexe(3, 34));
		listComplexe.add(new Complexe());
		listComplexe.add(null);
		
		assertNull(listComplexe.set(2, c));
	}
	

	@Test
	@DisplayName("Test d'iterabilite de Vector")
	void testIterability() {
		listInteger.add(1);
		listInteger.add(2);
		listInteger.add(3);
		listInteger.add(4);
		int sum = 0;
		
		for(Integer element : listInteger) {
			sum += element;
		}
		
		assertEquals(10, sum);
	}
	
	@Test
	@DisplayName("Test de subList d'un interval donne")
	void testSubList() {
		listInteger.add(1);
		listInteger.add(2);
		listInteger.add(3);
		listInteger.add(4);
		listInteger.add(5);
		
		assertAll(
				()->assertNotNull(listInteger.subList(1, 3)),
				()->assertEquals(3, listInteger.subList(1, 3).size()),
				()->assertNull(listInteger.subList(3, 1)),
				()->assertNull(listInteger.subList(3, 6))
			);
	}
	
	@Test
	@DisplayName("Test de toArray de Vector")
	void testToArray() {
		listInteger.add(1);
		listInteger.add(2);
		listInteger.add(3);
		listInteger.add(4);
		listInteger.add(5);
		
		Object[] array = listInteger.toArray();
		
		assertAll(
				()->assertNotNull(array),
				()->assertEquals(5, array.length)
			);
	}
	
	@AfterEach
	void tearDown() {
		listInteger = null;
		listComplexe = null;
	}
}
