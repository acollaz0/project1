package dao;

import java.util.List;

import model.Toppings;

public interface IToppings {
	
	public Toppings getToppings(int p_id);
	public boolean addToppings(Toppings t);
	public List<Toppings> allToppings();

}
