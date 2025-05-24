<%@ page import="com.model.User" %>
<%
User u = (User)session.getAttribute("user");
System.out.println(u);
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
<head></head>
<body>

	<form action = "profile" method = "post">
	
	Name:<input type = "text" name = "name"><br><br>
	Email:<input type = "email" name = "email"><br><br>
	PhoneNo:<input type = "number" name = "phoneno"><br><br>
	Education:<input type = "text" name = "education"><br><br>
	Experience:<input type = "number" name = "experience"><br><br>
	Skills:<input type = "text" name = "skills"><br><br>
	Project:<input type = "text" name = "project"><br><br>
	ResumeLink:<input type = "text" name = "resume"><br><br>
	Certificates:<input type = "text" name = "certificates"><br><br>
			</form>
</body>
</html>