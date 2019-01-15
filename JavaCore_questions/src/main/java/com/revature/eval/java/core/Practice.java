package com.revature.eval.java.core;

import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		System.out.println(("___________ \n Practice \n"
				+ "___________"));
		
		System.out.println(wordCount("olly olly in come free"));
	}
	
	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
//	public static Map<String, Integer> wordCount(String string) {
//		// TODO Write an implementation for this method declaration
//		
//        
//        // create new hashmap to hold word-count pairs
//        Map words = new HashMap();
//        
//        // split input string into array
//        String[] arr = string.split("[-\\s+]+");
//        
//        // loop through input string
//        for (int i=0; i<arr.length; i++) {
//        	// create counter variable to track num of occurrences of word in arr
//        	int count = 0;
//        	// check first word for num of occurrences
//        	for (int j=0; j<arr.length; j++) {
//        		if (arr[i].equals(arr[j])) {
//        			count++;
//        		}
//        	}
//        	// if map doesn't contain word
//        	if (!words.containsKey(arr[i])) {
//	        	// add new word,count pair to map
//	        	words.put(arr[i], count);
//        	}
//        }
//        // return map of <word,count> pairs
//		return words;
//	}
	
	
	
}
