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
	
	
	<script>
        //function redirectToPage() {
            //var role = document.querySelector('input[name="role"]:checked');
            //if (role) {
                //if (role.value === "Employer") {
                  //  window.location.href = "employer.jsp";
                //} else if (role.value === "Applicant") {
                //    window.location.href = "applicant.jsp";
              //  }
            //} else {
          //      alert("Please select a role.");
        //    }
      //      return false; 
    //    }
    </script>
    
    
	<form   action = "register" method = "post">
	<h1 class = "header">Register</h1><br><br>
	Name: <input type = "text" name = "name"><br><br>
	EmailId:  <input type = "email" name = "email"><br><br>
	Password: <input type = "password" name = "password"><br><br>
	
	Role:
	 <input type="radio"  name="role" value = "employer" >Employer
  	 <input type="radio"  name="role" value = "applicant" >Applicant
  	<br><br>
	<button type = "submit">Submit</button>
	</form>
	</body>
</html>