package threadfun;

public class App {
	
	public static void main(String[] args) {
		//The runnable functional interface is just a method that allows us to give instructions/code
		//for a single thread to execute
		
		Runnable task1 = () -> {
			Resource.change(1, 2000);
			//System.out.println(Resource.number);
		};
		
		Runnable task2 = () -> {
			Resource.change(2, 500);
			
		};
		
		//You can make a thread using the Thread class
		
		//the lambda task1 is providing code for a thread to execute
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		//At this point, java hasn't been told to do anything yet. We've just shown it the instructions
		thread1.start();
		thread2.start();
		
	}
	
}