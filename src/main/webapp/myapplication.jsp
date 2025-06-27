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
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="jwa" items="${myapplication}">
                <tr>
                    <td>${jwa.job.title}</td>
                    <td>${jwa.job.description}</td>
                    <td>${jwa.job.location}</td>
                    <td>${jwa.job.skill}</td>
                    <td>${jwa.job.years}</td>
                    <td>${jwa.job.salary}</td>
                    <td>${jwa.application.status}</td>
                </tr>
            </c:forEach>

            <c:if test="${empty myapplication}">
                <tr>
                    <td colspan="7" class="text-center text-muted">No applications found.</td>
                </tr>
            </c:if>
        </tbody>
    </table>
  </table>
</div>
</body>
</html>
