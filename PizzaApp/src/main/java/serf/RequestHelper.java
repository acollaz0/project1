package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;;

public class RequestHelper {
	public static void process(HttpServletRequest request, HttpServletResponse response) {
		String uri = request.getRequestURI();
		switch (uri) {
		case "orderPizza.do":{UserService.doThing();}
		break;
		
		}
	}
}
