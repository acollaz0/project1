package serf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.PlayerWebService;

public class RequestHelper {
	
	public static void Process(HttpServletRequest request, HttpServletResponse response) {
		
		String uri = request.getRequestURI();
		
		switch(uri) {
		
		case "/BBallApp/getPlayer.do":{PlayerWebService.getPlayer(request, response);break;}
		case "/BBallApp/addPlayer.do":{PlayerWebService.addPlayer(request, response);break;}
		
		}
		
		
	}

}
