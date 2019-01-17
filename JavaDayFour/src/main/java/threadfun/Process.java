package threadfun;

public class Process extends Thread{
	//second way to create a thread
	@Override
	public void run() {
		
	}
	public static void main(String[] args) {
		Process p = new Process();
		//the start method calls the run method
		p.start();
	}
}
