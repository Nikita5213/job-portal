<html>
	<head>
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
	text-align:centre;
	}
	</style>
	</head>
	<body>
	
	<form action = "dashboard.jsp " method = "post">
	<h1 class = "header">Post Job</h1>
	Id:<input type = "number" name = "jid"><br><br>
	Title:<input type = "text" name = "jtile"><br><br>
	Description:<textarea name = "description" rows = '2' cols = '15'></textarea><br><br>
	Location:<input type = "text" name = "jlocation"><br><br>
	PostedBy:<input type = "text" name = "jpostBy"><br><br>
	Skills:<input type = "text" name = "jskill"><br><br>
	Years:<input type = "number" name = "jyears"><br><br>
	Salary:<input type = "number" name = "jsalary"><br><br>
	<button value = "submit">submit</button>
	</form>
 </body>
</html>