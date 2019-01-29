package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connect.JDBCLink;
import dao.IUserDAO;
import dao.UserDAO;
import models.User;

public class UserDAOTest {

	private static Savepoint sp;
	private static Savepoint testsp;
	private static Connection con;
	private static IUserDAO udao;
	private static User u1;
	private static User u2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		udao = new UserDAO();
		con = JDBCLink.getConnection();
		con.setAutoCommit(false);
		sp = con.setSavepoint("original");
		
		String sql = "delete from bankuser";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		udao.addUser(new User("user1","aaaaaa",true));
		u1=udao.getUser("user1");
		udao.addUser(new User("user2","aaaaaa",false));
		u2=udao.getUser("user2");
	}

	@Before
	public void setUpBeforeEachTest() throws SQLException {
		testsp = con.setSavepoint("test_savepoint");
	}

	@After
	public void rollbackAfterEachTest() throws SQLException {
		con.rollback(testsp);
		System.out.println("Rolling back individual test changes");
	}
	
	@Test
	public void testAddExtantUser() {
		assertFalse(udao.addUser(u1));
	}

	@Test
	public void testAddNewUser() {
		assertTrue(udao.addUser(new User("user3","aaaaaa",false)));
	}
	
	@Test
	public void testValidateExtantStringString() {
		assertTrue(udao.validateUser(u1.getUsername(),u1.getPassword()));
	}

	@Test
	public void testValidateNonUserStringString() {
		assertFalse(udao.validateUser("user1", "bbbbbb"));
	}

	@Test
	public void testIsSuperUserTrue() {
		assertTrue(udao.isSuperUser(u1.getUsername()));
	}
	
	@Test
	public void testIsSuperUserFalse() {
		assertFalse(udao.isSuperUser(u2.getUsername()));
	}

	@Test
	public void testIsExtantUserTrue() {
		assertTrue(udao.isExtantUser(u1.getUsername()));
	}

	@Test
	public void testIsExtantUserFalse() {
		assertFalse(udao.isExtantUser("user3"));
	}
	
	@Test
	public void testGetUser() {
		assertEquals(u1.getUsername(),udao.getUser(u1.getUsername()).getUsername());
	}

}
