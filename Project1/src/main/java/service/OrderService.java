package service;

import java.util.List;

import dao.OrderDAO;
import model.Order;

public class OrderService {
	
	private static OrderDAO od = new OrderDAO();
	
	/**
	 * getOrder method
	 * Returns an Order from the database if the given order_id is found
	 * @param order_id The order_id of the order you want to retrieve from the database
	 * @return An Order if the given order_id is found, else null
	 */
	public static Order getOrder(int order_id) {
		
		Order o = od.getOrder(order_id);
		return o;
	}
	
	/**
	 * addOrder method
	 * Adds an Order to the database
	 * @param o The Order to add to the database
	 * @return true if the Order was successfully added, else false
	 */
	public static boolean addOrder(int user_id, Order o) {
		
		return od.addOrder(user_id, o);
	}
	
	/**
	 * updateOrder method
	 * Updates an Order's status and saved state
	 * @param The Order to update
	 * @return true if an Order was actually updated, else false
	 */
	public static boolean updateOrder(Order o) {
		
		return od.updateOrder(o);
	}
	
	/**
	 * allActiveOrders method
	 * @return All orders that are active/ not complete
	 */
	public static List<Order> allActiveOrders() {
		
		return od.allActiveOrders();
	}
	
	/**
	 * allOrdersPerUser method
	 * @param user_id The user id for a user
	 * @return All orders for a given user
	 */
	public static List<Order> allOrdersPerUser(int user_id) {
		
		return od.allOrdersPerUser(user_id);
	}
	
	/**
	 * allSavedOrdersPerUser method
	 * @param user_id The user id for a user
	 * @return All orders for a given user that are saved
	 */
	public static List<Order> allSavedOrdersPerUser(int user_id) {
		
		return od.allSavedOrdersPerUser(user_id);
	}
}
