package dao_test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.BankAccount;
import model.Transaction;
import model.User;
import service.BankAccountService;
import service.TransactionService;
import service.UserService;

public class TransactionDAOTesting {
	
	@BeforeClass
	public static void beforeClass() {
		UserService.addUser(new User("test_username", "test_password", "test_first", "test_last", "user"));
		BankAccountService.addBankAccount(UserService.getUser("test_username").getUser_id(), new BankAccount(234.23, "checking"));
		
	}
	
	@AfterClass
	public static void afterClass() {
		User u = UserService.getUser("test_username");
		UserService.deleteUser(u.getUser_id());
		
	}
	
	@Test
	public void addNewTransaction() {
		int user_id = UserService.getUser("test_username").getUser_id(); // get a user_id
		List<BankAccount> ba = BankAccountService.allBankAccounts(user_id); // get a list of bank accounts for this user
		int bank_account_id = ba.get(0).getBank_account_id(); // get the first bank account id
		assertTrue(TransactionService.addTransaction(bank_account_id, new Transaction(423.43, 344.34)));
	}
	
	@Test
	public void addAnotherTransaction() {
		int user_id = UserService.getUser("test_username").getUser_id(); // get a user_id
		List<BankAccount> ba = BankAccountService.allBankAccounts(user_id); // get a list of bank accounts for this user
		int bank_account_id = ba.get(0).getBank_account_id(); // get the first bank account id
		assertTrue(TransactionService.addTransaction(bank_account_id, new Transaction(56.23, 240.34)));
	}
	
	@Test
	public void getAllTransactions() {
		int user_id = UserService.getUser("test_username").getUser_id(); // get a user_id
		List<BankAccount> ba = BankAccountService.allBankAccounts(user_id); // get a list of bank accounts for this user
		int bank_account_id = ba.get(0).getBank_account_id(); // get the first bank account id
		assertTrue(TransactionService.allTransactions(bank_account_id).size() >= 2); // get a list of transactions for this user
	}
}
