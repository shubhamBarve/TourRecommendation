package connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnection.dbcon;

/**
 * Servlet implementation class addShoppingStreet
 */
@WebServlet("/addShoppingStreet")
public class addShoppingStreet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			String location=request.getParameter("location");
			System.out.println(location);
			
			String street_name=request.getParameter("street_name");
			System.out.println(street_name);
			
			String address=request.getParameter("address");
			System.out.println(address);
			
			String category=request.getParameter("category");
			System.out.println(category);
			
			//id, location, place_name, category, address
			
			try {
				Connection con=dbcon.getConnection();
				String query="insert into shopping_street(location, street_name, address, category) values(?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,location );
				pst.setString(2, street_name );
				pst.setString(3,address );
				pst.setString(4,category);
				
			int i=pst.executeUpdate();
			if(i>0)
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Shopping street upload sucessfully..');");
				   out.println("location='adminHome.jsp';");
				   out.println("</script>");	
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Shopping street not uploaded..');");
				   out.println("location='addShoppingStreet.jsp';");
				   out.println("</script>");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

    	}
