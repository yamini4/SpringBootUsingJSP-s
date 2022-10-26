<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Product</title>
</head>
<body>
<div style=background-color:black;><br>
<div style=background-color:pink;><br><h1 style=color:Purple;> ### SPORTS SHOES E-COMMERCE WEBSITE ### </h1><br></div><br></div>
<div style=background-color:lightgreen;>
<br><br>
<br><br>
<form action="pinsert" method="post">
Product Name<input type="text" name="name"><br>
Product Description<input type="text" name="description"><br>
Price <input type="text" name="price"><br>
Category<input type="text" name="cid">
<input type="submit">
</form>
<br><br><br><br>

<form method="get" action="pgetall">
<input type="submit" value="Get All Products">
</form><br><br>
</div>
</body>
</html>