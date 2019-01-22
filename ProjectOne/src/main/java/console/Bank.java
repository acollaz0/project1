package console;

import java.awt.List;
import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import users.*;

public class Bank {
	public static void main(String[] args) {
		ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
		
		Scanner kbd = new Scanner(System.in);
		System.out.println("Are you a returning user?");
		System.out.print(">>(y/n)");
		String next = kbd.nextLine();
		if(next != null && next.charAt(0)== 'y') {
			User user;
			String u, p;
			//login user
			System.out.println("Please enter username");
			System.out.print(">>");
			u = kbd.next();
            System.out.println("Enter password: ");
            System.out.print(">>");
        	p = kbd.next();
        	user = UserFactory.getUser(u, p);
        	
        	System.out.println(user.toString());
			
		}
		else if(next != null && next.charAt(0)== 'n') {
			System.out.println("Please enter a password to create a new account.");
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
