package app;

import java.util.Scanner;

public class Playground {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String userinput; 
		System.out.println("Please enter your username");
		
		userinput = scan.nextLine();
		
		switch (userinput) {
		case "Test": {System.out.println("Username: "+ userinput);
						} break;
		default: {System.out.print("Not a valid name");}
		}
		
		scan.close();
		
	}

}
