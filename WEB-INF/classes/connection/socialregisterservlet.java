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

import Dbconnection.*;;

/**
 * Servlet implementation class socialregisterservlet
 */
@WebServlet("/socialregisterservlet")
public class socialregisterservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public socialregisterservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		System.out.println(name);
	
		String number=request.getParameter("number");
		System.out.println(number);
		
		String address=request.getParameter("address");
		System.out.println(address);
		
		String email=request.getParameter("email");
		System.out.println(email);
	
		String password=request.getParameter("password");
		System.out.println(password);
		
		
		
try {
			
		
		Connection con=dbcon.getConnection();
			String query="insert into social_registration(name, number, address, email, password) values (?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(query);
ps.setString(1, name);
ps.setString(2, number);
ps.setString(3, address);
ps.setString(4, email);
ps.setString(5, password);

int i=ps.executeUpdate();
if(i>0)
{
 out.println("<script type=\"text/javascript\">");
  out.println("alert('register sucessfully..');");
  out.println("location='socialmedialogin.jsp';");
  out.println("</script>");
}
else
{
	 out.println("<script type=\"text/javascript\">");
	   out.println("alert('Not register..');");
	   out.println("location='socialmediaregistration.jsp';");
	   out.println("</script>");
}
	} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
