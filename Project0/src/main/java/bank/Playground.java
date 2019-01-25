package bank;

import java.util.Scanner;

public class Playground {

	public static void main(String[] args) {
		String input;
		UserDao userDao = new UserDaoImpl();
		
//		for(User user: userDao.getAllUsers()) {
//			System.out.println(user.toString());
//		}
//		
//		User user = userDao.getAllUsers().get(0);
//		user.setUsername("Logan");
//		userDao.updateUser(user);
//		
//		for(User user2: userDao.getAllUsers()) {
//			System.out.println(user2.toString());
//		}
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your username");
		input = scan.next();
		System.out.println(input);
		System.out.println("Please enter your password");
		input = scan.next();
		System.out.println(input);
		
		scan.close();
		
		

	}

}
