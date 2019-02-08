package model;

public class Order {
	
	private int order_id;
	private double cost;
	private long time_ordered;
	private String status;
	private String order_type;
	private int saved;
	
	/**
	 * Constructor used for getting an Order from the database
	 * @param cost
	 * @param time_ordered
	 * @param status
	 * @param order_type
	 * @param saved
	 */
	public Order(int order_id, double cost, long time_ordered, String status, String order_type, int saved) {
		super();
		this.order_id = order_id;
		this.cost = cost;
		this.time_ordered = time_ordered;
		this.status = status;
		this.order_type = order_type;
		this.saved = saved;
	}	
	
	/**
	 * Constructor used for adding an Order to the database.
	 * Lacks an order_id parameter because a SQL sequence will generate a new order_id.
	 * @param order_id
	 * @param cost
	 * @param time_ordered
	 * @param status
	 * @param order_type
	 * @param saved
	 */
	public Order(double cost, long time_ordered, String status, String order_type, int saved) {
		super();
		this.cost = cost;
		this.time_ordered = time_ordered;
		this.status = status;
		this.order_type = order_type;
		this.saved = saved;
	}

	/**
	 * @return the order_id
	 */
	public int getOrder_id() {
		return order_id;
	}
	/**
	 * @param order_id the order_id to set
	 */
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the time_ordered
	 */
	public long getTime_ordered() {
		return time_ordered;
	}
	/**
	 * @param time_ordered the time_ordered to set
	 */
	public void setTime_ordered(long time_ordered) {
		this.time_ordered = time_ordered;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the order_type
	 */
	public String getOrder_type() {
		return order_type;
	}
	/**
	 * @param order_type the order_type to set
	 */
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	/**
	 * @return the saved
	 */
	public int getSaved() {
		return saved;
	}
	/**
	 * @param saved the saved to set
	 */
	public void setSaved(int saved) {
		this.saved = saved;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", cost=" + cost + ", time_ordered=" + time_ordered + ", status="
				+ status + ", order_type=" + order_type + ", saved=" + saved + "]";
	}
	
	
}
