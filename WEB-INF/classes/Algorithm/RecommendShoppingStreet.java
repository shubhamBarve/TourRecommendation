package Algorithm;

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

import bean.ShoppingStreet;
import tourSenseHealp.DBConnect;
import Dbconnection.dbcon;

public class RecommendShoppingStreet {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		HashMap<String, Integer>hm=new HashMap<String, Integer>();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		 HashMap map = new HashMap();
		//Fetch Post Data
		ArrayList<String> al=new ArrayList<>();
		ArrayList<String> interestCount=new ArrayList<>();
		ArrayList<ShoppingStreet> streetData=new ArrayList<>();
		ArrayList<String> interested_category=new ArrayList<>();
		
		String user_email="supriya@gmail.com";
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
	    String query="SELECT location, street_name, address, category FROM shopping_street";
	    Statement smt=con.createStatement();
	    ResultSet rs1=smt.executeQuery(query);
	    while(rs1.next())
	    {
	    	ShoppingStreet pd=new ShoppingStreet();
	    	pd.setLocation(rs1.getString(1));
	    	pd.setStreet_name(rs1.getString(2));
	    	pd.setCategory(rs1.getString(4));
	    //	System.out.println("cattt---"+rs1.getString(4));
	    	streetData.add(pd);
	    }
	    
	    //Compare Data
	    HashSet<String> hash=new HashSet<>();
	    Iterator<String> itr=al.iterator();
	    while(itr.hasNext())
	    {
	    	String post=itr.next();
	    	Iterator<ShoppingStreet> itr2=streetData.iterator();
	    	while(itr2.hasNext())
	    	{
	    		ShoppingStreet pdObj=itr2.next();
	    		String location=pdObj.getLocation();
	    		String street_name=pdObj.getStreet_name();
	    		String category=pdObj.getCategory();
	    		
	    		if(post.contains(street_name))
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
	    
	  
        
        Integer intValue=2;
        for (Entry<String, Integer> entry : hm.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey());
                String var1=entry.getKey();
                String location="pune";
                Connection con1=dbcon.getConnection();
                String qry="select * from shopping_street where location like '%"+location+"%' and category like '%"+var1+"%' ";
                PreparedStatement ps=con1.prepareStatement(qry);
                ResultSet rss1=ps.executeQuery();
                while(rss1.next())
                {
                	//id, location, place_name, category, address
                	String location1=rss1.getString(2);
                	String street_name=rss1.getString(3);
                	String address1=rss1.getString(4);
                	System.out.println(location1);
                	System.out.println(street_name);
                	System.out.println(address1);
                	
                }
                
            }
        }
        
      //id, location, place_name, category, address
     
	     	
	}
}
