<%@page import="com.dao.VenueDAOImpl"%>
<%@page import="com.dao.TimeDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>BookMyShow</title>

<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Movies Pro Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- pop-up -->
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //pop-up -->
<link href="css/easy-responsive-tabs.css" rel='stylesheet'
	type='text/css' />
<link rel="stylesheet" type="text/css" href="css/zoomslider.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link href="css/font-awesome.css" rel="stylesheet">
<script type="text/javascript" src="js/modernizr-2.6.2.min.js"></script>
<!--/web-fonts-->
<link href='//fonts.googleapis.com/css?family=Tangerine:400,700'
	rel='stylesheet' type='text/css'>
<link
	href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900"
	rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<!--//web-fonts-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Datepicker - Default functionality</title>
<link rel="stylesheet"   type="text/css" href="css/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : 0,
			maxDate : 5
		});
	});
</script>
<style>
*, *:before, *:after {
	box-sizing: border-box;
}

html {
	font-size: 16px;
}

.plane {
	margin: 20px auto;
	max-width: 500px;
}

.cockpit {
	height: 50px;
	position: relative;
	overflow: hidden;
	text-align: center;
	border-bottom: 5px solid #d8d8d8; &: before { content : "";
	display: block;
	position: visible;
	top: 0;
	left: 0;
	height: 500px;
	width: 100%;
	border-radius: 50%;
	border-right: 5px solid #d8d8d8;
	border-left: 5px solid #d8d8d8;
}

h1 {
	width: 60%;
	margin: 100px auto 35px auto;
}

}
.exit {
	position: relative;
	height: 50px; &: before , & : after {
    content : "EXIT";
	font-size: 14px;
	line-height: 18px;
	padding: 0px 2px;
	font-family: "Arial Narrow", Arial, sans-serif;
	display: block;
	position: absolute;
	background: green;
	color: white;
	top: 50%;
	transform: translate(0, -50%);
}

&
:before {
	left: 0;
}

&
:after {
	right: 0;
}

}
.fuselage {
	border-right: 5px solid #d8d8d8;
	border-left: 5px solid #d8d8d8;
	border-bottom: 5px solid #d8d8d8;
}

ol {
	list-style: none;
	padding-left: 7px;
}

.row {
	
}

.seats {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	justify-content: flex-start;
}

.seat {
	display: flex;
	flex: 0 0 14.28571428571429%;
	padding: 5px;
	position: relative;
	&:
	nth-child
	(3)
	{
	margin-right
	:
	14.28571428571429%;
}

input[type=checkbox] {
	position: absolute;
	opacity: 0;
}

input[type=checkbox]:checked { + label { background:#bada55;
	-webkit-animation-name: rubberBand;
	animation-name: rubberBand;
	animation-duration: 300ms;
	animation-fill-mode: both;
}

}
input[type=checkbox]:disabled { + label { background:#dddddd;
	text-indent: -9999px;
	overflow: hidden; &: after { content : "X";
	text-indent: 0;
	position: absolute;
	top: 4px;
	left: 50%;
	transform: translate(-50%, 0%);
}

&
:hover {
	box-shadow: none;
	cursor: not-allowed;
}

}
}
label {
	display: block;
	position: relative;
	width: 100%;
	text-align: center;
	font-size: 14px;
	font-weight: bold;
	line-height: 1.5rem;
	padding: 4px 0;
	background: #F42536;
	border-radius: 5px;
	animation-duration: 300ms;
	animation-fill-mode: both; &: before { content : "";
	position: absolute;
	width: 75%;
	height: 75%;
	top: 1px;
	left: 50%;
	transform: translate(-50%, 0%);
	background: rgba(255, 255, 255, .4);
	border-radius: 3px;
}

&
:hover {
	cursor: pointer;
	box-shadow: 0 0 0px 2px #5C6AFF;
}

}
}
@
-webkit-keyframes rubberBand { 0% {
	-webkit-transform: scale3d(1, 1, 1);
	transform: scale3d(1, 1, 1);
}

30%
{
-webkit-transform


:

 

scale3d


(1
.25
,
0
.75
,
1);
transform


:

 

scale3d


(1
.25
,
0
.75
,
1);
}
40%
{
-webkit-transform


:

 

scale3d


(0
.75
,
1
.25
,
1);
transform


:

 

scale3d


(0
.75
,
1
.25
,
1);
}
50%
{
-webkit-transform


:

 

scale3d


(1
.15
,
0
.85
,
1);
transform


:

 

scale3d


(1
.15
,
0
.85
,
1);
}
65%
{
-webkit-transform


:

 

scale3d


(
.95
,
1
.05
,
1);
transform


:

 

scale3d


(
.95
,
1
.05
,
1);
}
75%
{
-webkit-transform


:

 

scale3d


(1
.05
,
.95
,
1);
transform


:

 

scale3d


(1
.05
,
.95
,
1);
}
100%
{
-webkit-transform


:

 

scale3d


(1
,
1,
1);
transform


:

 

scale3d


(1
,
1,
1);
}
}
@
keyframes rubberBand { 0% {
	-webkit-transform: scale3d(1, 1, 1);
	transform: scale3d(1, 1, 1);
}

30%
{
-webkit-transform


:

 

scale3d


(1
.25
,
0
.75
,
1);
transform


:

 

scale3d


(1
.25
,
0
.75
,
1);
}
40%
{
-webkit-transform


:

 

scale3d


(0
.75
,
1
.25
,
1);
transform


:

 

scale3d


(0
.75
,
1
.25
,
1);
}
50%
{
-webkit-transform


:

 

scale3d


(1
.15
,
0
.85
,
1);
transform


:

 

scale3d


(1
.15
,
0
.85
,
1);
}
65%
{
-webkit-transform


:

 

scale3d


(
.95
,
1
.05
,
1);
transform


:

 

scale3d


(
.95
,
1
.05
,
1);
}
75%
{
-webkit-transform


:

 

scale3d


(1
.05
,
.95
,
1);
transform


:

 

scale3d


(1
.05
,
.95
,
1);
}
100%
{
-webkit-transform


:

 

scale3d


(1
,
1,
1);
transform


:

 

scale3d


(1
,
1,
1);
}
}
.rubberBand {
	-webkit-animation-name: rubberBand;
	animation-name: rubberBand;
}
</style>
</head>

