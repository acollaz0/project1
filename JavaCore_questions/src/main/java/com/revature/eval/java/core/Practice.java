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
		
		RotationalCipher rc = new RotationalCipher(6);
		System.out.println(rc.rotate("Testing 1 2 3 testing"));
		
		
	}
	
	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}
					

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			
			// ok, we want to take the input string
			// and 'shift' each character to the 'right'
			// by the key
			
			// so we need to iterate over each char
			// and set its value to 'its value + key'
			
			// its value will be grabbed from an array of the alphabet
			
			// so let's start by creating an alphabet array
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();	
			// and an uppercase alphabet array
			char[] capalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
			
			// ok, now we have an alphabet array
			// what do we want to do now
			
			// well, we've got a string
			// let's add the key to each char in the string
			
			// let's iterate over the string
			// we'll add rotated letters to a string builder
			// let's create the sb first
			StringBuilder sb = new StringBuilder();
			
			// now we'll loop over the input string and add rotated letters 
			// to the sb

			for (int i=0; i<string.length(); i++) {
				// get the char from the input string
				// and add its rotated value to the sb

				// if the char is non-alphabetical
				if (string.charAt(i) > 123 || string.charAt(i) < 65) {
					// add it without rotating it
					sb.append(string.charAt(i));
					// else if the char is a capitalized letter
				} else if (string.charAt(i) >= 65 && string.charAt(i) <= 90){
					// get the letter
					char c = string.charAt(i);
					// get index of char in capalphabet
					// iterate over capalphabet 
					for (int j=0; j<capalphabet.length; j++) {
						// if element at index is c
						if (capalphabet[j]==c) {
							// if j + key is greater than or equal to capalphabet.length
							// then we need to subtract capalphabet's length from it
							// to start again at 0, ('a')
							if (j+key>=capalphabet.length) {
								// subtract alphabet length from j
								j-=capalphabet.length;
							}
							// rotate char
							c = capalphabet[j+key];
							// add rotated char to sb
							sb.append(c);
							// end loop
							j = capalphabet.length;
						}
					}
					// else if it's a lowercase letter
				} else if (string.charAt(i) >= 97 && string.charAt(i) <= 122) {
					// get the letter
					char c2 = string.charAt(i);
					// get index of char in alphabet
					// iterate over alphabet 
					for (int k=0; k<alphabet.length; k++) {
						// if element at index is c
						if (alphabet[k]==c2) {
							// if j + key is greater than or equal to alphabet.length
							// then we need to subtract alphabet's length from it
							// to start again at 0, ('a')
							if (k+key>=alphabet.length) {
								// subtract alphabet length from j
								k-=alphabet.length;
							}
							// rotate char
							c2 = alphabet[k+key];
							// add rotated char to sb
							sb.append(c2);
							// end loop
							k = alphabet.length;
						}
					}
				}
			}
			// create string to return
			String returnstr = sb.toString();
			System.out.println(returnstr);
			return returnstr;
		}
	}
}
				
