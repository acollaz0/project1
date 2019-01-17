package threadfun;

public class Process extends Thread {

	//second way to create a thread
	@Override
	public void run() {
		// code that you would write
	}
	
	public static void main(String[] args) {
		Process p =  new Process();
		// The start method calls the run method
		p.start();
	}
}
