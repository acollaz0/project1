package service;

import dao.PizzaUserDAO;
import model.PizzaUser;

public class PizzaUserService {
	
	public static PizzaUserDAO pud = new PizzaUserDAO();
	
	public static PizzaUser getPizzaUser(String username) {
		PizzaUser u = pud.getPizzaUser(username);
		return u;
	}
	
	public static boolean addPizzaUser(PizzaUser u) {
		return pud.addPizzaUser(u);
	}
	
	public static boolean updateRewards(int u_id, int rewards) {
		return pud.updateRewards(u_id, rewards);
	}

}
