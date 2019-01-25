package bank;

import java.util.List;

public interface AccountDao {

	public List<Account> getAllAccounts();
	public void withdrawAccount(Account acc, double withdraw);
	public void depositAccount(Account acc, double deposit);
	public void deleteAccount(Account acc);
	public void addAccount(Account acc);
	
}
