<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
	<title>Home Page</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="/main"><img class="logo-img" src="/images/logo.jpg" alt=""></a>
			</div>
			<ul class="nav navbar-nav">
				<li ><a href="/main">Main Page</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
				<li><a href="/registration"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center well">SIGN IN</h1>
				<c:if test="${param.error}">
					<p class="alert alert-danger" id="errorMsg"> Invalid email or password </p>
        		</c:if>
				<div class="account-wall">
					<img class="profile-img" src="/images/signin.png" alt="">
					<form class="form-signin" action="/login" method="post">
						<input type="text" id="email" name="email" class="form-control" placeholder="Email" required autofocus> 
						<input type="password" id="pwd" name="password" class="form-control" placeholder="Password" required>
						<button class="btn btn-lg btn-primary btn-block" type="submit" id="loginBtn"> Sign in </button>
						<!-- <label class="checkbox pull-left"> <input type="checkbox"
							value="remember-me"> Remember me
						</label> -->
						<a href="#" class="pull-right need-help">Forgot Password? </a><span class="clearfix"></span> 
					</form>
				</div>
				<a href="/registration" class="text-center new-account" id="creatAccout" >CREATE AN ACCOUNT</a>
			</div>
		</div>
	</div>
<nav class="navbar navbar-inverse navbar-fixed-bottom">
	<div class="container-fluid">
			<ul class="nav navbar-nav">
					<li ><a href="#">About us</a></li>
					<li ><a href="#">Jobs</a></li>
					<li ><a href="#">Terms & Conditions</a></li>
					<li ><a href="#">Privacy & Security</a></li>
			</ul>
	</div>
</nav>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>

</html>