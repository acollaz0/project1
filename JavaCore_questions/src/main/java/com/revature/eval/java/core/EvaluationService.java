package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// split phrase into separate words
		String[] split = phrase.split("[-\\s]");
		
		// create acronym string variable
		String acronym = new String();
				
		// extract first char of each word into variable
		for (int i=0; i<split.length; i++) {
			acronym = acronym + split[i].charAt(0);
		}			
		
		// return acronym
		return acronym.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}


		public boolean isEquilateral() {			
			// extract all side lengths into variables
			double sideOne = getSideOne();
			double sideTwo = getSideTwo();
			double sideThree = getSideThree();
			
			// if all side lengths are equal, return true
			if (sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			}
			
			// else return false
			return false;
		}

		public boolean isIsosceles() {			
			// extract all side lengths into variables
			double sideOne = getSideOne();
			double sideTwo = getSideTwo();
			double sideThree = getSideThree();
						
			// if at least two sides are equal, return true
			if (isEquilateral() || (sideTwo == sideThree) || (sideTwo == sideOne) || 
					(sideOne == sideThree)) {
				return true;
			}
						
			// else return false
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			
			// if not isosceles of equilateral, then return true
			if (!isEquilateral() && !isIsosceles()) {
				return true;
			}
			
			// else return false
			return false;
		}

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
		
		// define int variable to hold score
		int score = 0;
		
		// convert string to uppercase for char comparison
		string = string.toUpperCase();
		
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
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		
				String num = string.replaceAll("[()\\s-]+", "");
				String numNoDots = num.replaceAll("\\.", "");
				
				if (numNoDots.matches("^[0-9]+$") && numNoDots.length()==11 && numNoDots.charAt(0)=='1') {
					String cleanNum = numNoDots.substring(1, numNoDots.length());
					return cleanNum;
				} else if (numNoDots.length()==10 && numNoDots.matches("^[0-9]+$")) {
					return numNoDots;
				} else {
					throw new IllegalArgumentException("Illegal argument");
				}
	}

//	/**
//	 * 6. Given a phrase, count the occurrences of each word in that phrase.
//	 * 
//	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
//	 * free: 1
//	 * 
//	 * @param string
//	 * @return
//	 */
	public static Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		
        
        // create new hashmap to hold word-count pairs
        Map words = new HashMap();
        
        // split input string into array
        String[] arr = string.split("[-\\s+,]+");
        
        // loop through input string
        for (int i=0; i<arr.length; i++) {
        	// create counter variable to track num of occurrences of word in arr
        	int count = 0;
        	// check first word for num of occurrences
        	for (int j=0; j<arr.length; j++) {
        		if (arr[i].equals(arr[j])) {
        			count++;
        		}
        	}
        	// if map doesn't contain word
        	if (!words.containsKey(arr[i])) {
	        	// add new word,count pair to map
	        	words.put(arr[i], count);
        	}
        }
        // return map of <word,count> pairs
		return words;
	}

	//
	// DON'T WORRY ABOUT THIS ONE YET
	//
	
	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
