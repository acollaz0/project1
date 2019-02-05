package readwriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Readwriter {
	public static void main(String[] args) {
		try {
			write();
		
		}catch(IOException e) {
			
		}
	}
	
	public static void write() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("../JavaDayTwo/src/main/resources/io.txt"));
	}
	public static void read() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("../JavaDayTwo/src/main/resources/io.txt"));
		String s = br.readLine();
		System.out.println(s);
		br.close();
	}
}
