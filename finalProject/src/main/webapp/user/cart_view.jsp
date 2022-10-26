<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style=background-color:black;><br>
<div style=background-color:pink;><br><h1 style=color:Purple;> ### SPORTS SHOES E-COMMERCE WEBSITE ### </h1><br></div><br></div>
<div style=background-color:lightgreen;>
<br><br>
<br><br>
<form action="home">
<input type="submit" value="Home">
</form>
<br><br>
<form action="deleteall">
<input type="submit" value="Clear Cart">
</form>
<%List<Product> p1=(List<Product>) request.getAttribute("products");%>
<h3>Items in your cart:</h3>
<table>
<tr><th>Name</th><th>Price</th></tr>
<%for(Product p:p1){ %>
<tr><td><%=p.getName() %></td><td><%=p.getPrice() %></td></tr>
<%} %>
</table>
<%Double d=(Double) request.getAttribute("total"); %>
<h2>Total Amount you have to pay: <%=d%> $</h2>
<br>
<h3>We will send these items to your address</h3><br>
</div>
</body>
</html>