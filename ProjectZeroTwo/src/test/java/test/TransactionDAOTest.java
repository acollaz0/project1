package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import connect.JDBCLink;
import dao.ClipBoxDAO;
import dao.TransactionDAO;
import models.ClipBox;
import models.Transaction;
import models.User;

public class TransactionDAOTest {

	private static TransactionDAO tdao;
	private static Connection con = JDBCLink.getConnection();
	private static ClipBox box;
	private static ClipBoxDAO cbdao = new ClipBoxDAO();
	private static Transaction t; 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tdao = new TransactionDAO();
		con.setAutoCommit(false);
		String sql = "delete from trans";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		box = cbdao.getClipBox("KDBD1WRU74");
		t=box.deposit(1);
	}

	
	@Test
	public void testGetTransactionsStandard() {
		assertEquals(1,tdao.getTransactions().size());
	}
	
	@Test
	public void testGetTransactionsUserWithNoTransactions() {
		assertEquals(0,tdao.getTransactions(new User("DeepBlue", "knight", false)).size());
	}
	
	@Test
	public void testGetTransactionsUserWithTransactions() {
		assertEquals(1,tdao.getTransactions(new User("MarvinAndroid", "beeblebrox", false)).size());
	}
	
	@Test
	public void testGetTransactionsUserEmpty() {
		assertEquals(0,tdao.getTransactions(new User(null, null, false)).size());
	}

	@Test
	public void testGetTransactionWithBadID() {
		
		assertEquals(null,tdao.getTransaction("TRSA"));
		
	}
	@Test
	public void testGetTransactionWithGoodID() {
		
		assertEquals(5,tdao.getTransaction("TRSYH1JWVE9KV").getValue());
		
	}
	@Test
	public void testGetTransactionWithEmptyID() {
		
		assertEquals(null,tdao.getTransaction(""));
		
	}
	
	@AfterClass
	public static void afterClass() {
		try {
			System.out.println("Rolling back changes");
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
