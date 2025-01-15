package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dbconnection.dbcon;


@WebServlet("/registerservlet")
public class registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		System.out.println(name);
		String number = request.getParameter("number");
		System.out.println(number);
		String address = request.getParameter("address");
		System.out.println(address);
		String email= request.getParameter("email");
		System.out.println(email);
		String password = request.getParameter("password");
		System.out.println(password);
	
		try {
			Connection con =dbcon.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from registration where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(!rs.next())
			{
				PreparedStatement ps1 = con.prepareStatement("insert into registration(name, number,address, email,password) values(?,?,?,?,?)");
				ps1.setString(1, name);
				ps1.setString(2, number);
				ps1.setString(3, address);
				ps1.setString(4, email);
				ps1.setString(5, password);
				
				System.out.println("name"+name);
				System.out.println("number"+number);
				System.out.println("address"+address);
				System.out.println("email"+email);
				System.out.println("password"+password);
				
			    ps1.executeUpdate();
				response.sendRedirect("login.jsp?y");
			}
			else
			{
				response.sendRedirect("registration.jsp?present");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}


