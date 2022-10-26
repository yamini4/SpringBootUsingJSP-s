<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%String s= (String)request.getAttribute("error");
System.out.println(s);
%><br>
<h2>Edit Details here</h2>
<form action="cupdate"method="post">
Category Id<input type="text" name="id"><br>
Category Name<input type="text" name="name"><br>
<input type="submit">
</form>
<h2>Delete Details Here</h2>
<form action="cdelete">
Enter Id here<input type="text" name="id">
</form><br><br>
<form method="get" action="cgetall">
<input type="submit" value="Get All Categories">
</form><br><br>
</div>
</body>
</html>