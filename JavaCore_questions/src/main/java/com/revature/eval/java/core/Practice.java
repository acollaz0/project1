package com.revature.eval.java.core;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("Aasd Sasdf Hasdf"));
	}
	
	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		
		// define int variable to hold score
		int score = 0;
		
		// iterate over each character and add to score 
		for (int i=0; i<string.length(); i++) {
			if (string.charAt(i)=='A' ||
				string.charAt(i)=='E' ||
				string.charAt(i)=='I' ||
				string.charAt(i)=='O' ||
				string.charAt(i)=='U' ||
				string.charAt(i)=='L' ||
				string.charAt(i)=='N' ||
				string.charAt(i)=='R' ||
				string.charAt(i)=='S' ||
				string.charAt(i)=='T'
				) {
					score++;
				
			} else if (string.charAt(i)=='D' ||
				string.charAt(i)=='G') {
				
					score+=2;
				
			} else if (string.charAt(i)=='B' ||
				string.charAt(i)=='C' ||
				string.charAt(i)=='M' ||
				string.charAt(i)=='P') {
					
					score+=3;
				
			} else if (string.charAt(i)=='F' ||
				string.charAt(i)=='H' ||
				string.charAt(i)=='V' ||
				string.charAt(i)=='W' ||
				string.charAt(i)=='Y') {
					
					score+=4;
					
			} else if (string.charAt(i)=='K') {
				
					score+=5;
				
			} else if (string.charAt(i)=='J' ||
					string.charAt(i)=='X') {
				
					score+=8;
			
			} else if (string.charAt(i)=='Q' ||
				string.charAt(i)=='Z') {
			
					score+=10;
		
			}
		}
		
		return 0;
	}
}
