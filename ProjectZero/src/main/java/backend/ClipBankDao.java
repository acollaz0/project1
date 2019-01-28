package backend;

import java.sql.SQLException;
import java.util.List;

/**
 * @author tbnil
 * An interface for any class which manages a paperclip storage database. Will be the Database Action Object
 * Any class that implements this should be a singleton. I think?
 * Note: A clip box is just another name for a bank account.
 */
public interface ClipBankDao {
	
	//User account methods
	/**
	 * @param username
	 * @param password
	 * Creates a new user-password pair in the USERS table
	 * Also creates an empty clipbox under the new username in the CLIPBOXES table
	 */
	public boolean createUser(String username, String password);
	public ClipBox createClipBox(String username);
	public boolean hasAccount(String username);
	public boolean validate(String username, String password);
	public boolean isSuperUser(String username);
	
	//Other?
	public List<ClipTransaction> getTransactions(String username);
	public boolean exists(String table, String column, String value);
	
	//ClipBox related methods
	public List<ClipBox> getClipBoxes(String username);
	/**
	 * @param boxID
	 * @return the number of clips in the referenced Clip Box
	 */
	public int getBalance(String boxID);
	//public ClipBox getClipBox(String boxID);
	/**
	 * @param 	value amount to withdraw
	 * @param 	box	box to withdraw from
	 * @return 	Will either return the new balance of box, or -1 if there was an SQLException
	 */
	public int withdraw(int value, ClipBox box);
	/**
	 * @param value 	amount to deposit
	 * @param box		box to deposit into
	 * @return			Will either return the new balance of box, or -1 if there was an SQLException
	 */
	public int deposit(int value, ClipBox box); 
	public int getBalance(ClipBox box);
	//public ClipBox createClipBox(ClipBankUser user);
	//public ClipBox createClipBox(String username);
	public boolean deleteClipBox(ClipBox box); //the clipbox must be empty for this to execute and return true
	
	public void closeConnection();
	public String getClipBoxUserName(String clipboxID);
	public boolean userExists(String username);
	public boolean recordTransaction(ClipBox box, int value);
	

}
