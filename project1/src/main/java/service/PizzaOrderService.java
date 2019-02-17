package service;

import java.util.List;

import dao.PizzaOrderDAO;
import model.PizzaOrder;

public class PizzaOrderService {
	
	public static PizzaOrderDAO pod = new PizzaOrderDAO();
	
	public static List<PizzaOrder> activeOrders(){
		return pod.activeOrders();
	}
	
	public static List<PizzaOrder> getOrder(int u_id) {
		return pod.getOrder(u_id);
	}
	
	public static List<PizzaOrder> allOrders(){
		return pod.allOrders();
	}
	
	public static boolean addOrder(PizzaOrder p) {
		return pod.addOrder(p);
	}
	
	public static boolean saveOrder(int o_id) {
		return pod.saveOrder(o_id);
	}
	
	public static boolean updateStatus(int o_id, String status) {
		return pod.updateStatus(o_id, status);
	}

}
