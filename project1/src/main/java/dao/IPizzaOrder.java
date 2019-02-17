package dao;

import java.util.List;

import model.PizzaOrder;

public interface IPizzaOrder {
	
	public List<PizzaOrder> getOrder(int u_id);
	public List<PizzaOrder> allOrders();
	public List<PizzaOrder> activeOrders();
	public boolean addOrder(PizzaOrder p);
	public boolean saveOrder(int o_id);
	public boolean updateStatus(int o_id, String status);
	
	

}
