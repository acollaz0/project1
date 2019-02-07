package dao;

import java.util.List;

import model.Order;

//interface for OrderDAO methods
public interface IOrder {
	
	public Order getOrder(int order_id);
	public boolean addOrder(int user_id, Order o);
	public boolean updateOrder(Order o);
	public List<Order> allActiveOrders();
	public List<Order> allOrdersPerUser(int user_id);
	public List<Order> allSavedOrdersPerUser(int user_id);
}
