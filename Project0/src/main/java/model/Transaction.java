package model;

public class Transaction {

	private int t_id;
	private int acc_num;
	private int t_amount;
	private String mag;
	
	public Transaction() {
		super();
	}
	public Transaction(int t_id,int acc_num,int t_amount,String mag) {
		this.t_id=t_id;
		this.acc_num=acc_num;
		this.t_amount=t_amount;	
		this.mag=mag;
	}
}
