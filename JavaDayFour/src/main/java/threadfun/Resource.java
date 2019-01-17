package threadfun;

public class Resource {
	
	static Integer number = 0;
	
	// synchronized keyword will prevent one thread from enetering the method
	// if another thread is already using it
	public synchronized static void change(int num, int delay) {
		
		try {
			System.out.println(Thread.currentThread());
			Thread.sleep(delay);// This is simulating code that takes
								// an inconsistent amount of time to complete
			number = num;
			System.out.println(Resource.number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
