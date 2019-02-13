package webservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.PizzaOrder;
import service.PizzaOrderService;

public class PizzaOrderWebService {
	
	public static void getPizzaOrder(HttpServletRequest request, HttpServletResponse response) {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		PizzaOrder o = PizzaOrderService.getOrder(u_id);
		ObjectMapper om = new ObjectMapper();
		
		if(o != null) {
			HttpSession sess = request.getSession();
			sess.setAttribute("o_id", o.getO_id());
			sess.setAttribute("u_id", o.getU_id());
			sess.setAttribute("total", o.getTotal());
			sess.setAttribute("status", o.getStatus());
			sess.setAttribute("datetime", o.getDatetime());
			sess.setAttribute("saved", o.getSaved());
		}
		
		try {
			String json = om.writeValueAsString(o);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
