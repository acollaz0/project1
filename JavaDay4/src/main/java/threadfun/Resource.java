package threadfun;

public class Resource {
	
	static Integer number = 0;
	
	//The synchronized keyword prevents one thread from entering the method if another thread is already using it.
	public synchronized static void change(int num, int delay) {
		
		try {
			
			System.out.println(Thread.currentThread());
			
			Thread.sleep(delay); //This simulates code that takes an inconsistent amount of time to complete
			number = num;
			System.out.println(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
