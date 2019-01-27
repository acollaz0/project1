package service;

import java.util.List;

import dao.UserDAO;
import model.User;


public class UserService {
	
	public static UserDAO ud = new UserDAO();
	
	public static User getUser(String username) {
		User u = ud.getUser(username);
		return u;
		
	}
	
	public static boolean addUser(User u) {
		return ud.addUser(u);
	}
	
	public static boolean deleteUser(int b_id) {
		return  ud.deleteUser(b_id);
	}
	
	public static List<User> allUsers(){
		return ud.allUsers();
	}
	
	public static boolean updateUserPass(int b_id, String password) {
		return ud.updateUserPass(b_id, password);
	}
	
	public static boolean updateUserName(int b_id, String username) {
		return ud.updateUserName(b_id, username);
	}

}
