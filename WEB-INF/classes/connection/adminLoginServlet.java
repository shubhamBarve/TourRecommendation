package connection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class adminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String email=request.getParameter("email");  
	    System.out.println(email);
	    String password=request.getParameter("password");  
	    System.out.println(password);
	    try {
	    	
	  
	    	 if (email.equals("admin@gmail.com") && password.equals("Admin@123")) {
	             response.sendRedirect("adminHome.jsp");
	             HttpSession session=request.getSession();
	             session.setAttribute("adminemail", email);
	             return;
	         } else {
	             response.sendRedirect("adminlogin.jsp");
	             return;
	         }
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}

}
