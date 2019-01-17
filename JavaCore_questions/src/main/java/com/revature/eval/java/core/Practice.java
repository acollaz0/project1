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
		System.out.println(isPangram("abcdefghijklmnopqrstuvwxyz"));
		// 30+45+72+56+12+5+20+0+14+10
		
	}
	
	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isPangram(String string) {


		// we have a string 
		
		// we want to check to see if it contains every letter of the alphabet
		
		// we'll need to check the string's chars with the alphabet
		
		// so we'll create an alphabet array
		char[] alphabet = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
		
		// then we'll create an arraylist of characters
		ArrayList<Character> alphabetlist = new ArrayList<Character>();
		
		// add letters to alphabetlist
		for (int i=0; i<alphabet.length; i++) {
			alphabetlist.add(alphabet[i]);
		}
		
		// now we'll loop through the string to see if it contains every letter
		// loop through each char in string
		for (int j=0; j<string.length(); j++) {
			// loop through each char in alphabetlist
			for (int k=0; k<alphabetlist.size(); k++) {
				// if char is in alphabetlist
				if (string.charAt(j)==alphabetlist.get(k)) {
					// remove char from alphabet list
					alphabetlist.remove(k);
				}
			}
			
		}
		
		// after checking each letter
		// if we haven't removed every letter from alphabetlist
		if (alphabetlist.size()>0) {
			return false;
		} else {
			return true;
		}
		
	}

}
				
