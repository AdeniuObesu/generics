package org.adeniuobesu.tests;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	List<Complexe> listComplexe;
	
	@BeforeEach
	void setUp() {
		listInteger = new Vector<>();
		listComplexe = new Vector<>();
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
		Integer e2 = listInteger.remove(5);
		
		assertAll(
			() -> assertEquals(20, e0),
			() -> assertEquals(18, e1),
			() -> assertEquals(3, listInteger.size()),
			() -> assertNull(e2)
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
	
	@AfterEach
	void tearDown() {
		listInteger = null;
		listComplexe = null;
	}
}
