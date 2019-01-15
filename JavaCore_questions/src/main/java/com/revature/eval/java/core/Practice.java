package com.revature.eval.java.core;

public class Practice {

	public static void main(String[] args) {
		System.out.println(acronym("Aasd Sasdf Hasdf"));
	}
	
	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public static String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		
		// split phrase into separate words
		String[] split = phrase.split("\\s+");
		
		// extract first char of each word into variable
		char first = split[0].charAt(0);
		char second = split[1].charAt(0);
		char third = split[2].charAt(0);
		
		// join each char to make acronym
		String acronym = "" + first + second + third;
		
		return acronym;
	}
}
