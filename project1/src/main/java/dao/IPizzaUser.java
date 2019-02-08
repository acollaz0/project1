package dao;

import model.PizzaUser;

public interface IPizzaUser {
	
	public PizzaUser getPizzaUser(String username);
	public boolean addPizzaUser(PizzaUser u);
	public boolean updateRewards(int u_id, int rewards);

}
