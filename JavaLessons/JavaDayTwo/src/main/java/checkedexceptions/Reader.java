package checkedexceptions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;




public class Reader {

	public static void main(String[] args){
		//the responsibility of handling the FNF exception does not 
		//go away when you use throws it simply passes the responsibility
		//to the calling method
		try {
			readAwfulFile();
		}catch(FileNotFoundException e){
			
		}
	}
	public static void readAwfulFile() throws FileNotFoundException {
		File f = new File("sea:brandon\\unicorn\\gorilla");
		System.out.println("");
		BufferedReader br = new BufferedReader(new FileReader(f));
	}
}
