package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("___________ \n Practice \n"
				+ "___________"));
		
		System.out.println(isArmstrongNumber(5));
		
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
	public static boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		// convert input to Integer object
		Integer inp = input;
		// convert Integer to string
		String str = inp.toString();

		
		// create int to track sum
		int sum = 0;
		
		// loop through each number in str
		for (int i=0; i<str.length(); i++) {
			// add exp value to sum
			// subtract '0' from char to convert to int
			sum+=Math.pow(str.charAt(i)-'0', str.length());
		}
		
		// return whether or not sum equals input
		return sum==input;
	
	}
}
