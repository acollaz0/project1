package stringfun;

public class Sandbox {

	public static void main(String[] args) {
		
		// String is an object NOT A PRIMITIVE!!!!!!!
		

		
		// whenever you call == with primitives it checks the value
		System.out.println(4==4);

		Integer i = 1000;
		Integer i2 = 1000;
		// when you use == with objects it checks for the memory location
		System.out.println(i==i2);
		
		
		// Java has a string pool. Strings of the same value will have 
		// the same memory address
		String hello = "Hello";
		String hello2 = "Hello";
		
		// They are the same object!!!!
		// the String pool is a terrific to save memory
		// String is a final class and therfore immutable 
		System.out.println(hello == hello2);
		
		// there is nothing I can do to change that object
		String hola = "hola";
		
		// reassigning the variable to a new string
		hola = hola + "hello";
		
		// StringBuilder is essentially a mutable version of string
		// And does not use the stringpool to save memory
		StringBuilder sb = new StringBuilder("Hello Everyone");
		
		// The object itself has been reversed
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		//StringBufffer is StringBuilder except it is thread safe
		StringBuffer sbuff = new StringBuffer("Welcome everyone");
		
		
	}

}
