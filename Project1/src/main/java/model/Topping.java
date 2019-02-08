package model;

public class Topping {
	
	private int topping_id;
	private String topping_name;

	/**
	 * Constructor used for getting a Topping from the database
	 * @param topping_id
	 * @param topping_name
	 */
	public Topping(int topping_id, String topping_name) {
		super();
		this.topping_id = topping_id;
		this.topping_name = topping_name;
	}
	
	/**
	 * Constructor used for adding an Topping to the database.
	 * Lacks a topping_id parameter because a SQL sequence will generate a new topping_id.
	 * @param topping_name
	 */
	public Topping(String topping_name) {
		super();
		this.topping_name = topping_name;
	}

	/**
	 * @return the topping_id
	 */
	public int getTopping_id() {
		return topping_id;
	}
	/**
	 * @param topping_id the topping_id to set
	 */
	public void setTopping_id(int topping_id) {
		this.topping_id = topping_id;
	}
	/**
	 * @return the topping_name
	 */
	public String getTopping_name() {
		return topping_name;
	}
	/**
	 * @param topping_name the topping_name to set
	 */
	public void setTopping_name(String topping_name) {
		this.topping_name = topping_name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Topping [topping_id=" + topping_id + ", topping_name=" + topping_name + "]";
	}
	
}
