<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Blood Donation Management System</title>
<link href="css/lightbox.css" rel="stylesheet" />
    <link href="StyleSheet.css" rel="stylesheet" type="text/css" />

    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--slider-->
<link href="css/flexslider.css" rel="stylesheet" type="text/css" media="all" />
     <script src="js/jquery-1.11.0.min.js"></script>
	<script src="js/lightbox.min.js"></script>
<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="js/jquery.flexslider.js" type="text/javascript"></script>
  
 <script type="text/javascript">
     $(function () {
         SyntaxHighlighter.all();
     });
     $(window).load(function () {
         $('.flexslider').flexslider({
             animation: "slide",
             animationLoop: false,
             itemWidth: 210,
             itemMargin: 5,
             minItems: 2,
             maxItems: 4,
             start: function (slider) {
                 $('body').removeClass('loading');
             }
         });
     });
  </script>
</head>

<body>
 <div class="h_bg">
<div class="wrap">
<div class="header">
		<div class="logo">
			<h1><a href="index.php"><img src="Images/logo.png" alt=""></a></h1>
		</div>
	</div>
</div>
</div>
<div class="nav_bg">
<div class="wrap">
		<?php require('header.php');?>
	</div>

        <div>

          <div class="h_btm_bg">
<div class="wrap">
<div class="h_btm">
	<div class="header-para">
		<img src="cpics/welcome.png"/>		
		<p>Blood is universally recognized as the most precious element that sustains life. It saves innumerable lives across the world in a variety of conditions. The need for blood is great - on any given day, approximately 39,000 units of Red Blood Cells are needed. More than 29 million units of blood components are transfused every year.
Donate Blood 	
Despite the increase in the number of donors, blood remains in short supply during emergencies, mainly attributed to the lack of information and accessibility.

We positively believe this tool can overcome most of these challenges by effectively connecting the blood donors with the blood recipients.</p>
	</div>  
	
	<div class="clear"></div>
</div>
</div>
</div>
<div class="s_bg">
<div class="wrap">
<div class="main_cont">
 <section class="slider">
        <div class="flexslider carousel">
          <ul class="slides">
  	    		<li>
  	    	    <img src="Images/slider1.jpg" />
  	    		</li>
  	    		<li>
  	    	    <img src="Images/slider2.jpg" />
  	    		</li>
  	    		<li>
  	    	    <img src="Images/slider3.jpg"/>
  	    		</li>
  	    		<li>
  	    	    <img src="Images/slider4.jpg" />
  	    		</li>
  	    		<li>
  	    	    <img src="Images/slider5.jpg" />
  	    		</li>
  	    		<li>
  	    	    <img src="Images/slider6.jpg" />
  	    		</li>
  	    		<li>
  	    	    <img src="Images/slider7.jpg" />
  	    		</li>
  	    		<li>
  	    	    <img src="Images/slider8.jpg" />
  	    		</li>
          </ul>
        </div>
      </section>
	<div class="ribben">
	   <div class="l-triangle-top"></div>
	   <div class="l-triangle-bottom"></div>
		   <div class="rectangle"></div>
	      <div class="r-triangle-top"></div>
	   <div class="r-triangle-bottom"></div>
	   <div class="clear"></div>
	</div>
</div>
</div>

        </div>
        <div class="clear"></div>
<div class="ftr-bg">
<div class="wrap">
<div class="footer">
	<div class="f_nav">
		<ul>
			<li class="active"><a href="index.php">Home</a></li>			
			<li><a href="donar.php">Donor</a></li>
            <li><a href="login.php">Log In</a></li>
           
			
            </ul>
	</div>
		<div class="copy">
			<p class="title">© All Rights Reserved </p>
		</div>
	<div class="clear"></div>
</div>
</div>
</div>
</body>
</html>