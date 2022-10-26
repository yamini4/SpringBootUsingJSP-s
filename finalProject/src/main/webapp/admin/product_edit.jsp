<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
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
<%String s= (String)request.getAttribute("error");%>

<h2><%=s %></h2>
<br>
<h2>Edit Details here</h2>
<form action="pupdate"method="post">
Product Id<input type="text" name="id">
<br>
Product Name<input type="text" name="name"><br>
Product Description<input type="text" name="description"><br>
Price <input type="text" name="price"><br>
Category<input type="text" name="cid">
<input type="submit" value="submit">
</form>
<h2>Delete Details Here</h2>
<form action="pdelete">
Select Product here<input type="text" name="id">
<br>
</form><br><br>
<form method="get" action="pgetall">
<input type="submit" value="Get All Products">
</form><br><br>
</div>
</body>
</html>