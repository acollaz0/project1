package stringfun;

public class Sandbox {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		//Using == on primitives checks the value
		System.out.println(4==4);
		
		Integer k = 1000;
		Integer j = 1000;
		System.out.println(k==j); //gives false, because with objects check if memory location is the same
		
		//String is an object, not a primitive

		String hi = "hello"; //Notice I didn't use the "new" keyword
		//Java has a string pool, because strings of the same value will have the same memory address
		String hi2 = "hello";
		
		System.out.println(hi==hi2); //Strings are handled different, because identical strings 
		//have the same address
		
		//The string pool is a great way to save memory. 
		//This means String is a "final class", and therefore immutable.
		//Can't override String methods, can't inherit from String, can't change its value once created
		
		String hola = "hola"; // Cant' change this object
		hola += "lad"; //Just reassigned the hola var to a new string. 
		//Original "hola" object will eventually be garbage collected
		
		//StringBuilder is essentially a mutable version of String, and doesn't
		//use the string pool to save memory.
		StringBuilder sb = new StringBuilder("Hey there");
		
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb); //The object itself has been reversed
		
		//StringBuilder is much faster than String usually. Especially when editing 
		//a single string many times
		StringBuilder a = new StringBuilder("a");
		
		for (int i = 0; i < 1000; i++) {
			a.append("a");
		}
		
		//StringBuffer is StringBuilder, but it's "thread safe", whatever that means.
		//If running multiple ops on a string and want it to happen in a certain order, use sbuff.
		StringBuffer sbuff = new StringBuffer("Wilkommen");

	}

}
