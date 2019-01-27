package model;

public class Transaction {
	
	private int t_id;
	private String change;
	private int total;
	private String datetime;
	private int a_id;
	
	
	
	@Override
	public String toString() {
		return "Transaction [t_id=" + t_id + ", change=" + change + ", total=" + total + ", datetime=" + datetime
				+ ", a_id=" + a_id + "]";
	}

	public Transaction() {
		super();
	}

	public Transaction(int t_id, String change, int total, String datetime, int a_id) {
		super();
		this.t_id = t_id;
		this.change = change;
		this.total = total;
		this.datetime = datetime;
		this.a_id = a_id;
	}

	public int getT_id() {
		return t_id;
	}

	public String getChange() {
		return change;
	}

	public int getTotal() {
		return total;
	}

	public String getDatetime() {
		return datetime;
	}

	public int getA_id() {
		return a_id;
	}


}
