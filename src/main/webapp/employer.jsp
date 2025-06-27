<%@ include file="header.jsp" %>
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
		body{
			display:block;
		}
	</style>
	</head>
	<body>
	<nav class="nav navbar bg-dark border-bottom border-body" data-bs-theme="dark">
		<div class="container-fluid justify-content-start">
			<a class="navbar-brand" class="nav-link">Job Portal</a>
			<a href = "view-my-list" class="nav-link">ViewMyListingJob</a>
			<a href = "post.jsp" class="nav-link">Post Job</a>
			<a href = "view-applicants" class="nav-link">View Applicants</a>
			<a href = "profile" class="nav-link">Profile</a>
			<a href = "logout" class="nav-link log-out" >Log Out</a>
		</div>
	</nav>
 </body>
</html>