package threadfun;

//You can inherit from the Thread class instead of using the Runnable interface
public class Process extends Thread {
	
	@Override
	public void run() {
		//code you want the process to run
		//is empty by default
	}
	
	public static void main(String[] args) {
		Process p = new Process();
		p.start();
	}

}