//	static class BinarySearch<T> implements Comparable<T> {
//		private List<T> sortedList;
//
//		public int indexOf(T t) {
//			// TODO Write an implementation for this method declaration
//			return 0;
//		}
//
//		public BinarySearch(List<T> sortedList) {
//			super();
//			this.sortedList = sortedList;
//		}
//
//		public List<T> getSortedList() {
//			return sortedList;
//		}
//
//		public void setSortedList(List<T> sortedList) {
//			this.sortedList = sortedList;
//		}
//
//		@Override
//		public int compareTo(T arg0) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//
//	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		
		// declare an arraylist of strings to return
		ArrayList<String> piglatinwords = new ArrayList<String>();
		
		// declare an array of strings, words
		String [] words;
		
		// get each word from input string by splitting at whitespaces
		words = string.split(" ");
		
		//
		System.out.println(words.length);
		
		// define array of vowels
		String [] vowels = {"a", "e", "i", "o", "u"};
		
		// for each word in input string
		for (String word: words) {
			
			// find first vowel
			for (int i=0; i<word.length(); i++) {
				
				// if the letter is a vowel
				if (Arrays.asList(vowels).contains((word.charAt(i)+"").toLowerCase())) {
					
					// and if it's a u
					if (word.charAt(i)=='u' && word.charAt(i-1)=='q') {
						
						// start substring at i+1
						String str1 = word.substring(i+1, word.length());
						
						// add second component to end
						String str2 = word.substring(0, i+1) + "ay";
						
						// combine str's for pig latin word
						String pl = str1 + str2;
						
						// add to arraylist of pig latin words
						piglatinwords.add(pl);
						
						// end loop
						i = word.length();
						
						
					} else {
						
						// start substring at i
						String str1 = word.substring(i, word.length());
						
						// add second component to end
						String str2 = word.substring(0, i) + "ay";
						
						// combine str's for pig latin word
						String pl = str1 + str2;
						
						// add to arraylist of pig latin words
						piglatinwords.add(pl);
						
						// end loop
						i = word.length();
						
					}
				}
			}
			
		}
		
		// now that we have an arraylist of pig latinized words
		// let's return them in a nice form
		// so let's loop through the array list
		// and add each word in the array list to a stringbuilder
		
		// first let's create the stringbuilder
		StringBuilder sb = new StringBuilder();
		
		// then let's loop through the array list and add each word to the sb
		for (String plw: piglatinwords) {
			// add a space first to pass tests
			sb.append(" ");
			
			// then add the word
			sb.append(plw);
		}
		
		// now we want to return the sb as a string, without the first space
		return sb.toString().substring(1);
				
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
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		// convert input to Integer object
		Integer inp = input;
		// convert Integer to string
		String str = inp.toString();

		
		// create int to track sum
		int sum = 0;
		
		// loop through each number in str
		for (int i=0; i<str.length(); i++) {
			// add exp value to sum
			// subtract '0' from char to convert to int
			sum+=Math.pow(str.charAt(i)-'0', str.length());
		}
		
		// return whether or not sum equals input
		return sum==input;
	
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
			char[] upperalphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
			
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
				if (string.charAt(i) > 'z' || string.charAt(i) < 'A') {
					// add it without rotating it
					sb.append(string.charAt(i));
					// else if the char is a capitalized letter
				} else if (string.charAt(i) >= 65 && string.charAt(i) <= 90){
					// get the letter
					char c = string.charAt(i);
					// get index of char in upperalphabet
					// iterate over upperalphabet 
					for (int j=0; j<upperalphabet.length; j++) {
						// if element at index is c
						if (upperalphabet[j]==c) {
							// if j + key is greater than or equal to upperalphabet.length
							// then we need to subtract upperalphabet's length from it
							// to start again at 0, ('a')
							if (j+key>=upperalphabet.length) {
								// subtract alphabet length from j
								j-=upperalphabet.length;
							}
							// rotate char
							c = upperalphabet[j+key];
							// add rotated char to sb
							sb.append(c);
							// end loop
							j = upperalphabet.length;
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
			return returnstr;
		}
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

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {

			// returns alphabetically-reversed string, all lowercase
			
			// want to start by ridding string of all non alpha chars
			string = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
			
			// use an alphabet char array
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			
			// start a stringbuilder
			StringBuilder sb = new StringBuilder();
			
			// now we want to reverse each character
			// we'll loop over the string
			for (int i=0; i<string.length(); i++) {
				// reverse character by checking index in alphabet and 
				// changing to character at inverse index
				// loop through char array 
				for (int j=0; j<alphabet.length; j++) {
					// if char is a number
					if (string.charAt(i)>48 && string.charAt(i)<57) {
						// add number to sb
						sb.append(string.charAt(i));
						// break loop
						j=alphabet.length;
					}
					// when we find the char
					else if (string.charAt(i)==alphabet[j]) {
						// then we want to get the reverse of that char
						// reverse = char at opposite index
						
						sb.append(alphabet[alphabet.length-1-j]);
						
						// break loop
						j=alphabet.length;
					}
				}
				
			}
			
			// convert stringbuilder to string
			String str = sb.toString();
			
			// split string up to break into 5-char words
			String[] fivesarr = str.split("");
			
			// convert to arraylist
			ArrayList<String> fives = new ArrayList<>(Arrays.asList(fivesarr));
			
			// if we have more than 5 characters
			if (fives.size()>5) {
				// loop over string, adding space after every five-letter sequence (every 6th char)
				for (int k=6; k<fives.size(); k++) {
					// if k is divisible by 6
					if (k%6==0) {
						// add a space to array
						fives.add(k-1, " ");
					}
				}
			}
			
			// create new string builder
			StringBuilder sb2 = new StringBuilder();
			
			// loop through array list to build sb
			for (String s: fives) {
				sb2.append(s);
			}
			
			// convert sb to string
			String rstr = sb2.toString();
			
			// return string
			return rstr;
			
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// returns alphabetically-reversed string, all lowercase
			
			// want to start by ridding string of all non alpha chars
			string = string.replaceAll("\\s+","").toLowerCase();
			
			// use an alphabet char array
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			
			// start a stringbuilder
			StringBuilder sb = new StringBuilder();
			
			// now we want to reverse each character
			// we'll loop over the string
			for (int i=0; i<string.length(); i++) {
				// reverse character by checking index in alphabet and 
				// changing to character at inverse index
				// loop through char array 
				for (int j=0; j<alphabet.length; j++) {
					// if char is a number
					if (string.charAt(i)>48 && string.charAt(i)<57) {
						// add number to sb
						sb.append(string.charAt(i));
						// break loop
						j=alphabet.length;
					}
					// when we find the char
					else if (string.charAt(i)==alphabet[j]) {
						// then we want to get the reverse of that char
						// reverse = char at opposite index
						
						sb.append(alphabet[alphabet.length-1-j]);
						
						// break loop
						j=alphabet.length;
					}
				}
				
			}
			
			// convert sb to string
			String rstr = sb.toString();
			// and return it
			return rstr;			
		}
	}
	
	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
public static boolean isValidIsbn(String string) {
		
		// we have a string with dashes
		
		// lets get rid of the dashes
		string = string.replaceAll("-", "");
		
		// make int sum 
		int sum = 0;
		
		// now let's loop backwards through string
		for (int i=string.length()-1; i>=0; i--) {
			// if the char is neither a number nor an 'X'
			if ((string.charAt(i)<48 || string.charAt(i)>57) && string.charAt(i) != 'X') {
				return false;
				// else if it's a number
			} else if ((string.charAt(i)>=48 && string.charAt(i)<=57) || string.charAt(i)=='X'){
				// if char is 'X'
				if (string.charAt(i)=='X') {
					// add ten to the sum
					sum+=10;
				} else {
				// add appropriate product to sum
				// convert char to int
				int charint = string.charAt(i) - '0';

				// multiply int by appropriate multiplier
				int product = charint*(string.length()-i);
				
				// add product to sum
				sum+=product;
				}
			}
			
		}
		
		System.out.println(sum);
		return ((sum%11)==0);
		
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// we have a string 
		
		// we want to check to see if it contains every letter of the alphabet
		
		// we'll need to check the string's chars with the alphabet
		
		// so we'll create an alphabet array
		char[] alphabet = ("abcdefghijklmnopqrstuvwxyz").toCharArray();
		
		// then we'll create an arraylist of characters
		ArrayList<Character> alphabetlist = new ArrayList<Character>();
		
		// add letters to alphabetlist
		for (int i=0; i<alphabet.length; i++) {
			alphabetlist.add(alphabet[i]);
		}
		
		// now we'll loop through the string to see if it contains every letter
		// loop through each char in string
		for (int j=0; j<string.length(); j++) {
			// loop through each char in alphabetlist
			for (int k=0; k<alphabetlist.size(); k++) {
				// if char is in alphabetlist
				if (string.charAt(j)==alphabetlist.get(k)) {
					// remove char from alphabet list
					alphabetlist.remove(k);
				}
			}
			
		}
		
		// after checking each letter
		// if we haven't removed every letter from alphabetlist
		if (alphabetlist.size()>0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// we're given a birthday
		
		// we want to return that birthday + 10^9 sec
		
		// given LocalDate
		
		// returning LocalDateTime
		
		// but if given localdatetime
		if (given instanceof LocalDateTime) {
			return ((LocalDateTime) given).plusSeconds((int)Math.pow(10,9));
		}
		
		// how many days in 10^9 seconds?
		// 60 sec in a min, 60 min in an hour, 24 hours in a day
		double daysgiga = (Math.pow(10, 9))/60/60/24;
		// get remaining seconds
		int remainingsec = (int) ((Math.pow(10, 9))%(60*60*24));
		
		// now that we have gigadays, we want to add it to the given birthday
		// using plusDays method
		
		// first we need to create LocalDate obj out of given
		
		// parse given to create LocalDate
		String[] bd = given.toString().split("-");
		// get year
		int year = Integer.parseInt(bd[0]);
		// month
		int month = Integer.parseInt(bd[1]);
		// day
		int day = Integer.parseInt(bd[2]);
		// create localdate
		LocalDate ld = LocalDate.of(year, month, day);
		
		// add days to get gigasecond localdate
		LocalDate gigald = ld.plusDays((long)(Math.pow(10, 9))/(60*60*24));
		
		// now create new localdate string out of gigald
		// parse given to create LocalDate
		System.out.println(gigald);
		String[] gbd = gigald.toString().split("-");
		// get year
		int gyear = Integer.parseInt(gbd[0]);
		// month
		int gmonth = Integer.parseInt(gbd[1]);
		// day
		int gday = Integer.parseInt(gbd[2]);
		// create localdate
		LocalDate gld = LocalDate.of(gyear, gmonth, gday);
		
		// now we want to create a localdatetime obj w/ remainingsec
		// must first convert remainingsec to hours, minutes and sec
		int hours = remainingsec/3600;
		int minutes = (remainingsec%3600)/60;
		int sec = ((remainingsec%3600)%60);
		
		LocalDateTime ldt = LocalDateTime.of(gyear, gmonth, gday, hours, minutes, sec);
		
		return ldt;
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
	public int getSumOfMultiples(int i, int[] set) {
		
		
		if (set.length==1) {
			
			int sum = 0;
			
			for (int j=set[0]; j<i; j+=set[0]) {
				if (j<i) {
					// add j to sum
					sum+=j;	
				}
			}
			
			return sum;
			
		} else if (set.length==2) {
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
			
			for (int j=x; j<i; j+=x) {
				if (j<i) {
					// add j to sum
					sum+=j;	
				}
			}
			
			// then using y
			int y = set[1];
			
			for (int k=y; k<i; k+=y) {
				if (k<i && (k%x!=0)) {
					// add j to sum
					sum+=k;	
				}
			}
			
			return sum;
		} else if (set.length==3) {
			
			// we'll loop through thrice
			
			// first time using x
			int x = set[0];
			
			int sum = 0;
			
			for (int j=x; j<i; j+=x) {
				if (j<i) {
					// add j to sum
					sum+=j;	
				}
			}
			
			// then using y
			int y = set[1];
			
			for (int k=y; k<i; k+=y) {
				if (k<i && (k%x!=0)) {
					// add j to sum
					sum+=k;	
				}
			}
			
			// then using z
			int z = set[2];
			
			for (int l=z; l<i; l+=z) {
				if (l<i && (l%x!=0) && (l%y!=0)) {
					// add j to sum
					sum+=l;	
				}
			}
			
			return sum;
		}
		
		return 0;

	}

	//
	// DON'T WORRY ABOUT THIS ONE YET
	//
	
	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
