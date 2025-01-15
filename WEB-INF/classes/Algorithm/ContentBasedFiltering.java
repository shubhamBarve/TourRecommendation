package Algorithm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tourSenseHealp.DBConnect;
import tourSenseHealp.PlaceData;
import tourSenseHealp.UserPost;
import Dbconnection.dbcon;

/**
 * Servlet implementation class ContentBased
 */
@WebServlet("/ContentBasedFiltering")
public class ContentBasedFiltering extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	
   		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String user_email=(String) session.getAttribute("email");
		System.out.println(user_email);
		
		ArrayList<String> recommend=new ArrayList<String>();
		ArrayList<String> recommend1=new ArrayList<String>();
   		
   		HashMap<String, Integer>hm=new HashMap<String, Integer>();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		 HashMap map = new HashMap();
		//Fetch Post Data
		ArrayList<String> al=new ArrayList<>();
		ArrayList<String> interestCount=new ArrayList<>();
		ArrayList<PlaceData> placeData=new ArrayList<>();
		ArrayList<String> interested_category=new ArrayList<>();
		
		
	    try {
	    	//String user_email="supriya@gmail.com";
			PreparedStatement st;
		    ResultSet rs;
		    Connection con=DBConnect.getConnection();
			st=con.prepareStatement("SELECT email,status FROM post where email='"+user_email+"'");
			  rs=st.executeQuery();
			    while(rs.next())
			    {
			    	UserPost up=new UserPost();
			    	al.add(rs.getString(2));
			    	
			    }
			    
			    //Fetch Place Data
			    String query="SELECT location, place_name, category FROM places";
			    Statement smt=con.createStatement();
			    ResultSet rs1=smt.executeQuery(query);
			    while(rs1.next())
			    {
			    	PlaceData pd=new PlaceData();
			    	pd.setLocation(rs1.getString(1));
			    	pd.setPlace_name(rs1.getString(2));
			    	pd.setCategory(rs1.getString(3));
			    	placeData.add(pd);
			    }
			    
			    //Compare Data
			    HashSet<String> hash=new HashSet<>();
			    Iterator<String> itr=al.iterator();
			    while(itr.hasNext())
			    {
			    	String post=itr.next();
			    	Iterator<PlaceData> itr2=placeData.iterator();
			    	while(itr2.hasNext())
			    	{
			    		PlaceData pdObj=itr2.next();
			    		String location=pdObj.getLocation();
			    		String place_name=pdObj.getPlace_name();
			    		String category=pdObj.getCategory();
			    		
			    		if(post.contains(place_name))
			    		{
			    			System.out.println("Category:"+category);
			    			interested_category.add(category);
			    			hash.add(category);
			    		}
			    			    		
			    	}
			    }

			    Iterator<String> categoryCnt=hash.iterator();
		    	System.out.println("User Name:"+ user_email);

			    while(categoryCnt.hasNext())
			    {
			    	String categoryName=categoryCnt.next();
			    	int count=Collections.frequency(interested_category, categoryName);
			       	System.out.println("Catrogory Name:"+categoryName+"  "+ "Count is: "+count);
			       	hm.put(categoryName, count);
			       	list1.add(count);
			       	
			    }
			    System.out.println("hashmap count"+hm);
			    int max=Collections.max(list1);
			    System.out.println("max value"+max);
			    Set keys = new HashSet();
			    String value=String.valueOf(max);
			    System.out.println("value of map"+value);
			    
			  String location=request.getParameter("location");
			  System.out.println(location);
		         
		        Integer intValue=2;
		        for (Entry<String, Integer> entry : hm.entrySet()) {
		            if (entry.getValue().equals(max)) {
		                System.out.println(entry.getKey());
		                String var1=entry.getKey();
		               // String location="pune";
		                Connection con1=dbcon.getConnection();
		                String qry="select * from places where location like '%"+location+"%' and category like '%"+var1+"%' ";
		                PreparedStatement ps=con1.prepareStatement(qry);
		                ResultSet rss1=ps.executeQuery();
		                while(rss1.next())
		                {
		                	//id, location, place_name, category, address
		                	String location1=rss1.getString(2);
		                	String placename=rss1.getString(3);
		                	String address1=rss1.getString(5);
		                	System.out.println(location1);
		                	System.out.println(placename);
		                	System.out.println(address1);
		                	
//		                	session.setAttribute("location1", location1);
//		                	session.setAttribute("placename", placename);
//		                	session.setAttribute("address1", address1);
		                	
		                	recommend.add(location1);
		                	recommend.add(placename);
		                	recommend.add(address1);
		                }
		                
		            }
		        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	          
	    HttpSession placeSession = request.getSession();
		placeSession.setAttribute("recommend", recommend);
//		placeSession.setAttribute("recommend1", recommend1);
		RequestDispatcher dispatcher = request.getRequestDispatcher("recommendPlaces.jsp");
		dispatcher.forward(request, response); 	
	}
}
