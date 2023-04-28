package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test1() {
		assertEquals("Hello, Bob", Welcome.welcome("bob"));
		assertEquals("Hello, Bob", Welcome.welcome("Bob"));
	}
	
	@Test
	void test2() {
		assertEquals("Hello, my friend", Welcome.welcome(null));
		assertEquals("Hello, my friend", Welcome.welcome("   "));
		assertEquals("Hello, my friend", Welcome.welcome(""));
	}
	
	@Test
	void test3() {
		assertEquals("HELLO, JERRY !", Welcome.welcome("JERRY"));
	}
	
	@Test
	void test4() {
		assertEquals("Hello, Amy, Bob", Welcome.welcome("amy,Bob"));
		assertEquals("Hello, Amy, Bob", Welcome.welcome("amy, bob"));
		assertEquals("Hello, Amy, Bob", Welcome.welcome(" Amy,bob"));
	}
	
	@Test
	void test5() {
		assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome("amy,Bob, jerry"));
		assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome(" Amy, bob,Jerry"));
		assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome("amy,bob,Jerry"));
		assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome("Amy,bob,jerry"));
	}
}
