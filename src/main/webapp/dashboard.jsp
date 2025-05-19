<%@ page import="com.model.User" %>
<%
User u = (User)session.getAttribute("user");
System.out.println(u);
if (u==null){
	response.sendRedirect("login.jsp");
	return;
}
%>
<html>
	<head>
	</head>
	<body>
	<h1>Apply job</h1>
	<h1>Post job</h1>
	</body>
</html>