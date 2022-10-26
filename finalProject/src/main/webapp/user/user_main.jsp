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
<br><br>
<form method="get" action="ugetall">
<input type="submit" value="Get all Users">
</form>
<br><br>
<form action="getcart" method="get">
<input type="submit" value="View Cart">
</form><br><br><br>
<%List<Product> p1=(List<Product>)request.getAttribute("plist");%>

<table border="1">
<tr><th>Name</th><th>Description</th><th>Price</th><th>Add Cart</th></tr>
<%for(Product p:p1){ %>
<tr><td><%=p.getName() %></td>
<td><%=p.getDescription() %></td>
<td><%=p.getPrice() %> $</td>
<td><form action="add" method="post">
Product Id:<input name="pid" value="<%=p.getId()%>"><br>
Product Price:<input name="price" value="<%=p.getPrice()%>"><br>
Quantity:<select name="quantity">
<option></option>
<%for(int i=1;i<11;i++){ %>
<option value="<%=i%>"><%=i %></option>
<%} %>
</select><br>
<input type="submit" value="Add To Cart">
</form></td>
</tr>
<%} %>
</table><br><br> 

<form method="get" action="cp">
<%List<Category> l1=(List<Category>) request.getAttribute("clist"); %>
<select name="id">
<option></option>
<%for(Category c:l1){ %>
<option value="<%=c.getId()%>"><%=c.getName()%></option>
<%} %>
</select>
<input type="submit" value="Get">
</form><br><br></div>
</body>
</html>