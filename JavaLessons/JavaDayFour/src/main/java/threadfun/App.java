package threadfun;

public class App {
	//the runnable functional interface is just a method
	//That allows us to give instructions/code for a single thread to execute
	public static void main(String[] args) {
		
		Runnable task1 = () ->{
			Resource.change(1, 2000);
			System.out.println(Resource.number);
		};	
		Runnable task2 = () ->{
			Resource.change(2, 500);
			System.out.println(Resource.number);
		};
		
		//You can make a thread using the thread class
	
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		
		//to start running threads
		thread1.start();
		thread2.start();
		
	}
}