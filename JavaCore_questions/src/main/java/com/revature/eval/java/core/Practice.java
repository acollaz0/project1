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
		
		System.out.println();
		
	}
	
	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration

		// create array list to hold prime factors
		List<Long> primes = new ArrayList<Long>();
		
		// loop through all numbers (gt 2) up to half of input l
		for (long i = 2; i<=l; i++) {
			// if the input is divisible by i
			while (l%i==0) {
				// add i to the list
				primes.add(i);
				// divide l by found factor
				l /= i;
			}
		}
		
		return primes;
	}
}
