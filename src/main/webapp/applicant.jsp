<%@ include file="header.jsp" %>
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
	<style>
		body{
			display:block;
		}
	</style>
	</head>
	<body>
		<nav class="nav navbar bg-dark border-bottom border-body" data-bs-theme="dark">
			<div class="container-fluid justify-content-start">
				<a class="navbar-brand" >Job Portal</a>
				<a href ="search.jsp"  class="nav-link">Search</a>
				<a href ="recommend"  class="nav-link">Recommended Jobs</a>
				<a href = "my-application"  class="nav-link">My Application</a>
				<a href = "profile"  class="nav-link">Profile</a>
				<a href = "logout" class="nav-link log-out" >Log Out</a>
			</div>
  		</nav>

 </body>
</html>