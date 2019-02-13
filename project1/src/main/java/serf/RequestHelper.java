package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.PizzaOrderWebService;
import webservice.PizzaUserWebService;



public class RequestHelper {

public static void Process(HttpServletRequest request, HttpServletResponse response) {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		
		case "/project1/getPizzaUser.do":{PizzaUserWebService.getPizzaUser(request, response); break;}
		case "/project1/addPizzaUser.do":{PizzaUserWebService.addPizzaUser(request, response); break;}
		case "/project1/getSession.do":{PizzaUserWebService.getSession(request, response); break;}
		case "/project1/getPizzaOrder.do":{PizzaOrderWebService.getPizzaOrder(request, response); break;}
		}
	}
}
