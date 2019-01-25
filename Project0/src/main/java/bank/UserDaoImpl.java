package bank;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
	
	//Collection to hold users from database
	List<User> users;
	
	public UserDaoImpl() {
		//retrieve users from database and add them to users list
		
		//testing without DB
		users = new ArrayList<>();
		User user1 = new User("Ryan","password", false, 0);
		User user2 = new User("Chris", "1231313", true, 1);
		users.add(user1);
		users.add(user2);
		
	}
	

	public List<User> getAllUsers() {
		
		return users;
	}

	public void updateUser(User user) {
		//take user.username and/or user.password
		//find the user in database or list
		//change the user's username or password
		//add change to database
		
		users.get(user.getUserid()).setUsername(user.getUsername());
		
	}

	public void deleteUser(User user) {
		//find user in database based on user.username
		//remove user from database
		
	}

	public void addUser(User user) {
		//make sure user is unique
		//take user and add fields to database
		
		
	}

}
