package console;

import java.awt.List;
import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import dao.UserDAO;

public class App {
	public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);
		System.out.println("Are you a returning user?");
		System.out.print(">>(y/n)");
		String next = kbd.nextLine();
		if(next != null && next.charAt(0)== 'y') {
			//login user
			System.out.println("Please enter username");
			System.out.print(">>");
			String u = kbd.next();
            Console console = System.console() ;
            System.out.println("Enter password: ");
            char [] password = console.readPassword("Enter password");
             Arrays.fill(password,' ');

			
		}
		else if(next != null && next.charAt(0)== 'n') {
			System.out.println("would you like to create a new account?");
			System.out.print(">>");	
		}
		
		
		kbd.close();
	}
	public boolean loginUser(String u, String p) {
		return false;
	}
	public boolean createUser(String u, String p) {
		return false;
	}
	
}
