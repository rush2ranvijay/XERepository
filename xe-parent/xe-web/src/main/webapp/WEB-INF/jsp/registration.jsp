<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<title>Registration Page</title>
<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link href="/css/main.css" rel="stylesheet" />
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
				<li ><a href="/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
				<li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h1 class="text-center well" id="hrdText">REGISTRATION FORM</h1>
		<c:if test="${not empty successMessage}">
				<p class="alert alert-success" id="successMsg"> ${successMessage} </p>
		</c:if>
		<div class="col-lg-12 well">
			<div class="row">
				<form:form action="/registration" method="POST" modelAttribute="user">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label>
								<form:input path="firstName"  cssClass="form-control"/>
								<form:errors path="firstName" cssClass="error" />
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label>
								<form:input path="lastName" cssClass="form-control"/>
								<form:errors path="lastName" cssClass="error" />  
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Email Address</label> 
								<form:input path="email" cssClass="form-control"/>
								<form:errors path="email" cssClass="error" />   
							</div>
							<div class="col-sm-6 form-group">
								<label>Date Of Birth</label> 
								<form:input path="birthday" placeholder="MM/dd/yyyy" cssClass="form-control"/>
								<form:errors path="birthday" cssClass="error" />   
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Password</label> 
								<form:password path="password" cssClass="form-control"/>
								<form:errors path="password" cssClass="error" />   
							</div>
							<div class="col-sm-6 form-group">
								<label>Confirm Password</label> 
								<form:password path="confirmPassword" cssClass="form-control"/>
								<form:errors path="confirmPassword" cssClass="error" />   
							</div>
						</div>
						<div class="form-group">
							<label>Street</label>
							<form:input path="street" cssClass="form-control"/>
							<form:errors path="street" cssClass="error" />   
						</div>
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Zip Code</label> 
								<form:input path="zipCode" cssClass="form-control"/>
								<form:errors path="zipCode" cssClass="error" />    
							</div>
							<div class="col-sm-4 form-group">
								<label>City</label> 
								<form:input path="city" cssClass="form-control"/>
								<form:errors path="city" cssClass="error" />     
							</div>
							<div class="col-sm-4 form-group">
								<label>Country</label> 
								<form:select path="country" cssClass="form-control">
									<c:forEach items="${countryList}" var="item">
												<form:option value="${item.country}" label="${item.displayCountry}" />	
									</c:forEach>
								</form:select>
								<form:errors path="country" cssClass="error" /> 
							</div>
						</div>
						
						<button type="submit" class="btn btn-lg btn-info">Submit</button>
					</div>
				</form:form>
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