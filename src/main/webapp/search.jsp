<%@ include file="header.jsp" %>
<%@ include file="applicant.jsp" %>
<%@ page import="com.model.User" %>
<html>
<head></head>
<body>
<form class = "container form-margin" action="SearchJob" method="get">
	<input class="form-control" type="text" name="title" placeholder="Enter title">
    <input class="form-control" type="text" name="skills" placeholder="Enter skill">
    <select name="years" class="form-control">
    <option value="1">1 year</option>
    <option value="2">2 years</option>
    <option value="3">3 years</option>
    <option value="4">4 years</option>
    </select>
    <input class="form-control" type="text" name="location" placeholder="Enter location">
    <button class= "btn btn-light" type="submit">Search</button>
</form>
</body>
</html>