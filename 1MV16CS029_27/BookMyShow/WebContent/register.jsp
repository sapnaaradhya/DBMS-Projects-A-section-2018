<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookMyShow</title>
<link
	href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/app.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>



<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}
</style>
<body>
<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-left">
					<li><a>BookMyShow</a></li>
			</ul>
		</div>

		</div>
	</div>

	<div id="mainWrapper">
		<div class="login-container" style="border: thin solid lightskyblue;border-radius: 25px;">
			<div class="login-card">
				<div class="login-form">
					<div id="login-box">
						<h5>
							<label class="control-label">Please fill in below details to register.</label>
						</h5>
						<form action="register" method="post" name='loginForm' id="loginForm">
							
							<div class="input-group input-sm">
								<label class="input-group-addon" for="userName"><i
									class="fa fa-user"></i></label> <input type="text" class="form-control"
									id="userName" name="userName" placeholder="Enter Username"
									required>
							</div>
							
							<div class="input-group input-sm">
								<label class="input-group-addon" for="password"><i
									class="fa fa-lock"></i></label> <input type="password"
									class="form-control" id="password" name="password"
									placeholder="Enter Password" required>
							</div>
							
							<div class="input-group input-sm">
								<span class="input-group-addon">Email</span> <input type="text"
									class="form-control" id="email" name="email"
									placeholder="Enter Email" required>
							</div>
							
								<!-- Language: <select name="language">
            							<option>Hindi</option>
            							<option>English</option>
           					 			<option>French</option>
        							</select> <br/> -->
							<div class="form-actions">
								<input type="submit" name="submit" id="submit" value="Register" class="btn btn-block btn-primary btn-default">
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<p class="btn btn-info pull-left">Copyright © 2017-2018. All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>