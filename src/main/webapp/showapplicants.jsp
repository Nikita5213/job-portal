<%@ page import="com.model.Profile" %>
<%@ include file="header.jsp" %>
<%@ include file="employer.jsp" %>
<%
    Profile p = (Profile) request.getAttribute("List");
%>

<html>
<head>
    <title>Applicant Profile</title>
    <style>
        .profile-container {
        	position: absolute;
    		top: 25%;
   			left: 33%;
            width: 50%;
            margin: auto;
            padding: 20px;
            font-size: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
        .profile-container div {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="profile-container" >
    <div><strong>Email:</strong> <%= p.getEmail() %></div>
    <div><strong>Phone No:</strong> <%= p.getPhoneno() %></div>
    <div><strong>Education:</strong> <%= p.getEducation() %></div>
    <div><strong>Experience:</strong> <%= p.getExperience() %></div>
    <div><strong>Skills:</strong> <%= p.getSkills() %></div>
    <div><strong>Project:</strong> <%= p.getProject() %></div>
    <div><a class="link-warning" href="download?email=<%= p.getEmail() %>">Download Resume</a></div>
</div>

</body>
</html>