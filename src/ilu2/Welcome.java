package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder("Hello, ");
		if (input == null || input.trim() == "") {
			hello.append("my friend");
			return hello.toString();
		}
		
		return "Hello, Bob";
	}
}
