package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("___________ \n Practice \n"
				+ "___________"));
		
		System.out.println(toPigLatin("quick fast run"));
		
	}
	
	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		// convert input to Integer object
		Integer inp = input;
		// convert Integer to string
		String str = inp.toString();
		
		// create int to track sum
		int sum = 0;
		
		// loop through each number in str
		// add exp value to sum
		for (int i=0; i<str.length(); i++) {
			sum+=Math.pow((int)str.charAt(i), str.length());
		}
		
		// return whether or not sum equals input
		return sum==input;
	}
	
	public static String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		
		// declare an arraylist of strings to return
		ArrayList<String> piglatinwords = new ArrayList<String>();
		
		// declare an array of strings, words
		String [] words;
		
		// get each word from input string by splitting at whitespaces
		words = string.split(" ");
		
		// define array of vowels
		String [] vowels = {"a", "e", "i", "o", "u"};
		
		// for each word in input string
		for (String word: words) {
			
			// find first vowel
			for (int i=0; i<word.length(); i++) {
				
				// if the letter is a vowel
				if (Arrays.asList(vowels).contains((word.charAt(i)+"").toLowerCase())) {
					
					// and if it's a u
					if (word.charAt(i)=='u' && word.charAt(i-1)=='q') {
						
						// start substring at i+1
						String str1 = word.substring(i+1, word.length());
						
						// add second component to end
						String str2 = word.substring(0, i+1) + "ay";
						
						// combine str's for pig latin word
						String pl = str1 + str2;
						
						// add to arraylist of pig latin words
						piglatinwords.add(pl);
						
						
					} else {
						
						// start substring at i
						String str1 = word.substring(i, word.length());
						
						// add second component to end
						String str2 = word.substring(0, i) + "ay";
						
						// combine str's for pig latin word
						String pl = str1 + str2;
						
						// add to arraylist of pig latin words
						piglatinwords.add(pl);
						
					}
				}
			}
			
		}
		
		// now that we have an arraylist of pig latinized words
		// let's return them in a nice form
		// so let's loop through the array list
		// and add each word in the array list to a stringbuilder
		
		// first let's create the stringbuilder
		StringBuilder sb = new StringBuilder();
		
		// then let's loop through the array list and add each word to the sb
		for (String plw: piglatinwords) {
			// add a space first to pass tests
			sb.append(" ");
			
			// then add the word
			sb.append(plw);
		}
		
		// now we want to return the sb as a string, without the first space
		return sb.toString().substring(1);
		
		
		
		
		
/*
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
						arr[i].charAt(j) == 'U' ||
						arr[i].charAt(j) == 'a' ||
						arr[i].charAt(j) == 'e' ||
						arr[i].charAt(j) == 'i' ||
						arr[i].charAt(j) == 'o' ||
						arr[i].charAt(j) == 'u') {
					// pig latin-ize string
					
					// start by creating substring of string starting at vowel
					String comp1 = arr[i].substring(j, arr[i].length());
					
					// test
					System.out.println(comp1 + " " + i);
					
					// add first component to plword
					String plword = comp1;
					// create and add second component
					String comp2 = arr[i].substring(0, j);
					
					// test
					System.out.println(comp2);
					
					plword+=(comp2+"ay");
					// add plword to array
					plwords.add(plword);
					
					// turn plwords into string
					// create new string builder
					StringBuilder plfinal = new StringBuilder();
					
					// add each plword to new string builder
					for (String plword : plwords) {
						//test
						System.out.println(plword);
						
						plfinal.append(" ");
					    plfinal.append(plword);
					}
					
					// return final string builder as string, removing first space
					return plfinal.toString().substring(1);
				}
			}
		}
		
//		// turn plwords into string
//		// create new string builder
//		StringBuilder plfinal = new StringBuilder();
//		
//		// add each plword to new string builder
//		for (String plword : plwords) {
//			//test
//			System.out.println(plword);
//			
//			plfinal.append(" ");
//		    plfinal.append(plword);
//		}
//		
//		// return final string builder as string, removing first space
//		return plfinal.toString().substring(1);
		
	
}

*/
	
	
	}
}
