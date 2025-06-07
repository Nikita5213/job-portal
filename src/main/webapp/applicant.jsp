<%@ page import="com.model.User" %>
<%
User u = (User)session.getAttribute("user");
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
	<head>
	</head>
	<body>
	<a href ="search.jsp" >Search</a><br><br>
	<a href ="recommend" >Recommended Jobs</a><br><br>
	<a href = "my-application">My Application</a><br><br>
	<a href = "profile">Profile</a><br><br>
 </body>
</html>