package com.revature.eval.java.core;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.Temporal;
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
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public static int getSumOfMultiples(int i, int[] set) {
		
		// so for 20, [3, 5]
		// we've got i, x and y
		
		// we first want to capture every time x and y go into i
		// so x: 3, 6, 9, 12, 15, 18
		// y: 5, 10, 15
		// then we just add them up
		
		// we'll loop through twice
		
		// first time using x
		int x = set[0];
		
		int sum = 0;
		
		for (int j=x; j<i; j+=j) {
			if (j<i) {
				// add j to sum
				sum+=j;	
			}
		}
		
		// then using y
		int y = set[1];
		
		for (int k=y; k<i; k+=k) {
			if (k<i) {
				// add j to sum
				sum+=k;	
			}
		}
		
		return sum;
	}

}
				
