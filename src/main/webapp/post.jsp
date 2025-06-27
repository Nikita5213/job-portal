<%@ include file="header.jsp" %>
<%@ include file="employer.jsp" %>
<%@ page import="com.model.User" %>

<html>
	<head>
	<style>
	</style>
	</head>
	<body>
	
	<form class = "form-post" action = "post" method = "post">
	<h1 class = "header display-2">Post Job</h1>
	Title:<input class="form-control" type = "text" name = "title">
	Description:<textarea class="form-control" name = "description" rows = '2' cols = '15'></textarea>
	Location:<input class="form-control" type = "text" name = "location">
	<input class="form-control" type = "email" name = "postedBy" hidden = "true" value = "<%=u.getEmail()%>">
	Skills:<input class="form-control"  type = "text" name = "skill">
	Years:<input class="form-control"  type = "number" name = "years">
	Salary:<input class="form-control"  type = "number" name = "salary"><br>
	<button class="btn btn-light" value = "submit">Submit</button>
	</form>
 </body>
</html>