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
		System.out.println(isValidIsbn("3-598-21507-X"));
		System.out.println(30+45+72+56+12+5+20+0+14+10);
		// 30+45+72+56+12+5+20+0+14+10
		
	}
	
	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isValidIsbn(String string) {
		
		// we have a string with dashes
		
		// lets get rid of the dashes
		string = string.replaceAll("-", "");
		
		// make int sum 
		int sum = 0;
		
		// now let's loop backwards through string
		for (int i=string.length()-1; i>=0; i--) {
			// if the char is neither a number nor an 'X'
			if ((string.charAt(i)<48 || string.charAt(i)>57) && string.charAt(i) != 'X') {
				return false;
				// else if it's a number
			} else if ((string.charAt(i)>=48 && string.charAt(i)<=57) || string.charAt(i)=='X'){
				// if char is 'X'
				if (string.charAt(i)=='X') {
					// add ten to the sum
					sum+=10;
				} else {
				// add appropriate product to sum
				// convert char to int
				int charint = string.charAt(i) - '0';

				// multiply int by appropriate multiplier
				int product = charint*(string.length()-i);
				
				// add product to sum
				sum+=product;
				}
			}
			
		}
		
		System.out.println(sum);
		return ((sum%11)==0);
		
	}
}
				
