package doa_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Account;
import model.User;
import service.AccountService;
import service.UserService;

public class AccountDAOTesting {

	@BeforeClass
	public static void setUp() {
		UserService.addUser(new User(0,"Test","test", 0));
		AccountService.addAccount(new Account(0, 100, "Checking", UserService.getUser("Test").getB_id()));
		AccountService.addAccount(new Account(0, 100, "Checking", UserService.getUser("Test").getB_id()));
		AccountService.addAccount(new Account(0, 100, "Savings", UserService.getUser("Test").getB_id()));
		AccountService.addAccount(new Account(0, 100, "Savings", UserService.getUser("Test").getB_id()));
	}
	
	@Test
	public void addAccount() {
		assertTrue(AccountService.addAccount(new Account(0, 100, "Savings", UserService.getUser("Test").getB_id())));
	}
	
	@Test
	public void allAccounts() {
		assertTrue(AccountService.allAccounts(UserService.getUser("Test").getB_id()).size() > 0);
	}
	
	@Test
	public void allAccountsFalse() {
		assertFalse(AccountService.allAccounts(UserService.getUser("Test").getB_id()).size() == 0);
	}
	
	@Test
	public void deleteAccount() {
		assertTrue(AccountService.deleteAccount(AccountService.allAccounts(UserService.getUser("Test").getB_id()).get(0).getA_id()));
	}
	
	
	@Test
	public void withdraw() {
		assertTrue(AccountService.withdraw(AccountService.allAccounts(UserService.getUser("Test").getB_id()).get(0).getA_id(), 10));
	}
	
	@Test
	public void withdrawFalse() {
		assertFalse(AccountService.withdraw(AccountService.allAccounts(UserService.getUser("Test").getB_id()).get(0).getA_id(), 1000));
	}
	
	@Test
	public void deposit() {
		assertTrue(AccountService.deposit(AccountService.allAccounts(UserService.getUser("Test").getB_id()).get(0).getA_id(), 10));
	}
	
	@Test
	public void getAccount() {
		assertTrue(AccountService.getAccount(AccountService.allAccounts(UserService.getUser("Test").getB_id()).get(0).getA_id()) != null);
	}
	
	@Test
	public void withdrawAll() {
		assertTrue(AccountService.withdrawAll(AccountService.allAccounts(UserService.getUser("Test").getB_id()).get(2).getA_id()));
	}
	
	@AfterClass
	public static void setDown() {
		UserService.deleteUser(UserService.getUser("Test").getB_id());
		
	}
}
