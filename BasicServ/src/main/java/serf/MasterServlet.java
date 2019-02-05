package serf;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MasterServlet
 */
@WebServlet("/MasterServlet")
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
		// GET is used to retrieve information from a server
		// Can use GET to send information to server, but it is less secure and there is a size limit
		
		System.out.println("Master Servlet called.");
		response.getWriter().append("Hello, welcome to the master servlet.");
		
		//Servlet config is configurations for a single servlet.
		ServletConfig scon = this.getServletConfig();
		String configstr = scon.getInitParameter("Quarterback");
		
		//The servlet context is where all servlets live and can share values or configurations.
		ServletContext stxt = this.getServletContext();
		String contextstring = stxt.getInitParameter("team"); //Will return "Mountaineers" from web.xml
		
		if (request.getRequestURI().equals("/BasicServ/subredirect.do")) {
			//Changes the actuall url on the webpage. Acts like a link?
			System.out.println("Imma doin a redirect!");
			response.sendRedirect("/BasicServ/subServ");
		}
		if (request.getRequestURI().equals("/BasicServ/subforward.do")) {
//			retrieves the info from subServ, but doesn't change the url in the browser.
			System.out.println("Imma doin a forward! " + contextstring + " " + configstr);
			RequestDispatcher rd = request.getRequestDispatcher("/subServ");
			
			rd.forward(request, response);
		}
		
		
		//SESSIONS:a way to maintain user experience on the server side
		if (request.getRequestURI().equals("/BasicServ/sesh.do")) {
			String name = request.getParameter("name");
			HttpSession sesh = request.getSession();
			sesh.setAttribute("name", name);
			System.out.println(sesh.getId());
			RequestDispatcher rd = request.getRequestDispatcher("/subServ");
			rd.forward(request, response);
			
			//This will create a small text file client side 
			//Javascript can access these cookies.
			Cookie c = new Cookie("make","Ford");
			response.addCookie(c);
			
			//Often use cookies and sessions together.
			//cookies should never have any sensitive info stored in them
			//Any site can read from the cookies on your browser.
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST is send to send information to a server
		//A POST will send info in the body of the http request. More secure, slightly slower
//		response.getWriter().append("Served at: ").append(request.getContextPath() + " POST.");
		
		if (request.getRequestURI().equals("/BasicServ/hello.do")) {
			
			String name = request.getParameter("name");
			response.getWriter().append("Welcome " + name).close();;
			
//			HttpSession sesh = request.getSession();
//			sesh.setAttribute("name", name);
//			System.out.println(sesh.getId());
//			System.out.println(sesh.getCreationTime());
			
		}
		
	}

}
