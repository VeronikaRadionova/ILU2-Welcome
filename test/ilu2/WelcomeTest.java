package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	//certains tests des test4, test5 et test6 sont copiés et un peu modifiés dans le test8 en s'appuiant sur le fait qu'on doit utiliser "and" et "AND" après les modifications de 7 

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
	
	@Test // quand on commence à gérer le cas avec "and" et "AND", ces tests se cassent car ici on a utilisé seulement des virgules ce qui n'est pas le cas avancé
	void test4() {
		//assertEquals("Hello, Amy, Bob", Welcome.welcome("amy,Bob"));
		//assertEquals("Hello, Amy, Bob", Welcome.welcome("amy,bob"));
		//assertEquals("Hello, Amy, Bob", Welcome.welcome("Amy,bob"));
		//assertEquals("Hello, Amy, Bob", Welcome.welcome("Amy,Bob"));
	}
	
	@Test // quand on commence à gérer le cas avec "and" et "AND", ces tests se cassent car ici on a utilisé seulement des virgules ce qui n'est pas le cas avancé
	void test5() {
		//assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome("amy,Bob, jerry"));
		//assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome(" Amy, bob,Jerry")); - dans le 8
		//assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome("amy,bob,Jerry"));
		//assertEquals("Hello, Amy, Bob, Jerry", Welcome.welcome("Amy,bob,jerry"));
	}
	
	@Test // quand on commence à gérer le cas avec "and" et "AND", ces tests se cassent car ici on a utilisé seulement des virgules ce qui n'est pas le cas avancé
	void test6() { 
		//assertEquals("Hello, Amy, Jerry. AND HELLO, BOB !", Welcome.welcome("Amy, BOB, Jerry"));
		//assertEquals("Hello, Jerry. AND HELLO, AMY, BOB !", Welcome.welcome("AMY, BOB, Jerry")); - dans le 8
		//assertEquals("HELLO, AMY, BOB !", Welcome.welcome("AMY, BOB"));
	}
	
	@Test 
	void test7() {
		assertEquals("Hello, Amy and Jerry. AND HELLO, BOB !", Welcome.welcome("Amy, BOB, Jerry"));
		assertEquals("Hello, Jerry. AND HELLO, AMY AND BOB !", Welcome.welcome("AMY, BOB, Jerry"));
		assertEquals("HELLO, AMY AND BOB !", Welcome.welcome("AMY, BOB"));
	}
	
	@Test
	void test8() {
		assertEquals("Hello, Bob and Amy", Welcome.welcome("bob    ,    amy"));
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome(" Amy, bob    ,    Jerry"));
		assertEquals("Hello, Jerry. AND HELLO, AMY AND BOB !", Welcome.welcome("   AMY,  BOB   ,Jerry  "));
	}
	
	@Test
	void test9() {
		assertEquals("Hello, Bob (x2)",Welcome.welcome("bob, bob"));
		assertEquals("Hello, Bob (x2) and Amy. AND HELLO, JERRY !",Welcome.welcome("bob, JERRY, amy, bob"));
		assertEquals("Hello, Bob (x3) and Amy. AND HELLO, JERRY (X2) !",Welcome.welcome("bob, JERRY, amy, bob, JERRY, bob"));
	}
}
