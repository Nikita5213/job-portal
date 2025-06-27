<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.model.Profile" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<%@ include file="applicant.jsp" %>
<%
    Profile profile = (Profile) request.getAttribute("profile");
%>


<html>
<head>
	
    <title>Profile Form</title>
</head>
<body>

<form class = "form-post" action="profile"  method="post" enctype="multipart/form-data">

	<h1 class = "header display-2">Update Profile</h1>


    Name: <input class="form-control" type="text" name="name"
           value="${user.name}" />

    Email: <input class="form-control" type="email" name="email" readonly
           value="${user.email}" />

    Phone No: <input class="form-control"  type="number" name="phoneno"
           value="${profile.phoneno}" />

    Education: <input class="form-control"  type="text" name="education"
           value="${profile.education}" />

    Experience: <input class="form-control"  type="text" name="experience"
           value="${profile.experience}" />

    Skills: <input class="form-control"  type="text" name="skills"
           value="${profile.skills}" />

    Project: <input class="form-control"  type="text" name="project"
           value="${profile.project}" />

    Resume: <input class="form-control"  type="file" name="resumeFile" style="width: 200px;" />
    
    <c:if test="${not empty profile.resumeFile}">
        <a href="download">Download</a>
    </c:if>
	<br>
       <button class="btn btn-light" type="submit">Submit</button>

</form>

</body>
</html>





