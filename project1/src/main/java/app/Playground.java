package app;

import model.PizzaUser;
import service.PizzaUserService;

public class Playground {

	public static void main(String[] args) {
		
		PizzaUser p = PizzaUserService.getPizzaUser("test");
		System.out.println(p.toString());

	}

}
