package ilu2;

public class Welcome {
	
	private static String minToMaj(String ligne) {
		ligne = ligne.trim();
		char[] chars = ligne.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		ligne = String.valueOf(chars);
		return ligne;
	}
	
	private static void ajouterPrenom(StringBuilder message, String prenom) {
		StringBuilder ajout = new StringBuilder(", ");
		prenom = minToMaj(prenom);
		ajout.append(prenom);
		message.append(ajout);
	}
	
	
	
	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder("Hello");
		
		if (input == null || input.trim() == "") {
			hello.append(", my friend");
			return hello.toString();
			
		} else if (input == input.toUpperCase()) {
			ajouterPrenom(hello, input + " !");
			return hello.toString().toUpperCase();
			
		}
		if (input.contains(",")) {
			String[] plusieursNoms = input.split(",");
			for (int i = 0; i < plusieursNoms.length; i++) {
				ajouterPrenom(hello, plusieursNoms[i]);
			}
			return hello.toString();
			
		} else {
			ajouterPrenom(hello, minToMaj(input));
			return hello.toString();
		}
	}
}
