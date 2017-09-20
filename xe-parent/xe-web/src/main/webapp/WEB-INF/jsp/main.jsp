<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
	<title>Main Page</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
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
				<li class="active"><a href="/main">Main Page</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="#">${ userName }</a></li>
				<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
			</ul>
		</div>
	</nav>

<div class="container">
<div class="panel-group">
	<div class="panel panel-info">
	  <div class="panel-heading">Last <c:out value="${topCurrencyQueries.size()}" /> Currency Queries</div>
	  <div class="panel-body">
	  	<table class="table">
			<thead>
				<tr>
					<th>AMOUNT</th>
					<th>FROM CURRENCY</th>
					<th>TO CURRENCY</th>
					<th>CONVERTED AMOUNT</th>
					<th>QUERY DATE</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${topCurrencyQueries}" var="currencyQuery">
				<tr>
					<td><c:out value="${currencyQuery.enterAmount}" /></td>
					<td><c:out value="${currencyQuery.fromCurrency}" /></td>
					<td><c:out value="${currencyQuery.toCurrency}" /></td>
					<td><c:out value="${currencyQuery.convertedAmount}" /></td>
					<td><c:out value="${currencyQuery.queryDate}" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	  </div>
	</div>
<div class="clr10"></div>
<div class="panel panel-warning">
  <div class="panel-heading">CONVERT CURRENCY</div>
  	<div class="panel-body">
  		<form:form action="/main" method="POST" modelAttribute="currencyQuery" cssClass="form-inline">
			<div class="form-group">
				<form:input path="enterAmount" placeholder="Enter Amount.." cssClass="form-control"/>
				<form:errors path="enterAmount" cssClass="error" />
			</div>
			<div class="form-group">	
				<label for="pwd">From Currency:</label> 
				<form:select path="fromCurrency" cssClass="form-control">
						<c:forEach items="${currencyList.currencies}" var="currency">
									<form:option value="${currency.key}" label="${currency.key}" />	
						</c:forEach>
				</form:select>
			</div>
			<div class="form-group">	
				<label for="pwd">To Currency:</label> 
				<form:select path="toCurrency" cssClass="form-control">
						<c:forEach items="${currencyList.currencies}" var="currency">
									<form:option value="${currency.key}" label="${currency.key}" />	
						</c:forEach>
				</form:select>
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>
  	</div>
</div>
<div class="clr10"></div>
<div class="panel panel-success">
  <div class="panel-heading">CURRENCY CONVERSION RESUTL</div>
  	<div class="panel-body">
  		<c:if test="${not empty currencyQuery.enterAmount }">
  			<div><c:out value="${currencyQuery.enterAmount}" /> <c:out value="${currencyQuery.fromCurrency}" /> = <c:out value="${currencyQuery.convertedAmount}" /> <c:out value="${currencyQuery.toCurrency}" /></div>
  		</c:if>
  	</div>
</div>
</div>
</div>
<!-- <nav class="navbar navbar-inverse navbar-fixed-bottom">
	<div class="container-fluid">
			<ul class="nav navbar-nav">
					<li ><a href="#">About us</a></li>
					<li ><a href="#">Jobs</a></li>
					<li ><a href="#">Terms & Conditions</a></li>
					<li ><a href="#">Privacy & Security</a></li>
			</ul>
	</div>
</nav> -->
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>

</html>