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
}
