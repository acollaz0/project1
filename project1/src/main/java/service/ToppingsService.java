package service;

import dao.ToppingsDAO;
import model.Toppings;

public class ToppingsService {
	public static ToppingsDAO td = new ToppingsDAO();
	
	public static Toppings getToppings(int p_id) {
		return td.getToppings(p_id);
	}
	
	public static boolean addToppings(Toppings t) {
		return td.addToppings(t);
	}
	

}
