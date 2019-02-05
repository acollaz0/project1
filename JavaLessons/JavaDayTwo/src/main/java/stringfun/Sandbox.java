package stringfun;

public class Sandbox {

	public static void main(String[] args) {
		
		//String is an object not a primitive
		//Java has a string pool. Strings of the same value will have the same memory address
		String hello = "Hello";
		
		//if you call == with primitives it check the value
		System.out.println(4==4);

		Integer i1 = 1000;
		Integer i2 = 1000;
		//when you use == with objects it checks for the memory location
		System.out.println(i1 == i2);
		
		hello = "Hello";
		String hello2 = new String("Hello");
		//String is a final class
		System.out.println(hello == hello2);
		//object created, nothing we can do to change this object
		//can reassign variable and wait for gc
		String hola = "hola";
		
		//StringBuilder is a mutable version of string
		//does not use string pool to save memory
		StringBuilder sb = new StringBuilder("Forward");

		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		
		StringBuilder a =new  StringBuilder("a");
		for(int i=0;i<1000;i++) {
			a.append("a");
		}
		//StringBuffer is like StringBuilder but it is safe for threading
		StringBuffer sbuff = new StringBuffer("Welcome to thread safety");
	}

}
