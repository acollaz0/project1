package models;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

//Just a data storage class. Doesn't actually do anything, and can only be created by ClipBox objects
public class Transaction {
	
	private ClipBox box;
	private String t_id;
	private int value;
	private Date date;
	private int finalbalance;
	
	
	public Transaction(ClipBox box, String t_id, int value, int finalbalance, Date date) {
		super();
		this.box = box;
		this.t_id = t_id;
		this.value = value;
		this.date = date;
		this.finalbalance = finalbalance;
	}

	public Date getDate() {
		return this.date;
	}
	
	public ClipBox getBox() {
		return box;
	}


	public String getT_id() {
		return t_id;
	}


	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		return String.format("| %14s | %20d | %20d | %12s | %30s |",
				this.t_id,
				this.value,
				this.finalbalance,
				this.box.getCb_id(),
				simpleDateFormat.format(this.date));
	}
	

}
