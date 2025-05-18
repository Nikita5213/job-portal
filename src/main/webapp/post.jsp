<%@ page import="com.model.User" %>
<%
User u = (User)session.getAttribute("user");
if (u==null){
	response.sendRedirect("login.jsp");
	return;
}
String role = u.getRole();
if(!role.equals("employer")){
	response.sendRedirect("error.jsp");
	return;
}
%>
<html>
	<head>
	<style>
	 body {
      margin: 0;
      padding: 0;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: #f0f0f0;
      font-family: Arial, sans-serif;
    }
	.header{
	text-align:centre;
	}
	</style>
	</head>
	<body>
	
	<form action = "post" method = "post">
	<h1 class = "header">Post Job</h1>
	Title:<input type = "text" name = "title"><br><br>
	Description:<textarea name = "description" rows = '2' cols = '15'></textarea><br><br>
	Location:<input type = "text" name = "location"><br><br>
	<input type = "email" name = "postedBy" hidden = "true" value = "<%=u.getEmail()%>">
	Skills:<input type = "text" name = "skill"><br><br>
	Years:<input type = "number" name = "years"><br><br>
	Salary:<input type = "number" name = "salary"><br><br>
	<button value = "submit">submit</button>
	</form>
 </body>
</html>