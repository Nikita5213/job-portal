<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style>
	
    body {
      margin: 0;
      padding: 0;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      background-color: #f0f0f0;
      font-family: Arial, sans-serif;
    }
    .header{
    text-align:center;
    }
	
	</style>
</head>
<body>

   <form action = "login" method = "post">
	<h1 class = "header">Login</h1><br><br>
	Email: <input type =  "email" name = "email"><br><br>
	Password: <input type = "password" name = "password"><br><br>
	<button type = "submit">Submit</button><br><br>
	<span>Don't have account!</span>
	<a href ="register.jsp">Register</a>
	</form>
</body>
</html>