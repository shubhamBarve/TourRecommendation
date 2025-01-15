<!DOCTYPE html>
<html lang="en">
  <head>
    <title>TourSense</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popusp.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
    
  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
      <a class="navbar-brand" href="index.html">TourSense</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="oi oi-menu"></span> Menu
      </button>

      <div class="collapse navbar-collapse" id="ftco-nav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item"><a href="adminHome.jsp" class="nav-link">Home</a></li>
         
        </ul>
      </div>
    </div>
  </nav>
    <!-- END nav -->
    
    <div class="hero-wrap js-fullheight" style="background-image: url('images/restaurant-1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-9 ftco-animate text-center" data-scrollax=" properties: { translateY: '70%' }">
            <div class="row block-9">
          <div class="col-md-6 pr-md-5">
              <br><br><br>
            <form action="addHotelServlet" method="post" enctype="multipart/form-data">
              <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Enter Your Hotel Name" required pattern="[a-zA-Z\s']+" title="Enter Your Name(eg.abc)">
              </div>
               <div class="form-group">
                <input type="text" class="form-control" name="number" placeholder="Enter Your Mobile number" required pattern="[7-9]{1}[0-9]{9}"  title="* Mobile number with 7-9 and remaing 9 digit with 0-9">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" name="address" placeholder="Enter Your Hotel Address" >
              </div>
                <div class="form-group">
                <input type="text" class="form-control" name="category" placeholder="Enter Your category" required pattern="[a-zA-Z\s]+" title="Enter Your Address(eg.indian, chinese)">
                </div>
                
                 <div class="form-group">
                   <input type="file" class="form-control" id="image" name="image" value="" placeholder="Hotel_Image">
                  </div> 
                  
                  <div class="form-group">
                <input type="text" class="form-control" name="location" placeholder="Enter Your location" required pattern="[a-zA-Z\s]+" title="Enter Your Location">
                </div>      
                
              <div class="form-group">
                <input type="submit" value="Submit" class="btn btn-primary py-3 px-5">
              </div>
              <div class="form-group">
                     <span class="btn btn-primary py-3 px-2">Existing user?  <a href="login.jsp">Login here</a></span>  
              </div>
                    
            </form>
          
          </div>
        </div>
            <h1 class="mb-3 bread" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }"></h1>
          </div>
        </div>
      </div>
    </div>

    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>