<%@ include file="header.jsp" %>
<html>
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
	<h1 class = "header display-2">Register</h1><br>
	Name: <input type = "text" class="form-control" name = "name"><br>
	EmailId:  <input type = "email" class="form-control" name = "email"><br>
	Password: <input type = "password" class="form-control" name = "password"><br>
	
	Role:
	 <input type="radio" class="form-check-input radio-button" name="role" value = "employer" >Employer
  	 <input type="radio"  class="form-check-input radio-button" name="role" value = "applicant" >Applicant
  	<br><br>
	<button type = "submit" class="btn btn-light">Submit</button>
	</form>
	</body>
</html>