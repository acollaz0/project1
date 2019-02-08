package stringfun;

public class Sandbox {

	public static void main(String[] args) {
		
		//String is an object NOT A PRIMITIVE!!!!!!
		
		// Java has a string pool. Strings of the same value will have
		// the same memory address
		
		//whenever you call == with primitives it checks the value
		System.out.println(4==4);
		
		Integer i = 1000;
		Integer i2 = 1000;
		// when you use == with objects it checks for the memory location
		System.out.println(i==i2);
		
		String hello = "hello";
		String hello2 = "hello";
		
		//they are the same object
		//the String pool is a terrific way to save memory
		//String is a final class and therefore immutable
		System.out.println(hello==hello2);
		
		//there is nothing i can do to change that object
		String hola = "hola";
		
		//reassigning the variable to a new String
		hola = "hola2";
		
		//StringBuilder is essentially a mutable version of string
		//and does not use the stringpool to save memory
		StringBuilder sb = new StringBuilder("Hello Everyone");
		
		//the object itself has been reversed
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		
		StringBuilder a = new StringBuilder("a");
		
		for (int j = 0; j < 1000; j++) {
			a.append("a");
		}
		
		//StringBuffer is StringBuilder except it is thread safe
		StringBuffer sbuff = new StringBuffer("Welcome Everyone");
		

	}

}
