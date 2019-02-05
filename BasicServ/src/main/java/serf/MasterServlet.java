package serf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public MasterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to the master Servlet");
		response.getWriter().append("Hello welcome to the master Server");
		
		//scon is configurations for a single servlet
		ServletConfig scon = this.getServletConfig();
		String configString = scon.getInitParameter("QuarterBack");
		System.out.println(configString);
		
		//servlet context is where all servlets live and have shared values
		ServletContext scont = this.getServletContext();
		
		String contextstring = scont.getInitParameter("Team");
		System.out.println(contextstring);

		
		if(request.getRequestURI().equals("/BasicServ/subredirect.do")) {
			response.sendRedirect("/BasicServ/SubServlet");
		}
		if(request.getRequestURI().equals("/BasicServ/subforward")) {
			//forward/redirect difference
			RequestDispatcher rd = request.getRequestDispatcher("/SubServlet");
			rd.forward(request, response);
		}
		if(request.getRequestURI().equals("/BasicServ/sess.do")) {
			HttpSession sess = request.getSession();
			sess.setAttribute("name", "brandon");
			System.out.println(sess.getId());
		}
		
	}
	
	//Get is used to retrive information from a server
	//you can use get to send information and it is faster than post
	//but it isless secure and there is a size limit
	
	//Post is used to send information to a server
	//A post will send information in the body of the http request
	//more secure slightly slower
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		if(request.getRequestURI().equals("/BasicServ/hello.do")) {
			String name = request.getParameter("name");
			response.getWriter().append("Welcome " + name + ". Nice to see you!");
			HttpSession sess = request.getSession();
			sess.setAttribute("name", name);
			System.out.println(sess.getId());
			//this will create a small text file client side
			//JavaScript can access these cookies
			Cookie c = new Cookie("Age","19");
			response.addCookie(c);
		}
	}

}
