package checkedexceptions;
import java.io.*;

public class Reader {

	public static void main(String[] args) {
		
		File f = new File("sea:chris/unicorn/leprachauns");
		System.out.print(f.exists());
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			readAwfulFile();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public static void readAwfulFile() throws FileNotFoundException{
		
		File f = new File("sea:chris/unicorn/leprechauns");
		System.out.println();
	}
	
}
