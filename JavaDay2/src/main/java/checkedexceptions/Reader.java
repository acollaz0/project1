package checkedexceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("sea:tom/big");
		System.out.println(f.exists());
		
		try {
			//Java can recognize when an expection can occur and will require you to handle the exception somehow
			BufferedReader reader = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			readAwfulFile();//now this has to be handled in the method that called readAwfulFile() 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void readAwfulFile() throws FileNotFoundException {

		//throws keyword indicates that
		//this method can create an exception that isn't handled inside the method.

		File f = new File("sea:tom/big");
		System.out.println(f.exists());

		BufferedReader reader = new BufferedReader(new FileReader(f));
			
		
	}

}
