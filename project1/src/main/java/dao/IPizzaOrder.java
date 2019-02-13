package dao;

import java.util.List;

import model.PizzaOrder;

public interface IPizzaOrder {
	
	public PizzaOrder getOrder(int u_id);
	public List<PizzaOrder> allOrders();
	public boolean addOrder(PizzaOrder p);
	public boolean saveOrder(int o_id);
	public boolean updateStatus(int o_id, String status);
	
	

}
