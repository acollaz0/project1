package dao;

import java.util.List;

import model.BankAccount;

// interface for BankAccountDAO methods
public interface IBankAccount {
	
	public boolean addBankAccount(int user_id, BankAccount ba);
	public boolean updateBankAccount(BankAccount ba);
	public boolean deleteBankAccount(int bank_account_id);
	public List<BankAccount> allBankAccounts(int user_id);
	
}
