package tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputTools {
	public static int getNumberInput(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (int i = 1; i <= args.length; i++) {
			System.out.println(String.format("%-20s", args[i-1]) + " : " + i);
		}
		int selection = 0;
		
		try {
			
			
			String s = scan.nextLine();
			System.out.println(s);
			selection = Integer.parseInt(s);

			System.out.println("*-" + selection + "-*");
			
			if (selection >= 1 && selection <= args.length) {
				System.out.println("Made valid selection");
			} else {
				selection = 0;
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input");
			selection = 0;
		}
		scan.close();
		return selection;
	}
}
