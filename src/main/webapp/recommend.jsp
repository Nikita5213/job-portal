<%@ page import="com.model.User" %>
<%
User u = (User)session.getAttribute("user");
System.out.println(u);
if (u==null){
	response.sendRedirect("login.jsp");
	return;
}
String role = u.getRole();
if(!role.equals("applicant")){
	response.sendRedirect("error.jsp");
	return;
}

%>
<html>
<head></head>
<body>
<h1>Apply</h1>
</body>
</html>