<body>
	<%
		List<String> venue = new ArrayList<String>();
		VenueDAOImpl venueDAOImpl = new VenueDAOImpl();
		venue = venueDAOImpl.getAllVenue();

		List<String> time = new ArrayList<String>();
		TimeDAOImpl timeDAOImpl = new TimeDAOImpl();
		time = timeDAOImpl.getAllTime();
	%>

	<div class="w3_breadcrumb">
		<div class="breadcrumb-inner">
			<ul>
				<li><a href="/BookMyShow/movies.jsp">Home</a><i>//</i></li>

				<li>Deadpool 2</li>
			</ul>
		</div>
	</div>
	<!-- //breadcrumb -->
	<!--/content-inner-section-->
	<div class="w3_content_agilleinfo_inner">
		<div class="agile_featured_movies">
			<div class="inner-agile-w3l-part-head">
				<h3 class="w3l-inner-h-title">Deadpool 2</h3>
				<p class="w3ls_head_para">Action, Adventure, Comedy</p>
			</div>


		</div>
	</div>
	<div class="w3l-movie-gride-agile">
		<a href="" class="hvr-sweep-to-bottom"><img
			src="images/p2.jpg" title="BookMyShow" class="img-responsive" alt=" ">
			<div class="w3l-action-icon">
				<i class="fa fa-play-circle-o" aria-hidden="true"></i>
			</div> </a>
		<div class="mid-1 agileits_w3layouts_mid_1_home">
			<div class="w3l-movie-text">
				<h6>Deadpool 2</h6>
			</div>
			<div class="mid-2 agile_mid_2_home">
				<p>2018</p>
				<div class="block-stars">
					<ul class="w3l-ratings">
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
						<li><i class="fa fa-star" aria-hidden="true"></i></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="ribben">
			<p>NEW</p>
		</div>
	</div>
	<form action="bookingForm" method="post" name='bookingForm'
		id="bookingForm">
		<input id="movie" name="movie" type="hidden" value="Daedpool 2">
		
		<div class="w3l-movie-gride-agile">
			<p>
				Please Choose Date: <input type="text" id="datepicker"
					name="datepicker" onchange="showplace()">
			</p>
		</div>
		<div class="w3l-movie-gride-agile" id="place" style="display: none">
			<p>
				Please Choose Place: <select onchange="showtime()" id="venue"
					name="venue">
					<option>--Select--</option>
					<%
						for(String list : venue) {
					%>
					<option value="<%=list%>">
						<%=list%>
					</option>
					<%
						}
					%>
				</select>
			</p>
		</div>
		<div class="w3l-movie-gride-agile" id="time" style="display: none">
			<p>
				Time: <select onchange="getseats()" id="times" name="times">
					<option>--Select--</option>
					<%
						for(String times : time) {
					%>
					<option value="<%=times%>">
						<%=times%>
					</option>
					<%
						}
					%>
				</select>
			</p>
		</div>
		<div class="" id="getSeats" style="display: none">
			<p>
				<button type="button" onclick="makeRequest()">Select Seats</button>
			</p>
		</div>

		<div class="w3l-movie-gride-agile" style="display: none" id="seats"
			onclick="showsubmit()">
			<div class="plane">
				<div class="cockpit">
				<h5>Price per seat is RS 150/-</h5>
					<h3>Please select a seat</h3>
				</div>
				<ol class="cabin fuselage">
					<li class="row row--1">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="1A" name="1A" />
								<label for="1A">1A</label></li>
							<li class="seat"><input type="checkbox" id="1B" name="1B" />
								<label for="1B">1B</label></li>
							<li class="seat"><input type="checkbox" id="1C" name="1C" />
								<label for="1C">1C</label></li>
							<li class="seat"><input type="checkbox" id="1D" name="1D" />
								<label for="1D">1D</label></li>
							<li class="seat"><input type="checkbox" id="1E" name="1E" />
								<label for="1E">1E</label></li>
							<li class="seat"><input type="checkbox" id="1F" name="1F" />
								<label for="1F">1F</label></li>
						</ol>
					</li>
					<li class="row row--2">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="2A" name="2A" />
								<label for="2A">2A</label></li>
							<li class="seat"><input type="checkbox" id="2B" name="2B" />
								<label for="2B">2B</label></li>
							<li class="seat"><input type="checkbox" id="2C" name="2C" />
								<label for="2C">2C</label></li>
							<li class="seat"><input type="checkbox" id="2D" name="2D" />
								<label for="2D">2D</label></li>
							<li class="seat"><input type="checkbox" id="2E" name="2E" />
								<label for="2E">2E</label></li>
							<li class="seat"><input type="checkbox" id="2F" name="2F" />
								<label for="2F">2F</label></li>
						</ol>
					</li>
					<li class="row row--3">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="3A" name="3A" />
								<label for="3A">3A</label></li>
							<li class="seat"><input type="checkbox" id="3B" name="3B" />
								<label for="3B">3B</label></li>
							<li class="seat"><input type="checkbox" id="3C" name="3C" />
								<label for="3C">3C</label></li>
							<li class="seat"><input type="checkbox" id="3D" name="3D" />
								<label for="3D">3D</label></li>
							<li class="seat"><input type="checkbox" id="3E" name="3E" />
								<label for="3E">3E</label></li>
							<li class="seat"><input type="checkbox" id="3F" name="3F" />
								<label for="3F">3F</label></li>
						</ol>
					</li>
					<li class="row row--4">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="4A" name="4A" />
								<label for="4A">4A</label></li>
							<li class="seat"><input type="checkbox" id="4B" name="4B" />
								<label for="4B">4B</label></li>
							<li class="seat"><input type="checkbox" id="4C" name="4C" />
								<label for="4C">4C</label></li>
							<li class="seat"><input type="checkbox" id="4D" name="4D" />
								<label for="4D">4D</label></li>
							<li class="seat"><input type="checkbox" id="4E" name="4E" />
								<label for="4E">4E</label></li>
							<li class="seat"><input type="checkbox" id="4F" name="4F" />
								<label for="4F">4F</label></li>
						</ol>
					</li>
					<li class="row row--5">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="5A" name="5A" />
								<label for="5A">5A</label></li>
							<li class="seat"><input type="checkbox" id="5B" name="5B" />
								<label for="5B">5B</label></li>
							<li class="seat"><input type="checkbox" id="5C" name="5C" />
								<label for="5C">5C</label></li>
							<li class="seat"><input type="checkbox" id="5D" name="5D" />
								<label for="5D">5D</label></li>
							<li class="seat"><input type="checkbox" id="5E" name="5E" />
								<label for="5E">5E</label></li>
							<li class="seat"><input type="checkbox" id="5F" name="5F" />
								<label for="5F">5F</label></li>
						</ol>
					</li>
					<li class="row row--6">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="6A" name="6A" />
								<label for="6A">6A</label></li>
							<li class="seat"><input type="checkbox" id="6B" name="6B" />
								<label for="6B">6B</label></li>
							<li class="seat"><input type="checkbox" id="6C" name="6C" />
								<label for="6C">6C</label></li>
							<li class="seat"><input type="checkbox" id="6D" name="6D" />
								<label for="6D">6D</label></li>
							<li class="seat"><input type="checkbox" id="6E" name="6E" />
								<label for="6E">6E</label></li>
							<li class="seat"><input type="checkbox" id="6F" name="6F" />
								<label for="6F">6F</label></li>
						</ol>
					</li>
					<li class="row row--7">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="7A" name="7A" />
								<label for="7A">7A</label></li>
							<li class="seat"><input type="checkbox" id="7B" name="7B" />
								<label for="7B">7B</label></li>
							<li class="seat"><input type="checkbox" id="7C" name="7C" />
								<label for="7C">7C</label></li>
							<li class="seat"><input type="checkbox" id="7D" name="7D" />
								<label for="7D">7D</label></li>
							<li class="seat"><input type="checkbox" id="7E" name="7E" />
								<label for="7E">7E</label></li>
							<li class="seat"><input type="checkbox" id="7F" name="7F" />
								<label for="7F">7F</label></li>
						</ol>
					</li>
					<li class="row row--8">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="8A" name="8A" />
								<label for="8A">8A</label></li>
							<li class="seat"><input type="checkbox" id="8B" name="8B" />
								<label for="8B">8B</label></li>
							<li class="seat"><input type="checkbox" id="8C" name="8C" />
								<label for="8C">8C</label></li>
							<li class="seat"><input type="checkbox" id="8D" name="8D" />
								<label for="8D">8D</label></li>
							<li class="seat"><input type="checkbox" id="8E" name="8E" />
								<label for="8E">8E</label></li>
							<li class="seat"><input type="checkbox" id="8F" name="8F" />
								<label for="8F">8F</label></li>
						</ol>
					</li>
					<li class="row row--9">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="9A" name="9A" />
								<label for="9A">9A</label></li>
							<li class="seat"><input type="checkbox" id="9B" name="9B" />
								<label for="9B">9B</label></li>
							<li class="seat"><input type="checkbox" id="9C" name="9C" />
								<label for="9C">9C</label></li>
							<li class="seat"><input type="checkbox" id="9D" name="9D" />
								<label for="9D">9D</label></li>
							<li class="seat"><input type="checkbox" id="9E" name="9E" />
								<label for="9E">9E</label></li>
							<li class="seat"><input type="checkbox" id="9F" name="9F" />
								<label for="9F">9F</label></li>
						</ol>
					</li>
					<li class="row row--10">
						<ol class="seats" type="A">
							<li class="seat"><input type="checkbox" id="10A" name="10A" />
								<label for="10A">10A</label></li>
							<li class="seat"><input type="checkbox" id="10B" name="10B" />
								<label for="10B">10B</label></li>
							<li class="seat"><input type="checkbox" id="10C" name="10C" />
								<label for="10C">10C</label></li>
							<li class="seat"><input type="checkbox" id="10D" name="10D" />
								<label for="10D">10D</label></li>
							<li class="seat"><input type="checkbox" id="10E" name="10E" />
								<label for="10E">10E</label></li>
							<li class="seat"><input type="checkbox" id="10F" name="10F" />
								<label for="10F">10F</label></li>
						</ol>
					</li>
				</ol>

			</div>
		</div>
		<div class="w3l-movie-gride-agile" id="submitbtn"
			style="padding-top: 350px; padding-left: 100px; padding-right: 100px; display: none;">
			<input type="submit" name="submit" id="submit" value="Book"
				class="btn btn-block btn-primary btn-default">
		</div>
	</form>
