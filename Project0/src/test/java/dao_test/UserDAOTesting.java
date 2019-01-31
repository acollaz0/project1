package dao_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.User;
import service.UserService;

public class UserDAOTesting {
	
	@BeforeClass
	public static void beforeClass() {
		UserService.addUser(new User("test_username", "test_password", "test_first", "test_last", "user"));
		UserService.addUser(new User("test_username2", "test_password", "test_first", "test_last", "user"));
	}
	
	@AfterClass
	public static void afterClass() {
		User u = UserService.getUser("test_username");
		UserService.deleteUser(u.getUser_id());
		User u2 = UserService.getUser("test_username3");
		UserService.deleteUser(u2.getUser_id());
	}

	@Test
	public void addNewUser() {
		User u = new User("test_username3", "test_password", "test_first", "test_last", "user");
		assertTrue(UserService.addUser(u));
	}
	
	@Test
	public void addExistingUser() {
		
		User u = new User("test_username", "test_password2", "test_first2", "test_last2", "user");
		assertFalse(UserService.addUser(u));
	}
	
	@Test
	public void getExistingUser() {
		
		assertTrue(UserService.getUser("test_username") != null);
	}
	
	@Test
	public void getNonexistantUser() {
		assertFalse(UserService.getUser("wrong_username") != null);
	}
	
	@Test
	public void updateExistingUser() {
		User u = UserService.getUser("test_username");
		u.setPassword("updated_password");
		assertTrue(UserService.updateUser(u));
	}
	
	@Test
	public void updateNonexistantUser() {
		
		User u = new User(34832, "nobody", "no_password", "test_first", "test_last", "user");
		assertFalse(UserService.updateUser(u));
	}
	
	@Test
	public void getAllUsers() {
		assertTrue(UserService.allUsers().size() >= 2);
	}
	
	@Test
	public void deleteExistingUser() {
		
		User u = UserService.getUser("test_username2");
		assertTrue(UserService.deleteUser(u.getUser_id()));
	}
	
	@Test
	public void deleteNonexistantUser() {
		
		assertFalse(UserService.deleteUser(34832));
	}

}
