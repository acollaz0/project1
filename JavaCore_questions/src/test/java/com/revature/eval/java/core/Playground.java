package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Playground {

	public static void main(String[] args) {
		
		String test = encode("OMG");
		System.out.println(test);
		


	}
	public static String encode(String string) {
		String cipher = "";
		Map<Character, Character> key = new HashMap<Character, Character>();
		
		for (int lower = 97; lower <= 122; lower++) {
			key.put((char)lower, (char)(122 - (lower-97)));
		}
		
		for (int lower = 65; lower <= 90; lower++) {
			key.put((char)lower, (char)(90 - (lower-65)));
		}
		
		for(int i = 0; i < string.length(); i++) {
			if(string.substring(i, i+1).matches("[a-zA-Z]")) {
				cipher = cipher + key.get(string.charAt(i));
				
			}
			
			else
				cipher = cipher + string.charAt(i);
			
		}
		
		return cipher;
	}
	
	

}



