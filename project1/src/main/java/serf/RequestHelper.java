package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.PizzaOrderWebService;
import webservice.PizzaUserWebService;
import webservice.PizzaWebService;
import webservice.ToppingsWebService;



public class RequestHelper {

public static void Process(HttpServletRequest request, HttpServletResponse response) {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		
		case "/project1/getPizzaUser.do":{PizzaUserWebService.getPizzaUser(request, response); break;}
		case "/project1/addPizzaUser.do":{PizzaUserWebService.addPizzaUser(request, response); break;}
		case "/project1/getSession.do":{PizzaUserWebService.getSession(request, response); break;}
		case "/project1/getPizzaOrder.do":{PizzaOrderWebService.getPizzaOrder(request, response); break;}
		case "/project1/allOrders.do":{PizzaOrderWebService.allOrders(request, response); break;}
		case "/project1/addOrder.do":{PizzaOrderWebService.addOrder(request, response); break;}
		case "/project1/saveOrder.do":{PizzaOrderWebService.saveOrder(request, response); break;}
		case "/project1/updateStatus.do":{PizzaOrderWebService.updateStatus(request, response); break;}
		case "/project1/addPizza.do":{PizzaWebService.addPizza(request, response); break;}
		case "/project1/getPizzas.do":{PizzaWebService.getPizzas(request, response); break;}
		case "/project1/getToppings.do":{ToppingsWebService.getToppings(request, response); break;}
		case "/project1/addToppings.do":{ToppingsWebService.addToppings(request, response); break;}
		
		}
	}
}
