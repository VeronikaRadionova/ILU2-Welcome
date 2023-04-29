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
	
	private static void ajouterAvecAnd(StringBuilder message, String prenom) {
		StringBuilder ajout = new StringBuilder(" and ");
		prenom = minToMaj(prenom);
		ajout.append(prenom);
		message.append(ajout);
	}
	
	private static String[] trouverMaj(String[] liste) {
		int nbMaj = 0;
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] == liste[i].toUpperCase()) {
				nbMaj++;
			}
		}
		int indice = 0;
		String[] prenoms = new String[nbMaj];
		for (int j = 0; j < liste.length; j++) {
			if (liste[j] == liste[j].toUpperCase()) {
				prenoms[indice] = liste[j];
				indice++;
			}
		}
		return prenoms;
	}
	
	private static String[] trouverMin(String[] liste) {
		int nbMin = 0;
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] != liste[i].toUpperCase()) {
				nbMin++;
			}
		}
		String[] prenoms = new String[nbMin];
		int indice = 0;
		for (int j = 0; j < liste.length; j++) {
			if (liste[j] != liste[j].toUpperCase()) {
				prenoms[indice] = liste[j];
				indice++;
			}
		}
		return prenoms;
	}
	
	private static String phraseMaj(String[] liste) {
		StringBuilder message = new StringBuilder("HELLO");
		if (liste.length == 1) {
			ajouterPrenom(message, liste[0]);
		} else {
			for (int i = 0; i < liste.length; i++) {
				if (i == liste.length - 1) {
					ajouterAvecAnd(message, liste[i]);
				} else {
					ajouterPrenom(message, liste[i]);
				}
			}
		}
		message.append(" !");
		return message.toString().toUpperCase();
	}
	
	
	private static String phraseMin(String[] liste) {
		StringBuilder message = new StringBuilder("Hello");
		if (liste.length == 1) {
			ajouterPrenom(message, liste[0]);
		} else {
			for (int i = 0; i < liste.length; i++) {
				if (i == liste.length - 1) {
					ajouterAvecAnd(message, liste[i]);
				} else {
					ajouterPrenom(message, liste[i]);
				}
			}
		}
		message.append(". ");
		return message.toString();
	}
	
	
	private static boolean existeMaj(String[] liste) {
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
			
			if (!existeMaj(prenoms)) {
				for (int i = 0; i < prenoms.length; i++) {
					ajouterPrenom(hello, prenoms[i]);
				}
				return hello.toString();
			} else {
				if (input == input.toUpperCase()) {
					String[] liste = trouverMaj(prenoms);
					return phraseMaj(liste);
				}
				
				String phrase1 = phraseMin(trouverMin(prenoms));
				String phrase2 = phraseMaj(trouverMaj(prenoms));
				phrase2 = "AND " + phrase2;
				return phrase1 + phrase2;
			}
		}
	}
}
