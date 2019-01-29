package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import connect.JDBCLink;
import dao.ClipBoxDAO;
import models.ClipBox;
import models.User;

public class ClipBoxDAOTest {
	
	private static ClipBoxDAO cbdao;
	private static Connection con = JDBCLink.getConnection();
	private static ClipBox box1,box2;
	private static Savepoint sp;
	private static Savepoint testsp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cbdao = new ClipBoxDAO();
		con.setAutoCommit(false);
		sp = con.setSavepoint("original");
		String sql = "delete from clipbox";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		box1 = cbdao.addClipBox(new User("adminC", "xxxxxx", true),"MainTest1");
		box2 = cbdao.addClipBox(new User("adminB", "password", true),"MainTest2");
		box2.deposit(10);
		
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
	public void testAddClipBoxUser(){
		ClipBox boxtest = cbdao.addClipBox(new User("adminC", "xxxxxx", true),"Briefly Testing");
		assertNotNull(boxtest);
//		con.rollback(testsp);
	}
	@Test
	public void testAddClipBoxNonexistantUser(){
//		Savepoint testsp = con.setSavepoint("test_savepoint");
		ClipBox boxtest  = cbdao.addClipBox(new User("adminD", "xxxxxx", true),"Testing");
		assertNull(boxtest);
//		con.rollback(testsp);
	}
	@Test
	public void testDeleteEmptyClipBox(){
//		Savepoint testsp = con.setSavepoint("test_savepoint");
		assertTrue(cbdao.deleteClipBox(box1));
//		con.rollback(testsp);
	}
	@Test
	public void testDeleteNonEmptyClipBox() {
//		Savepoint testsp = con.setSavepoint("test_savepoint");
		assertFalse(cbdao.deleteClipBox(box2));
//		con.rollback(testsp);
	}

	@Test
	public void testGetClipBoxes() {
		assertEquals(2,cbdao.getClipBoxes().size());
	}

	@Test
	public void testGetClipBoxesUser() {
		assertEquals(1,cbdao.getClipBoxes(new User("adminC", "xxxxxx", true)).size());
	}

	@Test
	public void testIsExtantClipBoxTrue() {
		assertTrue(cbdao.isExtantClipBox(box1.getCb_id()));
	}

	@Test
	public void testIsExtantClipBoxFalse() {
		assertFalse(cbdao.isExtantClipBox("K2222L8JJJ"));
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(0,cbdao.getBalance(box1.getCb_id()));
	}

	@Test
	public void testGetClipBoxString() {
		assertNotNull(cbdao.getClipBox(box1.getCb_id()));
	}
	
	@Test
	public void testGetUnrealClipBoxString() {
		assertNull(cbdao.getClipBox("XXXXXXXXX"));
	}

	@Test
	public void testMakeTransaction() {
		cbdao.makeTransaction(box1.getCb_id(), 20);
		assertEquals(20,cbdao.getBalance(box1.getCb_id()));
	}
	@AfterClass
	public static void afterClass() {
		try {
			System.out.println("Rolling back ALL changes");
			con.rollback(sp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
