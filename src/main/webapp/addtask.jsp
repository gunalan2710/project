<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
*{
padding: 0px;
margin: 0px;

}

#one{
   border: 1px solid black;
   width: 300px;
   height: 450px;
  position: relative;
  left: 40%;
  top:90px;
  box-shadow:0px 0px 25px 1px white;
  border-radius: 10px;
}
#bg{
        height:100vh;
        background-image:url("https://cdn.pixabay.com/photo/2018/10/28/10/04/background-image-3778266_1280.jpg");        
		background-repeat: no-repeat;
		background-size: cover;
		background-position: center;
		
}
#two{
     position: relative;
     left:50px;
     top:30px;
     font-size:24px;
}
.a{
width: 200px;
}
input{
   border-radius:6px; 
   height:20px;
   
}
#submit{
border: 1px solid white;
	background: linear-gradient(45deg, #003A52, #0785B4);
	width: 150px;
	height: 35px;
	align-items:center;
	text-align: center;
	border-radius: 10px;
	
	font-family: monospace;
	font-size: x-large;
	transition:0.4s;
	
	
}
#submit:hover {
	background: linear-gradient(45deg, #0785B4, #003A52);
	font-family: monospace;
	font-size: x-large;
	transition:0.4s;
	cursor: pointer;
	color: white;
}
</style>
<body>
<div id="bg">
<div id="one">
<div id="two">
	<form action="addTask" method="post">
		<label>task id:</label><br>
		<input type= "text" name = "taskid" required class="a"><br>
		
		<label>task title:</label><br>
		<input type= "text" name = "tasktitle" required class="a"><br>
		
		<label>task description:</label><br>
		<input type= "text" name = "taskdescription" required class="a"><br>
		
		<label>Options :</label><br>
		<label for="option1">
		<input type= "radio" id="option1" value="low" name = "taskpriority" > Low
		</label><br>
		<label for="option2">
		<input type= "radio" id="option2" value="medium" name = "taskpriority" > Medium
		</label><br>
		<label for="option3">
		<input type= "radio" id="option3" value="high" name = "taskpriority" > High
		</label><br>
		
		<label>Due Date:</label><br>
		<input type= "date" name = "taskduedate" ><br><br>
		
		<input type="submit"id="submit">
	</form>
	</div>
</div>
</div>

</body>
</html>