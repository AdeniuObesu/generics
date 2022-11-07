/**
 * 
 */
package org.adeniuobesu.tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.adeniuobesu.generics.LinkedSet;
import org.adeniuobesu.generics.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author MOUKHAFI Anass
 *
 * Nov 7, 2022
 */
@DisplayName("Tests de LinkedSet")
public class LinkedSetTests {
	Set<Integer> setInteger; 
	@BeforeEach
	void setUp() {
		setInteger = new LinkedSet<>(0);
	}
	
	@Test
	@DisplayName("Test de add")
	void testAdd() {
		boolean flag = setInteger.add(1);
		
		assertAll(
				() -> assertTrue(flag),
				() -> assertTrue(setInteger.add(3)),
				() -> assertTrue(setInteger.add(4)),
				() -> assertFalse(setInteger.add(null))
			);
	}
	
	@Test
	@DisplayName("Test de size")
	void testSize() {
		setInteger.add(1);
		setInteger.add(1);
		setInteger.add(3);
		setInteger.add(4);
		
		assertEquals(4, setInteger.size());
	}
	
	@Test
	@DisplayName("Test de contains")
	void testContains() {
		int value = 3;
		setInteger.add(1);
		setInteger.add(1);
		setInteger.add(value);
		setInteger.add(4);
		
		assertAll(
				() -> assertTrue(setInteger.contains(value)),
				() -> assertFalse(setInteger.contains(null)),
				() -> assertEquals(4, setInteger.size())
			);
	}
	
	@Test
	@DisplayName("Test de remove")
	void testRemove() {
		int value = 3;
		setInteger.add(1);
		setInteger.add(value);
		setInteger.add(4);
		
		assertAll(
				() -> assertTrue(setInteger.remove(value)),
				() -> assertFalse(setInteger.remove(null)),
				() -> assertEquals(3, setInteger.size())
			);
	}
	
	@AfterEach
	void tearDown() {
		setInteger = null;
	}
}
