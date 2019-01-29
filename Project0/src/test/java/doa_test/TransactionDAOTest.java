package doa_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Account;
import model.User;
import service.AccountService;
import service.TransactionService;
import service.UserService;

public class TransactionDAOTest {
	
	@BeforeClass
	public static void setUp() {
		UserService.addUser(new User(0,"Test","test", 0));
		AccountService.addAccount(new Account(0, 100, "Checking", UserService.getUser("Test").getB_id()));
		AccountService.deposit(AccountService.allAccounts(UserService.getUser("Test").getB_id()).get(0).getA_id(), 100);
	}

	@Test
	public void getTransactions() {
		assertTrue(TransactionService.getTransactions(UserService.getUser("Test").getB_id()).size() > 0);
	}
	
	@Test
	public void getTransactionsFalse() {
		assertFalse(TransactionService.getTransactions(UserService.getUser("Test").getB_id()).size() == 0);
	}
	
	@AfterClass
	public static void setDown() {
		UserService.deleteUser(UserService.getUser("Test").getB_id());
	}
}
