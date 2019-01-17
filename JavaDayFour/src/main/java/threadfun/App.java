package threadfun;

public class App {
	
	
	// The runnable functional interface is just a method
	// That allows us to give instructions/code for a single thread to execute
	public static void main(String[] args) {
		
		Runnable task1 = () ->{
			Resource.change(1, 2000);
		};
		
		Runnable task2 = () ->{
			Resource.change(2, 500);
			
		};
		
		//You can make a thread using the Thread class
		
		// the lambda is providing code that a thread should execute
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		// Actually starts execution of the code in a thread
		thread1.start();
		thread2.start();
		
		
		
	}
	

	
	
	
	
	
	
	
}
