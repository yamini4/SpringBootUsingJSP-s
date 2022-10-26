<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div style=background-color:black;><br>
<div style=background-color:white;><br><h1 style=color:Purple;> ### SPORTS SHOES E-COMMERCE WEBSITE ### </h1><br></div><br></div>

<div style=background-color:pink;>
<br><br>
<form action="login">
User Name: <input type="text" name="username"><br>
PassWord: <input type="text" name="password"><br>
<input type="submit" value="Login">
</form>
<br><br><br>
<%String s=(String)request.getAttribute("error");%>
<h3 style=color:Blue;><%=s %></h3>
<br><br><br>
</div>
</body>
</html>