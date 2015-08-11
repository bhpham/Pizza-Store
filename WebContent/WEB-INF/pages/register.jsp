<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body style="margin:1cm">

	<form:form action="/PizzaStore/tryToRegister" method="post" commandName="customer">
		<table>
			<tr>
				<td><h1>Username:</h1></td><td><h1><form:input path="username"/></h1></td>
				<td><h5><form:errors path="username" cssClass="error" /></h5></td>
			<tr>
			<tr>
				<td><h1>Password: </h1></td><td><h1><form:password path="password"/></h1></td>
				<td><h5><form:errors path="password" cssClass="error" /></h5></td>
			</tr>
			<tr>
				<td><h1>Age: </h1></td><td><h1><form:input path="age"/></h1></td>
				<td><h5><form:errors path="age" cssClass="error" /></h5></td>
			</tr>
			<tr>
				<td><h1>Email: </h1></td><td><h1><form:input path="email"/></h1></td>
				<td><h5><form:errors path="email" cssClass="error" /></h5></td>
			</tr>
		</table>
		<h1><input type="submit" value="Click here to Register" /></h1>
		<h5> ${ existedCustomerErr }</h5>
	</form:form>

</body>
</html>