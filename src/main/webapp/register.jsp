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
	<form action = "dashboard.jsp" method = "post">
	<h1 class = "header">Register</h1><br><br>
	Name: <input type = "text" name = "Name"><br><br>
	EmailId:  <input type = "email" name = "Email"><br><br>
	Password: <input type = "password" name = "Password"><br><br>
	
	Role:
	Employer <input type="radio"  name="role" >
  	Applicant <input type="radio"  name="role" >
  	<br><br>
	<button type = "submit">Submit</button>
	</form>
	</body>
</html>