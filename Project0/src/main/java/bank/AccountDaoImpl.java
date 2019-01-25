package bank;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
	
	List<Account> accounts;

	@Override
	public List<Account> getAllAccounts() {
		return accounts;
	}

	@Override
	public void withdrawAccount(Account acc, double withdraw) {
		// take parameter account and check if value - withdraw >= 0
		//update acc.value and find it in accounts
		//then replace the account in accounts and update the database
		//add change to acc.transactions
		
	}

	@Override
	public void depositAccount(Account acc, double deposit) {
		//take acc and add acc.value = acc.value + deposit
		//add change to acc.transactions
		//make sure deposit is a positive value
		//find acc in accounts and update database
		
	}

	@Override
	public void deleteAccount(Account acc) {
		//check if acc.value is equal to 0
		//remove acc from accounts
		//update database
		
		
		
	}

	@Override
	public void addAccount(Account acc) {
		//add acc to accounts
		//update database
		
	}

	

}
