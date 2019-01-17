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
		
		System.out.println(calculateNthPrime(10001));
		
		
	}
	
	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public static int calculateNthPrime(int i) {

		// we have a number, i
		
		// we want to add to a list of numbers until the list has a length of i
		
		// we only want to add prime numbers to the list
		
		// a number is a prime number if it is only divisible by itself and 1
		
		// we'll only check to see if it's divisible by numbers >= 2 and <= itself/2
		// because a number can't be divisible by more than half of itself, other than by 1
		// because dividing by more than half would give you a number less than 2
		// so either 1 or 0
		// we know every number is divisible by 1 and can't be divided by 0
		
		// if input is < 1, throw exception
		if (i<1) {
			throw new IllegalArgumentException();
		}
		// if input is 1 or 2, we'll just return the output (2 or 3)
		if (i==1) {
			return 2;
		} else if (i==2) {
			return 3;
		} else if (i==3) {
			return 5;
		} else if (i>3) {
			// create a list of primes
			ArrayList<Integer> primes = new ArrayList<Integer>();
			// iterate through all numbers until you've got i prime numbers
			for (int holder = 6; holder<1000000; holder++) {
				// create int to track num of factors
				int factors = 0;
				// loop through all numbers until we have i primes
				for (int pointer = 2; pointer<holder/2; pointer++) {
					// if holder is divisible by pointer
					if (holder%pointer==0) {
						// then add one to factors 
						factors++;
					} 
					
				}
				// after checking for all factors of number
				// if number has no factors, it's prime
				if (factors==0) {
					primes.add(holder);
				}
				// if size of primes == i
				if (primes.size()==i-3) {
					// return last element in i
					int returnedprime = primes.get(primes.size()-1);
					return returnedprime;
				}
			}
			
		}
		return -1;
		
	}
}
				
