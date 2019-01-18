package scannerfun;

import java.util.Scanner;

public class BasicScanner {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please give me a number and I'll add ten");
		int num = scan.nextInt();
		System.out.println(num+10);
		
		
		//Scanner can be a tricky class
		//Be careful of carriage returns
		scan.close(); //Good practice to close the scanner
		
		
	}

}
