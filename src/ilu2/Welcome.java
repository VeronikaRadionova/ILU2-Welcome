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
	
	
	private static String phraseMaj(String[] liste) {
		StringBuilder message = new StringBuilder("HELLO");
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] == liste[i].toUpperCase()) {
				ajouterPrenom(message, liste[i]);
			}
		}
		message.append(" !");
		return message.toString().toUpperCase();
	}
	
	private static String phraseMin(String[] liste) {
		StringBuilder message = new StringBuilder("Hello");
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] != liste[i].toUpperCase()) {
				ajouterPrenom(message, liste[i]);
			}
		}
		message.append(". ");
		return message.toString();
	}
	
	
	private static boolean trouverMaj(String[] liste) {
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] == liste[i].toUpperCase()) return true;
		}
		return false;
	}
	
	
	
	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder("Hello");
		StringBuilder and = new StringBuilder("and ");
		
		if (input == null || input.trim() == "") {
			hello.append(", my friend");
			return hello.toString();
		} 
		
		if (!input.contains(",")) {
			if (input == input.toUpperCase()) {
				ajouterPrenom(hello, input + " !");
				return hello.toString().toUpperCase();
			} else {
				ajouterPrenom(hello, minToMaj(input));
				return hello.toString();
			}
		} else {
			input = input.trim();
			String[] prenoms = input.split(",");
			
			if (!trouverMaj(prenoms)) {
				for (int i = 0; i < prenoms.length; i++) {
					ajouterPrenom(hello, prenoms[i]);
				}
				return hello.toString();
			} else {
				
				if (input == input.toUpperCase()) {
					return phraseMaj(prenoms);
				}
				
				String partie1 = phraseMin(prenoms);
				String partie2 = phraseMaj(prenoms);
				partie2 = "AND " + partie2;
				return partie1 + partie2;
			}
		}
	}
}
