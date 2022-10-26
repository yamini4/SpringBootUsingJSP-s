<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<div style=background-color:black;><br>
<div style=background-color:pink;><br><h1 style=color:Purple;> ### SPORTS SHOES E-COMMERCE WEBSITE ### </h1><br></div><br></div>
<div style=background-color:lightgreen;>
<br><br>
<br><br>
<br><br>
<h2><a href="user_add.jsp">Add New User Details</a></h2>
<br><br>
<h2 style=color:purple;>User Details</h2>
<br><br>
<%List<User> l=(List<User>)request.getAttribute("user"); %>
<table border='1'>
<tr><th>Name</th><th>Email</th><th>Gender</th><th>Address</th></tr>
<%for(User u:l){ %>
<tr>
<td><%=u.getUser() %></td>
<td><%=u.getEmail() %></td>
<td><%=u.getGender() %></td>
<td><%=u.getAddress() %></td>
</tr>
<%} %>
</table>
<br><br><br>

<a type="button" href="user_edit.jsp">Edit or Delete click here</a><br><br>
</div>
</body>
</html>