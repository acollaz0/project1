package threadfun;

public class Resource {
	static Integer number = 0;
	
	
	public synchronized static void change(int num, int delay) {
		
		try {
			System.out.println(Thread.currentThread());
			Thread.sleep(delay);//Simulating code that takes an inconsistent amount of time
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		number = num;
	}
}
