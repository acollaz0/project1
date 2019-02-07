package webservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;
import service.UserService;

public class UserWeb {

public static void getUser(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = UserService.getUser(username,password);
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			String json = om.writeValueAsString(u);
			response.getWriter().append(json).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
