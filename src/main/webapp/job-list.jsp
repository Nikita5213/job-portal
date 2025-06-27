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
        <th>Title</th><th>Description</th><th>Location</th>
        <th>Skill</th><th>Years</th><th>Salary</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="job" items="${jobList}">
        <tr>
          <td>${job.title}</td>
          <td>${job.description}</td>
          <td>${job.location}</td>
          <td>${job.skill}</td>
          <td>${job.years}</td>
          <td>${job.salary}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
