<%@ page import="com.model.Job" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<%@ include file="applicant.jsp" %>

<html>
<head>
    <title>Job List</title>
    <style>
        table {
            border-collapse: collapse;
            width: 90%;
            margin: auto;
        }
        th, td {
            border: 1px solid #333;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: black;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .apply-btn {
            padding: 5px 10px;
            background-color: green;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
    </style>
</head>
<body>

<h1>Job List</h1>

<table>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Location</th>
        <th>Skill</th>
        <th>Years</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    
    <c:forEach var="j" items="${searchlist}">
        <tr>
            <td>${j.title}</td>
            <td>${j.description}</td>
            <td>${j.location}</td>
            <td>${j.skill}</td>
            <td>${j.years}</td>
            <td>${j.salary}</td>
            <td>
                <a class="apply-btn" href="apply?job_id=${j.id}">Apply</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>