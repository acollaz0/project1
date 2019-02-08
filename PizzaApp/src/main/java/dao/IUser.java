package dao;

import java.util.List;

import model.Order;
import model.Pizza;

public interface IUser {
	public int login(String uname, String pass);
	public boolean registerUser(String uname, String pass);
	public boolean orderPizza(Order order);
	public boolean savePizza(int u_id, Pizza pizza);
	public boolean redeemPoints(int u_id, int o_id);
	public Order viewOrder(int u_id);
	public List<Order> ViewOrders(int u_id);
}
