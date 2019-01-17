package threadfun;

public class App {
	
	
	public static void main(String[]args) {
	
	//the runnable functional interface is just a method 
	//that allows us to give instructions/code for a single thread to execute
	
	Runnable task1 = () ->{
		Resource.change(1,2000);
		System.out.println(Resource.number);
		
	};
	
	Runnable task2 = () ->{
		Resource.change(2, 500);
		System.out.println(Resource.number);
	};
//you can make a thread using the thread class
	//the lambda is providing code that a thread should execute
	Thread thread1 = new Thread(task1);
	Thread thread2 = new Thread(task2);
	
	//actually starts execution of the code in a thread;
	thread1.start();
	thread2.start();
	
	
}
}