package ilu2;

public class Welcome {
	
	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder("Hello, ");
		if (input == null || input.trim() == "") {
			hello.append("my friend");
			return hello.toString();
		} else if (input == input.toUpperCase()) {
			hello.append(input + " !");
			return hello.toString().toUpperCase();
		}
		return "Hello, Bob";
	}
}
