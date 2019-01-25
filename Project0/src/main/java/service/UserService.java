package service;

import java.util.List;

import dao.UserDAO;
import model.User;


public class UserService {
	
	public static User getUser(int u_id) {
		return new UserDAO().getUser(u_id);
		
	}
	
	public static boolean addUser(User u) {
		return new UserDAO().addUser(u);
	}
	
	public static boolean deleteUser(int u_id) {
		return new UserDAO().deleteUser(u_id);
	}
	
	public static List<User> allUsers(){
		return new UserDAO().allUsers();
	}

}
