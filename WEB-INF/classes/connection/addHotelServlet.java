package connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Dbconnection.dbcon;

/**
 * Servlet implementation class addProductServlet
 */
@WebServlet("/addHotelServlet")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class addHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		 
	//	id, product_name, price, quantity, image, category
		String name=request.getParameter("name");
		System.out.println(name);
		
		String number=request.getParameter("number");
		System.out.println(number);
		
		String address=request.getParameter("address");
		System.out.println(address);

		String category=request.getParameter("category");
		System.out.println(category);

		String location=request.getParameter("location");
		System.out.println(location);
		
		Part filePart=request.getPart("image");
		String fileName = extractFileName(filePart);
		InputStream inputStream=null;
		if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }
		
		
		try {
			Connection con=dbcon.getConnection();
			String query="insert into hotels (name, number, address, category, image, location) values(?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,name );
			System.out.println(name);
			
			pst.setString(2,number );
			System.out.println(number);
			
			pst.setString(3,address );
			System.out.println(address);
			
			pst.setString(4,category );
			System.out.println(category);
			
			pst.setString(6,location );
			System.out.println(location);
			
			 if (inputStream != null) {
			        // fetches input stream of the upload file for the blob column
			        pst.setBlob(5, inputStream);
			    }//1 sec
			
		int i=pst.executeUpdate();
		if(i>0)
		{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Hotel details upload sucessfully..');");
			   out.println("location='addhotels.jsp';");
			   out.println("</script>");	
			//response.sendRedirect("addProduct.jsp?y");
		}
		else
	{
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('Hotel details not uploaded..');");
			   out.println("location='addhotels.jsp';");
			   out.println("</script>");
		//response.sendRedirect("addProduct.jsp?n");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

public String extractFileName(Part part) {

String contentDisp = part.getHeader("content-disposition");

String[] items = contentDisp.split(";");

for (String s : items) {

	if (s.trim().startsWith("filename")) {

		return s.substring(s.indexOf("=") + 2, s.length() - 1);

	}

}

return "";
}
}


