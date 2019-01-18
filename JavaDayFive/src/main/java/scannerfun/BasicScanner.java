package scannerfun;

import java.util.Scanner;

public class BasicScanner {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Please give me one number and I will add 10 to it");
		//Scanners can be difficult
		int number = 0;
		try {
			number = kbd.nextInt();	
		}catch(Exception e) {
			
		}
		
		System.out.println(number + 10);
		kbd.close();
	}
}
