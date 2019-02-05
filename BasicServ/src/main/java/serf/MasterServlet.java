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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Master Servlet");
		response.getWriter().append("Welcome to the Master Servlet");
		
		//Servlet Configuration is configurations for a single servlet
		ServletConfig scon = this.getServletConfig();
		
		String configstring = scon.getInitParameter("Quarterback");
		System.out.println(configstring);
		
		//Servlet Context is where all servlets live and can share values
		//or configurations
		ServletContext sconxt = this.getServletContext();
		
		String contextstring = sconxt.getInitParameter("Team");
		System.out.println(contextstring);
		
		
		
		//This is redirecting the request
		//this is a 300 http status code
		if(request.getRequestURI().equals("/BasicServ/subredirect.do")) {
			response.sendRedirect("/BasicServ/SubServlet");
		}
		
		//Forward requires the RequestDispatcher
		if(request.getRequestURI().equals("/BasicServ/subforward.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("/SubServlet");
			rd.forward(request, response);
		}
		
		//sessions are a way to maintain the user 'session experience'
		//server side
		if(request.getRequestURI().equals("/BasicServ/sess.do")) {
			HttpSession sess = request.getSession();
			sess.setAttribute("name", "Adam");
			System.out.println(sess.getId());
			
			//this will create a small text file client side
			//JavaScript can access these cookies
			Cookie c = new Cookie("Age", "19");
			response.addCookie(c);
			
			RequestDispatcher rd = request.getRequestDispatcher("/SubServlet");
			rd.forward(request, response);
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//get is used to retrieve information from a server
		//you can use get to send information, and it is faster than post,
		//but it is less secure and there is a size limit
		
		//post is used to send information to a server
		//post will send information in the body of the http request
		//more secure slightly slower
		if(request.getRequestURI().equals("/BasicServ/hello.do")) {
			
			String name = request.getParameter("name");
			response.getWriter().append("Welcome "+name+" nice to see you").close();
		}
		
		
	}

}
