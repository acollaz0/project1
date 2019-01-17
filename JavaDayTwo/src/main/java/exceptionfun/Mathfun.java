package exceptionfun;

public class Mathfun {
	
	//exceptions occur when code executes in an unexpected of unhappy path
	//happy path refers to programs working correctly with correct input
	
	public static void main(String[] args) {
		
		int x=5;
		int y=0;
		//the core structure of exception handling in Java
		try {
		int result = x/y;
		//the same thing as
		//throw new ArithmeticException();
		//throw new FileNotFoundException();
		//Exceptions are just objects. Using the throw keyword
		//will send that object through the application until it is caught
		//Worst case scenario it is never caught and hits JVM
		//only one catch block will execute
		}catch(ArithmeticException ae){
			System.out.println("You divided by 0!!!");			
		}
		//you cannot have unreachable code in Java. That is compiler error
		/*catch(FileNotFoundException e) {
			System.out.println("Caught a file not found exception");
		}*/
		//You will see finally blocks used to close resources a lot
		finally {
			System.out.println("This code will always execute");
		}
	}

}
