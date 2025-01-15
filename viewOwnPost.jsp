<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Dbconnection.dbcon"%>
<%@page import="java.sql.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- ========== Meta Tags ========== -->
    <meta charset="UTF-8">
    <meta name="description" content="Cocoon -Portfolio">
    <meta name="keywords" content="Cocoon , Portfolio">
    <meta name="author" content="Pharaohlab">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- ========== Title ========== -->
    <title>TourSense</title>
    <!-- ========== Favicon Ico ========== -->
    <!--<link rel="icon" href="fav.ico">-->
    <!-- ========== STYLESHEETS ========== -->
    <!-- Bootstrap CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fonts Icon CSS -->
    <link href="assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/et-line.css" rel="stylesheet">
    <link href="assets/css/ionicons.min.css" rel="stylesheet">
    <!-- Carousel CSS -->
    <link href="assets/css/slick.css" rel="stylesheet">
    <!-- Magnific-popup -->
    <link rel="stylesheet" href="assets/css/magnific-popup.css">
    <!-- Animate CSS -->
    <link rel="stylesheet" href="assets/css/animate.min.css">
    <!-- Custom styles for this template -->
    <link href="assets/css/main.css" rel="stylesheet">
</head>
<body>
<div class="loader">
    <div class="loader-outter"></div>
    <div class="loader-inner"></div>
</div>

<div class="body-container container-fluid">
    <a class="menu-btn" href="javascript:void(0)">
        <i class="ion ion-grid"></i>
    </a>
    <div class="row justify-content-center">
        <!--=================== side menu ====================-->
        <div class="col-lg-2 col-md-3 col-12 menu_block">

            <!--logo -->
            <div class="logo_box">
                <a href="#">
                    <img src="assets/img/logo.png" alt="cocoon">
                </a>
            </div>
            <!--logo end-->

            <!--main menu -->
            <div class="side_menu_section">
                <ul class="menu_nav">
                    <li class="treeview">
                        <a href="home.jsp">
                            Home
                        </a>
                    </li>
                     <li class="treeview">
                        <a href="post.jsp">
                            Post
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="viewAllPost.jsp">
                             View All Post
                        </a>
                    </li>
                    <li class="active treeview">
                        <a href="viewOwnPost.jsp">
                            View Own Post
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="logoutController">
                          LogOut
                        </a>
                    </li>
                    
                   
                </ul>
            </div>
            <!--main menu end -->

           

            <!--social and copyright -->
            <div class="side_menu_bottom">
                <div class="side_menu_bottom_inner">
                    <ul class="social_menu">
                        <li>
                            <a href="#"> <i class="ion ion-social-pinterest"></i> </a>
                        </li>
                        <li>
                            <a href="#"> <i class="ion ion-social-facebook"></i> </a>
                        </li>
                        <li>
                            <a href="#"> <i class="ion ion-social-twitter"></i> </a>
                        </li>
                        <li>
                            <a href="#"> <i class="ion ion-social-dribbble"></i> </a>
                        </li>
                    </ul>
                    
                </div>
            </div>
            <!--social and copyright end -->

        </div>
        <!--=================== side menu end====================-->

        <!--=================== content body ====================-->
        <div class="col-lg-10 col-md-9 col-12 body_block  align-content-center">
            <div class="portfolio">
                <div class="container-fluid">
                    <!--=================== masaonry portfolio start====================-->
                   
                    <div class="box-body no-padding">
	
<%				
	String qry = "select * from post";
		Connection conn=dbcon.getConnection();
			Statement st = conn.createStatement();
				ResultSet rset = st.executeQuery(qry);
%>					  
 <div align="left" style="margin-top: 30px" id="login">
 
 <% while(rset.next())
{%>	
<div  style="width: 45%" >
    <div class="panel panel-primary">
	   <div class="panel-heading" align="left" style="font-family: Cambria;font-size: 22px;"><%=rset.getString(2)%></div>
		<div class="panel-body">
           <form action="postController"  method="post" autocomplete="off" >
   			 <div class="modal-body">
          	  <div class="postp">
         		 <div class="form-group">
					<p style="font-family: Cambria;font-size: 17px;" align="left"><%=rset.getString(4)%><br><br>
         	    </div>
       		   </div>

	
<!--     		 <div align="left"> -->
<!-- <!--       		  class="btn btn-success" style="font-family: Cambria;font-size: 15px;">Post</button> --> 
<!--        		 <a href="LikeController?email=&picName=&upload_email=" style="padding-left: 10px;"> -->
<!-- 	           <img src="Images/like.PNG">&nbsp;&nbsp;&nbsp;<span style="color:#6D84C4;"></span>Like</a> -->
<!-- 	                		 <br><br><br> -->
<!--        		 </div> -->
       		 
  			</div>
   		  </form>
		</div>
	</div>
</div>
</div>
 <%}%>		
									
			
            </div>  <!-- /.box-body -->
                 
                   
                    <!--=================== masaonry portfolio end====================-->
                </div>
            </div>
        </div>
        <!--=================== content body end ====================-->
    </div>
</div>


<!-- jquery -->
<script src="assets/js/jquery.min.js"></script>
<!-- bootstrap -->
<script src="assets/js/popper.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/waypoints.min.js"></script>
<!--slick carousel -->
<script src="assets/js/slick.min.js"></script>
<!--Portfolio Filter-->
<script src="assets/js/imgloaded.js"></script>
<script src="assets/js/isotope.js"></script>
<!-- Magnific-popup -->
<script src="assets/js/jquery.magnific-popup.min.js"></script>
<!--Counter-->
<script src="assets/js/jquery.counterup.min.js"></script>
<!-- WOW JS -->
<script src="assets/js/wow.min.js"></script>
<!-- Custom js -->
<script src="assets/js/main.js"></script>
</body>
</html>