package readwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Readwriter {
	
	public static void main(String[] args) {
		
		try {
			write();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void write() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("../JavaDayTwo/src/main/resources/io.txt"));
		bw.write("Hello");
		bw.close();
	}

}
