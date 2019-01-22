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
	private ClipBankDao dao;
	private String username;
	
	private ClipBox(String clipboxID, int balance, String username) {
		super();
		this.dao = dao;
		this.clipboxID = clipboxID;
		this.balance = balance;
		this.username = username;
		extantboxes.put(clipboxID, this);
	}
	
	public static ClipBox getClipBox(String clipboxID, int balance, String username) {
		if (extantboxes.containsKey(clipboxID)) {
			return extantboxes.get(clipboxID);
		} else {
			return new ClipBox(clipboxID, balance, username);
		}
	}

	public String getClipboxID() {
		return clipboxID;
	}

	public int getBalance() {
		return balance;
	}


}
