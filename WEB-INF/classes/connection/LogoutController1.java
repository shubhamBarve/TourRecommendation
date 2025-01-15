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
 * Servlet implementation class LogoutController1
 */
@WebServlet("/LogoutController1")
public class LogoutController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		

	HttpSession session=request.getSession();
	session.invalidate();
	out.println("<script type=\"text/javascript\">");
	out.println("alert('you are logout sucessfully..');");
	out.println("location='index.html';");
	out.println("</script>");
	out.close();
	}

}
