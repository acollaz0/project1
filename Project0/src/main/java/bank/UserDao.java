package bank;

import java.util.List;

public interface UserDao {
	
	public List<User> getAllUsers();
	public void updateUser(User user);
	public void deleteUser(User user);
	public void addUser(User user);

}
