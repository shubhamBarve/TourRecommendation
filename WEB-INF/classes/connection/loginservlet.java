package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dbconnection.dbcon;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		
	    PrintWriter out = response.getWriter();  
	          
	    String email=request.getParameter("email");  
	    System.out.println(email);
	    String password=request.getParameter("password");  
	    System.out.println(password);
	    try {
	    	Connection con=dbcon.getConnection();
	    	PreparedStatement ps=con.prepareStatement("select * from registration where email=? and password=?" );
	    	ps.setString(1, email);
	    	ps.setString(2, password);
	    	ResultSet rs=ps.executeQuery();
	    	rs.next();
	    	
	    	HttpSession session=request.getSession();
	    	session.setAttribute("email", email);
	    	
	    	if("email"!="" && "password"!="")
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('you are login sucessfully..');");
				out.println("location='homepage.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('invalid information..');");
				out.println("location='registration.jsp';");
				out.println("</script>");
			}
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	          
	    out.close();  
	    }  
	}

