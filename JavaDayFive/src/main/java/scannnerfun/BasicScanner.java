package scannnerfun;

import java.util.Scanner;

public class BasicScanner {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please give me one number and I will add 10 to it");
		int number = scan.nextInt();
		
		
		System.out.println(number +10);
		
		// Scanner can be a little bit of a tricky class
		// be careful of carriage returns (warning)
		scan.close();// Good practice to close the scanner when the application is ending
		
		
		
	}
	
	
	
	
}
