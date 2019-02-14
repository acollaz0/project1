package dao;

import model.Toppings;

public interface IToppings {
	
	public Toppings getToppings(int p_id);
	public boolean addToppings(Toppings t);

}
