package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Pizza;
import service.PizzaService;

public class PizzaWebService {
	
	public static void getPizzas(HttpServletRequest request, HttpServletResponse response) {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		List<Pizza> pizzas = PizzaService.getPizzas(o_id);
		ObjectMapper om = new ObjectMapper();
		
		try {
			String json = om.writeValueAsString(pizzas);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void allPizzas(HttpServletRequest request, HttpServletResponse response) {
		List<Pizza> pizzas = PizzaService.allPizzas();
		ObjectMapper om = new ObjectMapper();
		try {
			String json = om.writeValueAsString(pizzas);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addPizza(HttpServletRequest request, HttpServletResponse response) {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		String p_size = request.getParameter("p_size");
		String crust = request.getParameter("crust");
		String sauce = request.getParameter("sauce");
		Pizza p = new Pizza(0,o_id,p_size,crust,sauce);
		
		if(PizzaService.addPizza(p)) {
			try {
				response.getWriter().append("1").close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				response.getWriter().append("0").close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
