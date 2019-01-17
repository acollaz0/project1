package exceptionfun;

public class MathFun {
	
	//Exceptions occur when code executes in an unexpected or unhappy(?) path
	//Happy path refers to programs working correctly with correct input
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 5;
		int y = 0;
		
		//core structure of exception handling
		try {
			int result = x/y;
			
			//or gets same result:
			throw new ArithmeticException(); //using throw keyword creates a checked exception
			//Exceptions are just objects. When thrown, they will be sent through the application until caught, or 
			//they hit the JVM (that's bad).
		} catch (ArithmeticException ae) {
			// Can have multiple catch blocks, but only one catch block will ever execute
			System.out.println("Oops");
		} finally { //Will see this used to close resources a lot
			System.out.println("This code will always execute.");
		}
		
	}
	
	

}
