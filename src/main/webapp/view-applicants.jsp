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
<head></head>
<body>
<h1>ViewApplicants</h1>
</body>
</html>