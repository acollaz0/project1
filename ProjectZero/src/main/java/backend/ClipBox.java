package backend;

import java.util.HashMap;
import java.util.Map;

public class ClipBox {
	
	/**
	 * list of instantiated clipboxes
	 */
	private static Map<String,ClipBox> extantboxes = new HashMap<>(); //
	private String clipboxID;
	private int balance;
	private static ClipBankDao dao = null;
	private String username;
	
	private ClipBox(String clipboxID) {
		super();
		try {
			if (ClipBox.dao==null) {
				ClipBox.dao = RDSClipBankDB.getRDSClipBankDB();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.clipboxID = clipboxID;
		this.balance = ClipBox.dao.getBalance(clipboxID);
		this.username = ClipBox.dao.getClipBoxUserName(clipboxID);
		extantboxes.put(clipboxID, this);
	}
	
	public static ClipBox getClipBox(String clipboxID) {
		if (extantboxes.containsKey(clipboxID)) {
			return extantboxes.get(clipboxID);
		} else {
			return new ClipBox(clipboxID);
		}
	}

	public String getClipboxID() {
		return this.clipboxID;
	}

	public int getBalance() {
		return ClipBox.dao.getBalance(this);
	}
	
	public int withdraw(int withdrawl) {
		
		int result = ClipBox.dao.withdraw(withdrawl, this);
		this.balance = ClipBox.dao.getBalance(this);
		return result;
	}
	
	public int deposit(int deposition) {
		int result = ClipBox.dao.deposit(deposition, this);
		this.balance = ClipBox.dao.getBalance(this);
		return result;
	}

	public static ClipBox createNewClipBox(String _username) {
		
		try {
			if (ClipBox.dao==null) {
				ClipBox.dao = RDSClipBankDB.getRDSClipBankDB();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ClipBox c = ClipBox.dao.createClipBox(_username);
		
		return c;
	}
	
	public boolean delete() {
		
		boolean status = ClipBox.dao.deleteClipBox(this);
		
		if (status == true) {
			ClipBox.extantboxes.remove(this.getClipboxID());
		}
		return status;//only returns false if there is an SQLException
	}


}
