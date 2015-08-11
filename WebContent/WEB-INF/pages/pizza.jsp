<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Playfair+Display:400,400italic,700italic|Oswald' rel='stylesheet' type='text/css'>
<link href="css/main.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizza</title>
</head>
<body style="margin:1cm">

	<h1>Hello ${ username }, Welcome to Pizza Store</h1>
	<h3>Add pizza or order</h3>
	<form:form action="/PizzaStore/addPizza" method="post">
		<h3>Pick your size</h3>
		<h2>
		<select name="sizeSelected">
			<c:forEach items="${sizes}" var="size">
				<option values="${size.description}">${size.description}</option>
			</c:forEach>
		</select>
		</h2>
		<br>
		
		<h3>Pick your topping</h3>
		<table>
			<c:forEach items="${toppings}" var="topping">
				<tr>
					<td><h4>${topping.description}:</h4></td>
					<td><h4><input type="checkbox" name="toppingSelected" value="${ topping.description }"/></h4></td>
				</tr>
			</c:forEach>
		</table>
		
		<h2><input type="submit" name="addPizza" value="Add pizza to submit" /></h2>
		
		</form:form>
		
		
		<h3> Current Order - Total Price is $${ totalPrice }</h3>
	
		<table width="400" border="2">
		 	<th><h2>Size</h2></th>
		 	<th><h2>Toppings</h2></th>
		 	<th><h2>Price</h2></th>
			<c:forEach items="${ pizzasInOrder }" var="pizza">
				<tr>
					<td><h4>${ pizza.size.description }</h4></td>
					<td>
						<c:forEach items="${pizza.toppings}" var="topping">
							<h4>${ topping.description }</h4>
						</c:forEach>
					</td>
					<td><h4>
						$${pizza.price}</br>
					</h4></td>
				</tr>

			</c:forEach>
		</table>
		<br/>
		
		<form:form action="/PizzaStore/submitOrder" method="post">
			<h2><input type="submit" value="Submit Order"/></h2>
			<h5>${ errMsg }</h5>
		</form:form>
		
			
	

</body>
</html>