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
<a href="login.jsp">Logout</a>

<br><br>
<form method="get" action="user/ugetall">
<input type="submit" value="Get all Users">
</form>

<form method="get" action="user/cp">
<%List<Category> l1=(List<Category>) request.getAttribute("clist"); %>
<select name="id">
<option></option>
<%for(Category c:l1){ %>
<option value="<%=c.getId()%>"><%=c.getName()%></option>

<%} %>
</select>
<input type="submit" value="Get">
</form>
<br><br></div>
<!-- <option value="1">Sports Shoes</option>
<option value="2">Running Shoes</option>
<option value="3">Walking Shoes</option>
<option value="4">Gym shoes</option>
<option value="5">Stylish</option> -->
</body>
</html>