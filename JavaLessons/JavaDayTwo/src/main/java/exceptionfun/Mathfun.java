package exceptionfun;
import java.io.FileNotFoundException;

public class Mathfun {
	
	//exceptions occur when code executes in an unexpected or unhappy path
	//happy path refrs to programs working correctly with correct input
	public static void main(String[] args) {	
		int x = 5;
		int y = 0;
		
		try {
			int result = x/y;	
			throw new FileNotFoundException();
		}catch(Exception e) {
			e.printStackTrace();
			//you cannot have unreachable code in java
		}catch(FileNotFoundException e) {
			
		}finally{
			//Code here will always execute
			//may be useful to close resources
			System.out.println("Classes");
		}
		
	}
}
