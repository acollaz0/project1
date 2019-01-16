package exceptionfun;

import java.io.FileNotFoundException;

public class MathFun {
	
	//exceptions occur when code executes in an unexpected or unhappy path
	//happy path refers to programs working correctly with correct input
	
	
	public static void main(String[] args) {
		
		int x = 5;
		int y = 0;
		
		// the core structure of exception handling in Java
		try {
			int result = x/y;
			//same thing as
			
			//exceptions are just objects. using the throw keyword 
			//will send that object through the application until it is caught
			
			//worst case scenario it is never caught and hits the JVM
			throw new ArithmeticException();
			//throw new FileNotFoundException();
			//only one catch block will ever execute
		}catch(Exception ae) {
			System.out.println("You divided by 0!!!!");
		}
		//you cannot have unreachable code in Java. that is a compiler error
		catch (FileNotFoundException e) {
			System.out.println("Caught a file not found exception");
		}
		//you will see finally blocks used to close resources a lot
		finally {
			System.out.println("This code will always execute");
		}
		
		
	}

}
