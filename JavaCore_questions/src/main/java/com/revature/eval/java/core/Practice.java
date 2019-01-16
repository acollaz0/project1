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
		
		RotationalCipher rc = new RotationalCipher(2);
		System.out.println(rc.rotate("abc"));
		
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
			
			// ok, now we have an alphabet array
			// what do we want to do now
			
			// well, we've got a string
			// let's add the key to each char in the string
			
			// let's iterate over the string
			// we'll add changed letters to a string builder
			// let's create the sb first
			StringBuilder sb = new StringBuilder();
			// now we'll loop over the input string and add rotated letters 
			// to the sb
			
			
			for (int i=0; i<string.length(); i++) {
				// get the char from the input string
				// and add its rotated value to the sb
				char c = string.charAt(i);
				// get index of char in alphabet
				// iterate over alphabet 
				for (int j=0; j<alphabet.length; j++) {
					// if element at index is c
					if (alphabet[j]==c) {
						// rotate char
						c = alphabet[j+key];
						// add rotated char to sb
						sb.append(c);
					}
				}
			}
			
			
			return sb.toString();
		}

	}
}
