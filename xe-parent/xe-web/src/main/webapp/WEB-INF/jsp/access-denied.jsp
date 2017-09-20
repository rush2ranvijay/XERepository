<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<link href="/css/main.css" rel="stylesheet" />
</head>

<body>
	<div class="container">
		<h3>Access Denied Exception</h3>
		<div>
			Logged in user: <b class="user"> </b>
			<form class="form-signin" action="/logout" method="post">
				<button class="btn btn-lg btn-primary btn-block" type="submit"> Logout </button>
			</form>
		</div>
		<p class="error">${errorMsg}</p>
	</div>

	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>

</html>