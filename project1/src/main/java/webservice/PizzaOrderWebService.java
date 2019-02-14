package webservice;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	public static void allOrders(HttpServletRequest request, HttpServletResponse response) {
		List<PizzaOrder> orders = new ArrayList<>();
		orders = PizzaOrderService.allOrders();
		ObjectMapper om = new ObjectMapper();
		
		try {
			String json = om.writeValueAsString(orders);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void addOrder(HttpServletRequest request, HttpServletResponse response) {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		int total = Integer.parseInt(request.getParameter("total"));
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
		String datetime = df.format(date);
		PizzaOrder o = new PizzaOrder(0,u_id,total,"Pending",datetime,0);
		
		if(PizzaOrderService.addOrder(o)) {
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
	
	public static void saveOrder(HttpServletRequest request, HttpServletResponse response) {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		
		if(PizzaOrderService.saveOrder(o_id)) {
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

	public static void updateStatus(HttpServletRequest request, HttpServletResponse response) {
		int o_id = Integer.parseInt(request.getParameter("o_id"));
		String status = request.getParameter("status");
		
		if(PizzaOrderService.updateStatus(o_id, status)) {
			try {
				response.getWriter().append("1").close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
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
