<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.demo.Category" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Category Details</title>
</head>
<body>
<div style=background-color:black;><br>
<div style=background-color:pink;><br><h1 style=color:Purple;> ### SPORTS SHOES E-COMMERCE WEBSITE ### </h1><br></div><br></div>
<div style=background-color:lightgreen;>
<br><br>
<br><br>
<h2><a href="c_add.jsp">Add New Category</a></h2>
<br><br>
<%List<Category> p=(List<Category>)request.getAttribute("list"); %>
<table border="1">
<tr><th>Id</th><th>Name</th></tr>
<%for(Category p1:p){ %>
<tr>
<td><%=p1.getId() %></td>
<td><%=p1.getName() %></td>
</tr>
<%} %>
</table><br><br><br>

<a type="button" href="c_edit.jsp">Edit or Delete click here</a>
<br><br>

<form method="get" action="pgetall">
<input type="submit" value="Get All Products">
</form><br><br>
</div>
</body>
</html>