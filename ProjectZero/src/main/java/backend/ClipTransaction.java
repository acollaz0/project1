package backend;

import java.util.Date;

public class ClipTransaction {
	
	private String userid;
	private String clipboxid;
	private int transnum;
	private int amount; //negative for withdrawl, positive for deposit
	private int result; //the final amount in the account after the transaction
	private Date date;
	public ClipTransaction(String userid, String clipboxid, int transnum, int amount, int result, Date date) {
		super();
		this.userid = userid;
		this.clipboxid = clipboxid;
		this.transnum = transnum;
		this.amount = amount;
		this.result = result;
		this.date = date;
	}
	
}