</body>
</html>
<script>
	$(document).ready(function() {

	});
	function showplace() {
		document.getElementById("place").style.display = "block";
	}
	function showtime() {
		document.getElementById("time").style.display = "block";
	}
	function getseats() {
		document.getElementById("getSeats").style.display = "block";
	}
	function showseats() {
		document.getElementById("seats").style.display = "block";
	}

	function showsubmit() {
		document.getElementById("submitbtn").style.display = "block";
	}

	function makeRequest(){
		//alert("time is" + document.getElementById("times").value);
	    $.ajax({
	        type: "GET",
	        url: "/BookMyShow/bookingForm",
	        data: {movieselected: document.getElementById("movie").value,dateselected: document.getElementById("datepicker").value,venueselected: document.getElementById("venue").value,timeselected: document.getElementById("times").value},
	        success: function(data){
	            //alert("Payment successful");
	           	//alert(data);
	           	data = data.slice(0, -1);
				data = data.split(",");

				for (var i=0; i < data.length-1; i++) {     
					//alert(data[i]);
					document.getElementById(data[i]).checked = true;
					document.getElementById(data[i]).disabled=true;	
				}
	            document.getElementById("seats").style.display = "block";
	        },
	        error: function (data){
	            //alert("sorry payment failed");
	        }
	    });
	}
	
</script>