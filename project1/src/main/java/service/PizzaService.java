package service;

import java.util.List;

import dao.PizzaDAO;
import model.Pizza;

public class PizzaService {
	
	public static PizzaDAO pd = new PizzaDAO();
	
	public static List<Pizza> getPizzas(int o_id){
		return pd.getPizzas(o_id);
	}
	
	public static boolean addPizza(Pizza p) {
		return pd.addPizza(p);
	}

}
