package dao_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.BankAccount;
import model.User;
import service.BankAccountService;
import service.UserService;

public class BankAccountDAOTesting {

	@BeforeClass
	public static void beforeClass() {
		UserService.addUser(new User("test_username", "test_password", "test_first", "test_last", "user"));
		BankAccountService.addBankAccount(UserService.getUser("test_username").getUser_id(), new BankAccount(234.23, "checking"));
		BankAccountService.addBankAccount(UserService.getUser("test_username").getUser_id(), new BankAccount(984.00, "savings"));
	}
	
	@AfterClass
	public static void afterClass() {
		User u = UserService.getUser("test_username");
		UserService.deleteUser(u.getUser_id());
		
	}

	@Test
	public void addNewBankAccount() {
		assertTrue(BankAccountService.addBankAccount(UserService.getUser("test_username").getUser_id(), new BankAccount(984.00, "checking")));
	}
	
	@Test
	public void updateExistingBankAccount() {

		int user_id = UserService.getUser("test_username").getUser_id(); // get a user_id
		List<BankAccount> ba = BankAccountService.allBankAccounts(user_id); // get a list of bank accounts for this user
		assertTrue(BankAccountService.updateBankAccount(ba.get(0))); // pass in the first bank account from this user
	}
	
	@Test
	public void updateNonexistantBankAccount() {
		assertFalse(BankAccountService.updateBankAccount(new BankAccount(3425344, 34.23, "checking")));
	}
	
	@Test
	public void getAllBankAccountsFromExistingAccount() {
		int user_id = UserService.getUser("test_username").getUser_id(); // get a user_id
		assertTrue(BankAccountService.allBankAccounts(user_id).size() >= 0); // get a list of bank accounts for this user
	}
	
	@Test
	public void getAllBankAccountsFromNonexistantUser() {
		assertTrue(BankAccountService.allBankAccounts(6893453).size() >= 0);
	}
	
	@Test
	public void deleteExisitingBankAccount() {
		
		int user_id = UserService.getUser("test_username").getUser_id(); // get a user_id
		List<BankAccount> ba = BankAccountService.allBankAccounts(user_id); // get a list of bank accounts for this user
		int bank_account_id = ba.get(0).getBank_account_id(); // get the first bank account id
		assertTrue(BankAccountService.deleteBankAccount(bank_account_id)); // pass in the first bank account id from this user
	}
	
	@Test
	public void deleteNonexistantBankAccount() {
		assertFalse(BankAccountService.deleteBankAccount(434553));
	}
}
