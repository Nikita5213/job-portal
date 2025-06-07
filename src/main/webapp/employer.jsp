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
	</head>
	<body>
	
	<a href = "view-my-list">ViewMyListingJob</a><br><br>
	<a href = "post.jsp">Post Job</a><br><br>
	<a href = "view-applicants">View Applicants</a><br><br>
	<a href = "profile">Profile</a><br><br>
	
 </body>
</html>