<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<%@ include file="applicant.jsp" %>

<html>
<head></head>
<body>
<div class="container mt-5">
  <table class="table table-bordered">
    <thead class="table-dark">
        <tr>
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
        <c:forEach var="j" items="${recommendlist}">
            <tr>
                <td>${j.title}</td>
                <td>${j.description}</td>
                <td>${j.location}</td>
                <td>${j.skill}</td>
                <td>${j.years}</td>
                <td>${j.salary}</td>
                <td>
                    <a href="apply?job_id=${j.id}" class="btn btn-sm btn-success">Apply</a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty jobList}">
            <tr>
                <td colspan="7" class="text-center text-muted">No jobs found.</td>
            </tr>
        </c:if>
        </tbody>
  </table>
</div>
</body>
</html>
