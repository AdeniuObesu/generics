package org.adeniuobesu.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.adeniuobesu.generics.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTests {
	LinkedList<Integer> list;
	@BeforeEach
	void setUp() {
		list = new LinkedList<>();
	}
	
	@Test
	void testSize() {
		// ASSIGN | ACT | ASSERT (AAA)
		assertEquals( 0, list.size());
	}
	
	@Test
	void testAdd() {
		list.add(3);
		list.add(2);
		assertEquals(2, list.size());
	}
	
	@Test
	void testRemove() {
		list.add(20);
		list.add(25);
		list.add(31);
		list.add(12);
		list.add(18);
		
		int e0 = (int) list.remove(0);
		int e1 = (int) list.remove(3);
		Object e3 = list.remove(5);
		
		assertAll(
			() -> assertEquals(20, e0),
			() -> assertEquals(18, e1),
			() -> assertEquals(3, list.size()),
			() -> assertNull(e3)
		);
	}
	
	@AfterEach
	void tearDown() {
		list = null;
	}
}
