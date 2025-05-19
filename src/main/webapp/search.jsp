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
<head></head>
<body>
<form action="SearchJob" method="get">
    <input type="text" name="search" placeholder="Enter job title or skill">
    <select name="search" >
    <option value="1">1 year</option>
    <option value="2">2 years</option>
    <option value="3">3 years</option>
    <option value="4">4 years</option>
    </select>
    <input type="text" name="search" placeholder="Enter location">
    <button type="submit">Search</button>
</form>
</body>
</html>