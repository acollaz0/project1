package doa_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.User;
import service.UserService;

public class UserDAOTesting {

	@BeforeClass
	public static void setUp() {
		UserService.addUser(new User(0,"Test1", "test", 0));
		UserService.addUser(new User(0,"Test2", "test", 0));
		UserService.addUser(new User(0,"Test3", "test", 0));
	}
	
	@Test
	public void getUser() {
		User u = new User(0, "Test1", "test", 0);
		assertTrue(UserService.getUser("Test1").getUsername().equals(u.getUsername()));
	}
	
	@Test
	public void getUserFalse() {
		assertTrue(UserService.getUser("asdsadasda") == null);
	}
	
	@Test
	public void addUser() {
		User u = new User(0, "test", "test", 0);
		assertTrue(UserService.addUser(u));
	}
	
	@Test
	public void addUserFalse() {
		User u = new User(0, "Test1", "test", 0);
		assertFalse(UserService.addUser(u));
	}
	
	@Test
	public void deleteUser() {
		assertTrue(UserService.deleteUser(UserService.getUser("Test2").getB_id()));
	}
	
	@Test
	public void deleteUserFalse() {
		assertFalse(UserService.deleteUser(0));
	}
	
	@Test
	public void updateUserPass() {
		assertTrue(UserService.updateUserPass(UserService.getUser("Test1").getB_id(),"test3"));
		
	}
	@Test
	public void updateUserPassFalse() {
		assertFalse(UserService.updateUserPass(0, "asdad"));
	}
	
	@Test
	public void updateUserName() {
		assertTrue(UserService.updateUserName(UserService.getUser("Test3").getB_id(), "Test4"));
	}
	
	@Test
	public void updateUserNameFalse() {
		assertFalse(UserService.updateUserName(UserService.getUser("Aaron").getB_id(), "Test1"));
	}
	
	@Test
	public void allUsers() {
		assertTrue(UserService.allUsers().size() > 0);
	}
	
	@Test
	public void allUsersFalse() {
		assertFalse(UserService.allUsers().size() == 0);
	}
	
	@AfterClass
	public static void setDown() {
		UserService.deleteUser(UserService.getUser("Test1").getB_id());
		UserService.deleteUser(UserService.getUser("Test4").getB_id());
		UserService.deleteUser(UserService.getUser("test").getB_id());
	}

}
