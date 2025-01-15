package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dbconnection.dbcon;


/**
 * Servlet implementation class postcontroller
 */
@WebServlet("/postcontroller")
public class postcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd=null;  
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 
		 HttpSession session=request.getSession();
		 String name=(String) session.getAttribute("sessionname");
		 String email=(String) session.getAttribute("sessionmail");
		 
		String status=request.getParameter("status");
		
		 
		 
		 System.out.println(name);
		 System.out.println(email);
		 System.out.println(status);
		 
		 try {
				Connection con = dbcon.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into post(name, email, status) values (?,?,?)");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, status);
				
				int i=ps.executeUpdate();
				if(i>0)
		 {
			    System.out.println("Status posted successfully");
				request.setAttribute("SucMsg1", "status posted successfully...");
				rd=request.getRequestDispatcher("post.jsp");
				rd.forward(request, response);
		 }
		 
		 else
		 {
			    System.out.println("Status not posted");
			    request.setAttribute("ErrMsg1", "status not posted...");
				rd=request.getRequestDispatcher("post.jsp");
				rd.forward(request, response);
		 }
		 }
		  catch (Exception e) 
		 {
				e.printStackTrace();
			}
	}

}
