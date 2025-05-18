<%@ page import="com.model.User" %>
<%
User u = (User)session.getAttribute("user");
System.out.println(u);
if (u==null){
	response.sendRedirect("login.jsp");
}
String role = u.getRole();
if(!role.equals("applicant")){
	response.sendRedirect("error.jsp");
}
%>
<html>
<head></head>
<body>
<h1>MyApplication</h1>
</body>
</html>