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
                    <li class="active">
                        <a href="home.jsp">
                            Home
                        </a>
                    </li>
                    <li>
                        <a href="post.jsp">
                           Post
                        </a>
                    </li>
                    <li>
                        <a href="viewAllPost.jsp">
                           View All Post
                        </a>
                    </li>
                    <li>
                        <a href="viewOwnPost.jsp">
                            View Own Post
                        </a>
                    </li>
                     <li>
                        <a href=logoutController>
                            Log Out
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
                    <div class="grid img-container justify-content-center no-gutters">
                        <div class="grid-sizer col-sm-12 col-md-6 col-lg-3"></div>
                        <div class="grid-item branding  col-sm-12 col-md-6 col-lg-3">
                            <a href="assets/img/portfolio/home-port1.png" title="project name 1">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port1.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  branding architecture  col-sm-12 col-md-6">
                            <a href="assets/img/portfolio/home-port2.png" title="project name 2">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port2.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  design col-sm-12 col-md-6 col-lg-3">
                            <a href="assets/img/portfolio/home-port3.png" title="project name 5">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port3.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  photography design col-sm-12 col-md-6 col-lg-3">
                            <a href="assets/img/portfolio/home-port4.png" title="project name 5">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port4.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  branding photography  col-sm-12 col-md-6 col-lg-3">
                            <a href="assets/img/portfolio/home-port5.png" title="project name 5">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port5.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item   architecture design col-sm-12 col-md-6 col-lg-3">
                            <a href="assets/img/portfolio/home-port6.png" title="project name 5">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port6.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  photography architecture col-sm-12 col-md-6 col-lg-3">
                            <a href="assets/img/portfolio/home-port7.png" title="project name 5">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port7.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item  branding design  col-sm-12 col-md-6 col-lg-3">
                            <a href="assets/img/portfolio/home-port8.png" title="project name 5">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port8.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="grid-item architecture  col-sm-12 col-md-6 col-lg-6">
                            <a href="assets/img/portfolio/home-port9.png" title="project name 4">
                                <div class="project_box_one">
                                    <img src="assets/img/portfolio/home-port9.png" alt="pro1" />
                                    <div class="product_info">
                                        <div class="product_info_text">
                                            <div class="product_info_text_inner">
                                                <i class="ion ion-plus"></i>
                                                <h4>project name</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
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