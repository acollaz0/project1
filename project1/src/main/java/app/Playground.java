package app;

import model.PizzaUser;
import service.PizzaUserService;

public class Playground {

	public static void main(String[] args) {
		
		PizzaUser p = new PizzaUser(0, "test1", "test", 0, 0);
		PizzaUserService.addPizzaUser(p);

	}

}
