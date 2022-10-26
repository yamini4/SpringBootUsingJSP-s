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
<br><br>
<form action="uinsert" method="post"><br>
User Name<input type="text" name="name"><br>
PassWord<input type="password" name="password"><br>
Confirm Password<input type="password" name="cpassword"><br>
Email<input type="email" name="email"><br>
Gender<select name="gender">
<option></option>
<option value="Male">Male</option>
<option value="Female">Female</option>
<option value="Others">Others</option>
</select><br>
Address<input type="text" name="address"><br>
<input type="submit" value="Add">
</form>
<%String s= (String)request.getAttribute("error");%>

<h2 Style=color:red;><%=s %></h2><br>
</div>
</body>
</html>