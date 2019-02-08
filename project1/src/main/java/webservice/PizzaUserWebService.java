package webservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.PizzaUser;
import service.PizzaUserService;




public class PizzaUserWebService {
	
	public static void getPizzaUser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		PizzaUser p = PizzaUserService.getPizzaUser(username);
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			String json = om.writeValueAsString(p);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addPizzaUser(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PizzaUser p = new PizzaUser(0, username, password, 0, 0);
		PizzaUserService.addPizzaUser(p);
		
		try {
			response.getWriter().append("PizzaUser added to database");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
