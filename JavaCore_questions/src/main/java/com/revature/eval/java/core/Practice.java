package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("___________ \n Practice \n"
				+ "___________"));
		AtbashCipher ac = new AtbashCipher();
		System.out.println(ac.encode("Testing,1 2 3, testing."));
		
		
	}
	
	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {

			// returns alphabetically-reversed string, all lowercase
			
			// want to start by ridding string of all non alpha chars
			string = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
			
			// use an alphabet char array
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			
			// start a stringbuilder
			StringBuilder sb = new StringBuilder();
			
			// now we want to reverse each character
			// we'll loop over the string
			for (int i=0; i<string.length(); i++) {
				// reverse character by checking index in alphabet and 
				// changing to character at inverse index
				// loop through char array 
				for (int j=0; j<alphabet.length; j++) {
					// when we find the char
					if (string.charAt(i)==alphabet[j]) {
						// then we want to get the reverse of that char
						// reverse = char at opposite index
						
						sb.append(alphabet[alphabet.length-1-j]);
					}
				}
				
			}
			
			// convert stringbuilder to string
			String str = sb.toString();
			
			// split string up to break into 5-char words
			String[] fivesarr = str.split("");
			
			// convert to arraylist
			ArrayList<String> fives = new ArrayList<>(Arrays.asList(fivesarr));
			
			
			// if we have more than 5 characters
						if (fives.size()>5) {
							// loop over string, adding space after every five-letter sequence
							for (int k=6; k<fives.size(); k++) {
								// if k is divisible by 5
								if (k%6==0) {
									// add a space to array
									fives.add(k-1, " ");
								}
								
							}
						}
			
			StringBuilder sb2 = new StringBuilder();
			
			for (String s: fives) {
				sb2.append(s);
			}
			
			String rstr = sb2.toString();
			
			return rstr;
			
			
			
			
			
			
			
		}

		public static String decode(String string) {
			// returns alphabetically-reversed string, all lowercase
			
			// want to start by ridding string of all non alpha chars
			string = string.replaceAll("\\s+","").toLowerCase();
			
			// use an alphabet char array
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			
			// start a stringbuilder
			StringBuilder sb = new StringBuilder();
			
			// now we want to reverse each character
			// we'll loop over the string
			for (int i=0; i<string.length(); i++) {
				// reverse character by checking index in alphabet and 
				// changing to character at inverse index
				// loop through char array 
				for (int j=0; j<alphabet.length; j++) {
					// if char is a number
					if (string.charAt(i)>48 && string.charAt(i)<57) {
						// add number to sb
						sb.append(string.charAt(i));
						// break loop
						j=alphabet.length;
					}
					// when we find the char
					else if (string.charAt(i)==alphabet[j]) {
						// then we want to get the reverse of that char
						// reverse = char at opposite index
						
						sb.append(alphabet[alphabet.length-1-j]);
						
						// break loop
						j=alphabet.length;
					}
				}
				
			}
			
			// convert sb to string
			String rstr = sb.toString();
			// and return it
			return rstr;
			
			
			
			
			
						
						
		}
	}
}
				
