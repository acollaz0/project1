package dao;

import java.util.List;

import model.Order;
import model.Pizza;

public interface IEmployee {
	public int login(String uname, String ppw);
	public boolean registerEmployee(String uname, String ppw);
	public boolean orderPizza(Order order);
							//0 for public pizza
	public boolean savePizza(int id, Pizza pizza, int price);
	public boolean redeemPoints(int u_id, int o_id);
	public Order viewOrder(int u_id);
	public boolean updateOrder(int u_id);
	public List<Order> ViewOrders(int u_id);
}
