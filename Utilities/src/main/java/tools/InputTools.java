package tools;

import java.io.Console;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputTools {
	/**
	 * @param args an array of strings listing the available options
	 * @return and int referencing the chosen selection. returns a number 1 or greater if there was a successful selection, 
	 * returns 0 if the user requested an exit
	 * @throws UserInputException 
	 */
	public static int getNaturalNumberInput(String[] args) throws UserInputException {
		Scanner scan = new Scanner(System.in);
		
		int selection = 0;
		
		for (int i = 1; i <= args.length; i++) {
			System.out.println(String.format("%3d : %-20s", i,args[i - 1]));
		}
		
		while (
				//Checks if boxlabel is within acceptable range
				!(selection>=1 && selection<=args.length)
				)
		{
			while (!scan.hasNextInt()) {
				String templine = scan.nextLine();
				if (templine.contains("exit")) {
					System.out.println("You chose to exit operation.");
					System.out.println("Press ENTER To Continue");
					scan.nextLine();
					throw new UserInputException();
				} else {
					System.out.println("*" +templine + "* is not a valid input.");
				}
			}
			selection = Integer.parseInt(scan.nextLine());
			if (!(selection>=1 && selection<=args.length)) {
				System.out.println("You cannot select a number less than one, or greater than " + args.length);
				
			}
		}
		//scan.close();
		return selection;
		
	}

	
	public static int getNaturalNumberInput(int maxnum) throws UserInputException {
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a number between 1 and " + maxnum);
		
		int selection = 0;
		
		while (
				//Checks if boxlabel is within acceptable range
				!(selection>=1 && selection<=maxnum)
				)
		{
			while (!scan.hasNextInt()) {
				String templine = scan.nextLine();
				if (templine.contains("exit")) {
					System.out.println("Cancelling operation");
					System.out.println("Press ENTER To Continue");
					scan.nextLine();
					throw new UserInputException();
				} else {
					System.out.println("*" +templine + "* is not a valid input.");
				}
			}
			
			String templine = scan.nextLine();
			try {
				selection = Integer.parseInt(templine);
			} catch (NumberFormatException e) {
				System.out.println("*" +templine + "* is not a valid input.");
			}
			
			if (!(selection>=1 && selection<=maxnum)) {
				System.out.println("You cannot select a number less than one, or greater than " + maxnum);
				
			}
		}
		return selection;
		//scan.close();
	}
	
	public static String getAlphanumericString(int minlength) throws UserInputException {
		return getAlphanumericString(minlength, null);
	}
	
	public static String getAlphanumericString(int minlength, String prompt) throws UserInputException {
		
		if(prompt!=null) {
			System.out.println(prompt);
		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a string only containing letters and numbers");
		
		String selection = "";
		String regexmatch = String.format("\\A[A-Za-z0-9]{%d,}\\Z", minlength);
		
		while (!(selection.matches(regexmatch))) {
			
			selection = scan.nextLine().trim();
			
			if (selection.matches("exit")) {
//				System.out.println("Cancelling operation");
//				System.out.println("Press ENTER To Continue");
//				scan.nextLine();
				throw new UserInputException();
			}
			
			if ( !(selection.matches(regexmatch)) ) {
				System.out.println("*" + selection + "* is not a valid password.");
			}
			
		}
		
		
		return selection;
	}
	
	public static String getPasswrod(int minlength) throws UserInputException {
		return getPassword(minlength,null);
	}
	
	public static String getPassword(int minlength, String message) throws UserInputException {
		if (message != null) {
			System.out.println(message);
		}
		Console console = System.console();
		
		String password = "";
		String regexmatch = String.format("\\A[A-Za-z0-9]{%d,}\\Z", minlength);
		
		while (!password.matches(regexmatch)) {
			password = String.copyValueOf(console.readPassword());
			
			if (password.matches("exit")) {
//				System.out.println("Cancelling operation");
//				System.out.println("Press ENTER To Continue");
//				scan.nextLine();
				throw new UserInputException();
			}
			
			if ( !(password.matches(regexmatch)) ) {
				System.out.println("*" + password + "* is not a valid password.");
			}
			
		}
		
		
		return password;
		
	}
	
	public static String getSimpleTextString(int minlength) throws UserInputException {
		return getSimpleTextString(minlength, null);
	}
	
	public static String getSimpleTextString(int minlength, String prompt) throws UserInputException {
		
		if(prompt!=null) {
			System.out.println(prompt);
		}
		
		Scanner scan = new Scanner(System.in);
		
		String selection = "";
		String regexmatch = String.format("\\A[A-Za-z0-9\\s,\\.'_-]{%d,}\\Z", minlength);
		
		while (!(selection.matches(regexmatch))) {
			
			selection = scan.nextLine().trim();
			
			if (selection.matches("exit")) {
//				System.out.println("Cancelling operation");
//				System.out.println("Press ENTER To Continue");
//				scan.nextLine();
				throw new UserInputException();
			}
			
			if ( !(selection.matches(regexmatch)) ) {
				System.out.println("\""+selection + "\" is not a valid input.");
			}
			
		}
		
		
		return selection;
	}


	public static int getYesNo() throws UserInputException {
		System.out.println("Are you certain?");
		return getNaturalNumberInput(new String[] {"Yes","No"});
	}
	public static int getYesNo(String prompt) throws UserInputException {
		System.out.println(prompt);
		return getNaturalNumberInput(new String[] {"Yes","No"});
	}
	
}
