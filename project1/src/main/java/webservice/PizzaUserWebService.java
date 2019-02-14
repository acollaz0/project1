package webservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.PizzaUser;
import service.PizzaUserService;




public class PizzaUserWebService {
	
	public static void getPizzaUser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		PizzaUser p = PizzaUserService.getPizzaUser(username);
		
		ObjectMapper om = new ObjectMapper();
		if(p != null) {
			HttpSession sess = request.getSession();
			sess.setAttribute("u_id", p.getU_id());
			sess.setAttribute("username", p.getUsername());
			sess.setAttribute("password", p.getPassword());
			sess.setAttribute("rewards", p.getRewards());
			sess.setAttribute("employee", p.getEmployee());
		}
		
		try {
			String json = om.writeValueAsString(p);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sess = request.getSession();
		int id = (int) sess.getAttribute("u_id");
		String username = (String) sess.getAttribute("username");
		String password = (String) sess.getAttribute("password");
		int rewards = (int) sess.getAttribute("rewards");
		int employee = (int) sess.getAttribute("employee");
		PizzaUser p = new PizzaUser(id, username, password, rewards, employee);
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
		if(PizzaUserService.addPizzaUser(p)) {
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
