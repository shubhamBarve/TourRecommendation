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
 * Servlet implementation class socialloginServlet
 */
@WebServlet("/socialloginServlet")
public class socialloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	    	
	    	if("email"!="" && "password"!="")
			{
	    		 HttpSession session=request.getSession();
					String name=rs.getString("name");
	    		 
					session.setAttribute("sessionmail",email);

					session.setAttribute("sessionname",name);
	    		
	    		
				out.println("<script type=\"text/javascript\">");
				out.println("alert('you are login sucessfully..');");
				out.println("location='home.jsp';");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('invalid information..');");
				out.println("location='socialmediaregistration.jsp';");
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
