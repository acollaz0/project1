package com.revature.eval.java.core;


public class Playground {

	public static void main(String[] args) {
		
		
		System.out.print(isArmstrongNumber(9474));

	}
	
	public static boolean isArmstrongNumber(int input) {
		String len = Integer.toString(input);
		int power = len.length();
		int armstrong = 0;
		for(int i = 0; i < len.length(); i++) {
			armstrong = armstrong + (int)Math.pow(Double.parseDouble(len.substring(i, i+1)), power);
		}
		
		return (armstrong == input);
	}

}
