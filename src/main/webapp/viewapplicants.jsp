<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<%@ include file="employer.jsp" %>

<html>
<head></head>
<body>
<div class="container mt-5">
  <table class="table table-bordered">
    <thead class="table-dark">
        <tr>
                <th>Name</th>
                <th>Title</th>
                <th>Description</th>
                <th>Location</th>
                <th>Skill</th>
                <th>Years</th>
                <th>Salary</th>
                <th>Action</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach var="va" items="${viewList}">
                <tr>
                    <td>${va.user.name}</td>
                    <td>${va.job.title}</td>
                    <td>${va.job.description}</td>
                    <td>${va.job.location}</td>
                    <td>${va.job.skill}</td>
                    <td>${va.job.years}</td>
                    <td>${va.job.salary}</td>
                    <td>
                        <a href="applicant?email=${va.user.email}" class="btn btn-sm btn-info">
                           View
                        </a>
                    </td>
                </tr>
            </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
