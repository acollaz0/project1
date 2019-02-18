package dao;

import java.util.List;

import model.Pizza;

public interface IPizza {
	public List<Pizza> getPizzas(int o_id);
	public boolean addPizza(Pizza p);
	public List<Pizza> allPizzas();
	
	

}
