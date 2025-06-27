<%@ include file="header.jsp" %>
<html>
<body>

   <form action = "login" method = "post">
	<h1 class = "header display-2">Login</h1><br>
	Email: <input type =  "email" class="form-control"  name = "email"><br>
	Password: <input type = "password" class="form-control" name = "password"><br>
	<button type = "submit" class="btn btn-light">Submit</button><br><br>
	<span>Don't have account!</span>
	<a href ="register.jsp" class="link-warning">Register</a>
	</form>
</body>
</html>