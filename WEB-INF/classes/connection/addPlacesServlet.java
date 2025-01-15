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
 * Servlet implementation class addPlacesServlet
 */
@WebServlet("/addPlacesServlet")
public class addPlacesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			
			String location=request.getParameter("location");
			System.out.println(location);
			
			
			String place_name=request.getParameter("place_name");
			System.out.println(place_name);
			
			String category=request.getParameter("category");
			System.out.println(category);
			
			String address=request.getParameter("address");
			System.out.println(address);
			
			//id, location, place_name, category, address
			
			try {
				Connection con=dbcon.getConnection();
				String query="insert into places(location, place_name, category, address) values(?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setString(1,location );
				pst.setString(2,place_name );
				pst.setString(3,category );
				pst.setString(4,address );
				
			int i=pst.executeUpdate();
			if(i>0)
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Place upload sucessfully..');");
				   out.println("location='adminHome.jsp';");
				   out.println("</script>");	
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('Place not uploaded..');");
				   out.println("location='addPlaces.jsp';");
				   out.println("</script>");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
}
