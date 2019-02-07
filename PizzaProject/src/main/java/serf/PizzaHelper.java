package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaHelper {
	public static void process(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		switch (uri) {
		case "PizzaProject/stats.do":{
			break;
		}
		case "PizzaProject/addOrder.do":{
			break;
		}
		}
	}
}
