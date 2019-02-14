package webservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Toppings;
import service.ToppingsService;

public class ToppingsWebService {
	
	public static void getToppings(HttpServletRequest request, HttpServletResponse response) {
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		Toppings t = ToppingsService.getToppings(p_id);
		ObjectMapper om = new ObjectMapper();
		
		
		try {
			String json = om.writeValueAsString(t);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addToppings(HttpServletRequest request, HttpServletResponse response) {
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		int pepperoni = Integer.parseInt(request.getParameter("pepperoni"));
		int i_sausage = Integer.parseInt(request.getParameter("i_sausage"));
		int bacon = Integer.parseInt(request.getParameter("bacon"));
		int ham = Integer.parseInt(request.getParameter("ham"));
		int salami = Integer.parseInt(request.getParameter("salami"));
		int mushrooms = Integer.parseInt(request.getParameter("mushrooms"));
		int b_olives = Integer.parseInt(request.getParameter("b_olives"));
		int b_peppers = Integer.parseInt(request.getParameter("b_peppers"));
		int pineapple = Integer.parseInt(request.getParameter("pineapple"));
		int onions = Integer.parseInt(request.getParameter("onions"));
		int g_peppers = Integer.parseInt(request.getParameter("g_peppers"));
		int feta = Integer.parseInt(request.getParameter("feta"));
		int spinach = Integer.parseInt(request.getParameter("spinach"));
		Toppings t = new Toppings(0,p_id,pepperoni,i_sausage,bacon,ham,salami,mushrooms,b_olives,b_peppers,pineapple,onions,g_peppers,feta,spinach);
		
		if(ToppingsService.addToppings(t)) {
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
