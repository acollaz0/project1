package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.UserDAO;

public class UserDAOTest {

	private static UserDAO udao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		udao = new UserDAO();
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidateUserUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidateUserStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSuperUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsExtantUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUser() {
		fail("Not yet implemented");
	}

}
