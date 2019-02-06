package webservice;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Player;
import service.PlayerService;

public class PlayerWebService {
	
	public static void getPlayer(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		Player p = PlayerService.getPlayer(id);
//		System.out.println(id);
		ObjectMapper om = new ObjectMapper();
		try {
			
			response.getWriter().append(om.writeValueAsString(p)).close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addPlayer(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String team = request.getParameter("team");
		Player p = new Player(id,name,team);
		PlayerService.addPlayer(p);
		try {
			response.getWriter().append(name + " was added to the database.").close();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
}
