package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("___________ \n Practice \n"
				+ "___________"));
		
		System.out.println();
	}
	
	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration

		// create array to hold pig-latinized words
		ArrayList<String> plwords = new ArrayList<String>();
		
		// create array to hold words of input string
		String [] arr = string.split(" ");
		
		// iterate over each word in arr
		for (int i=0; i<arr.length; i++) {
			// loop through each letter in word
			for (int j=0; j<arr[i].length(); j++) {
				// if the letter is a vowel
				if (arr[i].charAt(j) == 'A' ||
						arr[i].charAt(j) == 'E' ||
						arr[i].charAt(j) == 'I' ||
						arr[i].charAt(j) == 'O' ||
						arr[i].charAt(j) == 'U') {
					// pig latinize string
					String comp1 = arr[i].substring(j, arr[i].length()-1);
					// add first component to plword
					String plword = comp1;
					// create and add second component
					String comp2 = arr[i].substring(0, j-1);
					plword+=(comp2+"ay");
					// add plword to array
					plwords.add(plword);
				}
			}
		}
		
		// turn plwords into string
		// create new string builder
		StringBuilder plfinal = new StringBuilder();
		// add each plword to new string builder
		for (String plword : plwords) {
			plfinal.append(" ");
		    plfinal.append(plword);
		}
		
		// return final string builder as string, removing first space
		return plfinal.toString().substring(1);
		
	}
	
	
	
}
