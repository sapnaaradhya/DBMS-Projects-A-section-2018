 <html>
 <title>BookMyShow</title>
 <head>
 
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
    </head>
<body>
<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-left">
					<li><a href="/BookMyShow/movies.jsp" >BookMyShow</a></li>
					
			</ul>
		</div>

		</div>
	</div>    
    
    <div class="container">
    <form class="form-horizontal" >
<div class="col-lg-12 col-md-12 col-sm-12">
<div class="panel panel-primary" style="background-color: mediumseagreen; border-color: mediumseagreen;">
	<div class="panel-heading " style="background-color: mediumseagreen; ">Booking Confirmed.</div>
	<div class="panel-body" style="BACKGROUND-COLOR: #FFF;">
										<div class="panel-body">
										<br/>
											<div class="row">
												<label class="col-sm-2">Booking ID : ${bookID}</label>
												
											</div>
											<div class="row">
												<label class="col-sm-3">Movie Name : ${moviename}</label>
												
											</div>
											<div class="row">
												<label class="col-sm-2">Venue : ${venue}</label>
												
											</div>											
											<div class="row">
												<label class="col-sm-2">Date : ${date}</label>
												
											</div>
											<div class="row">
												<label class="col-sm-2">Time : ${time}</label>
												<%-- <div class="col-sm-10">: ${mstrWizard.app_bus_uses}</div> --%>
											</div>
											<div class="row">
												<label class="col-sm-2">Seats : ${selectedSeats}</label>
											</div>
											<div class="row">
												<label class="col-sm-2">Total Price : ${price} RS</label>
											</div>
										</div>
</div>
</div>
 </div>
 </form>
 </div>  
</body>
</html>

