package org.bostic.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	
    	
    	int a = 4;
    	System.out.println(a++);
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
		Integer io = input;
		String num = io.toString();
		String[] sa = num.split("");
		int[] ia = new int[num.length()];

		for(int i = 0; i < num.length();i++) {
			ia[i] = Integer.parseInt(sa[i]);
		}
		int exp = num.length();
		int amount = 0;
		for(int i : ia) {
			amount+=Math.pow(i, exp);
		}

//		System.out.println("amount : [" + amount + "] input: [" +input+"]");
		return amount == input;
	}

}
