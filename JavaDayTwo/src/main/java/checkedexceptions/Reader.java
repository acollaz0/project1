package checkedexceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
	
	public static void main(String[] args) {
		

		// the responsibility of handling the file not found exception does not go away
		// when you use throws it just passes the responsibility on to the method calling
		// that method
		try {
			readAwfulFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// throws declaration is essentially a warning that this method can generate an 
	// exception and it is not handled within the method
	public static void readAwfulFile() throws FileNotFoundException {
		
		File f = new File("sea:adam/unicorn/leprachauns");
		System.out.println(f.exists());
		
		// Java can recognize when an exception can occur and will require you
		// to handle it in some way

			BufferedReader reader = new BufferedReader(new FileReader(f));

	}
	
	
	
	

}
