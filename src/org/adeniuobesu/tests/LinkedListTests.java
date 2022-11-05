package org.adeniuobesu.tests;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.adeniuobesu.generics.LinkedList;
import org.adeniuobesu.generics.List;
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
@DisplayName("Tests de LinkedList")
public class LinkedListTests {
	List<Integer> listInteger;
	List<Complexe> listComplexe;
	@BeforeEach
	void setUp() {
		listInteger = new LinkedList<>();
		listComplexe = new LinkedList<>();
	}
	
	@Test
	void testSize() {
		// ASSIGN | ACT | ASSERT (AAA)
		assertEquals(0, listInteger.size());
	}
	
	@Test
	void testAdd() {
		listInteger.add(3);
		listInteger.add(2);
		listComplexe.add(null);
		
		assertEquals(2, listInteger.size());
		assertEquals(0, listComplexe.size());
	}
	
	@Test
	void testRemove() {
		listInteger.add(20);
		listInteger.add(25);
		listInteger.add(31);
		listInteger.add(12);
		listInteger.add(18);
		
		int e0 = (int) listInteger.remove(0);
		int e1 = (int) listInteger.remove(3);
		Object e3 = listInteger.remove(5);
		
		assertAll(
			() -> assertEquals(20, e0),
			() -> assertEquals(18, e1),
			() -> assertEquals(3, listInteger.size()),
			() -> assertNull(e3)
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
		
		List<Complexe> listComplexe_ = new LinkedList<>();

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
	void testIndexOfStratingFromAnIndex() {
		Complexe c = new Complexe(21, 10);

		listComplexe.add(null); // Does nothing
		
		listComplexe.add(new Complexe(3, 34));
		listComplexe.add(c);
		listComplexe.add(new Complexe());
		listComplexe.add(null);

		assertEquals(3, listComplexe.indexOf(null, 0));
		assertEquals(1, listComplexe.indexOf(c, 1));
	}
	
	@AfterEach
	void tearDown() {
		listInteger = null;
		listComplexe = null;
	}
}
