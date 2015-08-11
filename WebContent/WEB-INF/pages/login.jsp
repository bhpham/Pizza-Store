<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body style="margin:1cm 2cm 5cm">

	<h1>Welcome to Pizza store</h1>
	<form:form action="/PizzaStore/tryToLogin" method="post" commandName="customer">
		<table>
			<h5> ${ loginErrMsg }</h5>
			<tr>
				<td><h2>Username:</h2></td><td><h2><form:input path="username"/></h2></td>
				<td><h5><form:errors path="username" cssClass="error" /></h5></td>
			<tr>
			<tr>
				<td><h2>Password: </h2></td><td><h2><form:password path="password"/></h2></td>
				<td><h5><form:errors path="password" cssClass="error" /></h5></td>
			</tr>
		</table>
		<h2><input type="submit" value="Click here to login" /></h2>
		<h2><p><a name="click" href="/PizzaStore/dog"/>Click here to register </p></h2>
	</form:form>


</body>
</html>