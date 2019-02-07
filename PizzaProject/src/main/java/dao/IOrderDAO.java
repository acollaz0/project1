package dao;

import java.util.List;

import model.Item;
import model.Order;

public interface IOrderDAO {
	public boolean addOrder(List<Item> items, String username);
	public List<Order> getOrders();
	public List<Order> getOrders(String username);
	public Order getOrder(String orderID);
	public boolean isOrder(String orderID);
	
}
