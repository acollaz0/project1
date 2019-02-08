package model;

public class Pizza {
	
	private int pizza_id;
	private String pizza_name;
	
	/**
	 * Constructor used for getting a Pizza from the database
	 * @param pizza_id
	 * @param pizza_name
	 */
	public Pizza(int pizza_id, String pizza_name) {
		super();
		this.pizza_id = pizza_id;
		this.pizza_name = pizza_name;
	}
	
	/**
	 * Constructor used for adding an Pizza to the database.
	 * Lacks a pizza_id parameter because a SQL sequence will generate a new pizza_id.
	 * @param pizza_name
	 */
	public Pizza(String pizza_name) {
		super();
		this.pizza_name = pizza_name;
	}

	/**
	 * @return the pizza_id
	 */
	public int getPizza_id() {
		return pizza_id;
	}
	/**
	 * @param pizza_id the pizza_id to set
	 */
	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}
	/**
	 * @return the pizza_name
	 */
	public String getPizza_name() {
		return pizza_name;
	}
	/**
	 * @param pizza_name the pizza_name to set
	 */
	public void setPizza_name(String pizza_name) {
		this.pizza_name = pizza_name;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return "Pizza [pizza_id=" + pizza_id + ", pizza_name=" + pizza_name + "]";
	}
	
	
}
