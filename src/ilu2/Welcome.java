package ilu2;

import java.util.ArrayList;

public class Welcome {
	
	// des fonctions supplémentaires pour aider
	
	private static String minusculeToMajuscule(String ligne) {
		ligne = ligne.trim();
		char[] chars = ligne.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		ligne = String.valueOf(chars);
		return ligne;
	}
	
	private static void ajouterPrenom(StringBuilder message, String prenom) {
		StringBuilder ajout = new StringBuilder(", ");
		prenom = minusculeToMajuscule(prenom);
		ajout.append(prenom);
		message.append(ajout);
	}
	
	private static void ajouterPrenomAvecAnd(StringBuilder message, String prenom) {
		StringBuilder ajout = new StringBuilder(" and ");
		prenom = minusculeToMajuscule(prenom);
		ajout.append(prenom);
		message.append(ajout);
	}
			
	private static String[] trouverMajuscules(String[] liste) {
		String[] sansRep = supprimerRepetitions(liste);
		int nbMaj = 0;
		ArrayList<String> enMaj = new ArrayList<>();
		for (int i = 0; i < sansRep.length; i++) {
			if (sansRep[i].equals(sansRep[i].toUpperCase())) {
				enMaj.add(sansRep[i]);
				nbMaj++;
			}
		}
		String[] seulMaj = new String[nbMaj];
		int i = 0;
		for (String prenom : enMaj) {
			seulMaj[i] = prenom;
			i++;
		}
		int[] repetitions = compterRepetitions(liste, seulMaj);
		String[] allPrenomsMaj = fusionnerPrenomRep(seulMaj, repetitions);
		return allPrenomsMaj;
	}
	
	private static String[] trouverMinuscules(String[] liste) {
		String[] sansRep = supprimerRepetitions(liste);
		int nbMin = 0;
		ArrayList<String> enMin = new ArrayList<>();
		for (int i = 0; i < sansRep.length; i++) {
			if (! sansRep[i].equals(sansRep[i].toUpperCase())) {
				enMin.add(sansRep[i]);
				nbMin++;
			}
		}
		String[] seulMin = new String[nbMin];
		int i = 0;
		for (String prenom : enMin) {
			seulMin[i] = prenom;
			i++;
		}
		int[] repetitions = compterRepetitions(liste, seulMin);
		String[] allPrenomsMin = fusionnerPrenomRep(seulMin, repetitions);
		return allPrenomsMin;
	}
	
	private static String phraseEnMajuscule(String[] liste) {
		StringBuilder message = new StringBuilder("HELLO");
		if (liste.length == 1) {
			ajouterPrenom(message, liste[0]);
		} else {
			for (int i = 0; i < liste.length; i++) {
				if ((i == liste.length - 1)) {
					ajouterPrenomAvecAnd(message, liste[i]);
				} else {
					ajouterPrenom(message, liste[i]);
				}
			}
		}
		message.append(" !");
		return message.toString().toUpperCase();
	}
	
	private static String phraseEnMinuscule(String[] liste) {
		StringBuilder message = new StringBuilder("Hello");
		if (liste.length == 1) {
			ajouterPrenom(message, liste[0]);
		} else {
			for (int i = 0; i < liste.length; i++) {
				if ((i == liste.length - 1)) {
					ajouterPrenomAvecAnd(message, liste[i]);
				} else {
					ajouterPrenom(message, liste[i]);
				}
			}
		}
		return message.toString();
	}
	
	private static boolean existeMajuscule(String[] liste) {
		for (int i = 0; i < liste.length; i++) {
			if (liste[i].equals(liste[i].toUpperCase())) return true;
		}
		return false;
	}
	
	private static String[] supprimerRepetitions(String[] liste) {
		int len = 0;
		ArrayList <String> sansRepetitions = new ArrayList<>();
		for (int i = 0; i < liste.length; i++) {
			if (sansRepetitions.isEmpty() || !sansRepetitions.contains(liste[i])) {
				sansRepetitions.add(liste[i]);
				len++;
			}
		}
		String[] pasDeRep = new String[len];
		int i = 0;
		for (String elem : sansRepetitions) {
			pasDeRep[i] = elem;
			i++;
		}
		return pasDeRep;
	}
	
	private static String[] fusionnerPrenomRep(String[] prenoms, int[] reps) {
		String[] newNames = new String[prenoms.length];
		System.out.println("$$$$$$");
		for(String p : prenoms)
			System.out.println(p);
		for(int r : reps)
			System.out.println(r);

		for (int i = 0; i < prenoms.length; i++) {
			if (reps[i] == 1) newNames[i] = prenoms[i];
			else {
				StringBuilder nom = new StringBuilder(prenoms[i]);
				nom.append(" (x");
				nom.append(String.valueOf(reps[i]));
				nom.append(")");
				newNames[i] = nom.toString();
				//newNames[i] = prenoms[i] + " (x" + reps[i] + ")";
			}
		}
		return newNames;
	}
			
	private static int[] compterRepetitions(String[] prenoms, String[] prenomsSansRep) {
		int[] repetitions = new int[prenomsSansRep.length];
		for (int i = 0; i < prenomsSansRep.length; i++) repetitions[i] = 0;
		
		for (int j = 0; j < prenomsSansRep.length; j++) {
			 for (int k = 0; k < prenoms.length; k++) {
				 if (prenoms[k].equals(prenomsSansRep[j])) repetitions[j]++;
			 }
		}
		return repetitions;
	}
	
	public static String[] trimAll(String[] input) {
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++) {
			result[i] = input[i].trim();
		}
		return result;
	}
	
	// FONCTION WELCOME !!! FONCTION WELCOME !!! FONCTION WELCOME !!!
	
	public static String welcome(String input) {
		StringBuilder hello = new StringBuilder("Hello");
		if (input == null || input.trim().equals("")) {
			hello.append(", my friend");
			return hello.toString();
		} 
		if (!input.contains(",")) {
			ajouterPrenom(hello, minusculeToMajuscule(input));
			if (input.equals(input.toUpperCase())) {
				hello.append(" !");
				return hello.toString().toUpperCase();
			}
			return hello.toString();	
		} else {
			String[] all = input.trim().split(",");
			all = trimAll(all);
			if (!existeMajuscule(all)) return phraseEnMinuscule(trouverMinuscules(all));
			else {
				if (input.equals( input.toUpperCase())) return phraseEnMajuscule(trouverMajuscules(all));
				else return phraseEnMinuscule(trouverMinuscules(all)) + ". AND " + phraseEnMajuscule(trouverMajuscules(all));
			}
		}
	}
	
}
