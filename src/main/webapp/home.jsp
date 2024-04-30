<%@page import="dto.Task"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
*{
	margin:0px;
	padding:0px;
}
img{
     border-radius: 50%;
     position:relative;
     top:0px;
}
table{
width:60%;

}
table,td,th{
	border: 3px solid black;
	border-collapse: collapse;
	
}
th{
background-color: #D8EBF3;
color:black;
}
td{
background-color: white;
color:black;
}
#bg_img{
color:#D8EBF3;
height:100vh;
background-image: url("https://cdn.pixabay.com/photo/2016/03/24/13/45/coffee-1276784_1280.jpg");
background-position:bottom;
background-repeat: no-repeat;
background-size: cover;
display: flex;
justify-content: center;
flex-direction: column;

}
#a{
	text-decoration: none;
	border: 1px solid white;
	border-radius: 10px;
	width: 100px;
	color: white;
	padding: 5px;
	
}
#content{
	
	padding: 10px;
	border-radius: 10px;
	backdrop-filter:blur(2px);
	height: 250px;
	width: 300px;
	position:relative;
	left:520px;
	box-shadow: 0px 0px 10px 1px #0D202F;
}
#a:hover {
	background-color: #31ABF8;
	color:black;
	border: 1px solid black;
}

</style>
</head>
<body>
<div id="bg_img">

<%User u = (User)request.getSession().getAttribute("user"); %>
<center><h1>Welcome <%=u.getUsername() %></h1></center>
<br>
<div id="content">
<center>
<%String image = new String(Base64.getEncoder().encode(u.getUserimage())); %>

<img alt="" src="data:image/jpeg;base64,<%= image  %>" width="120px" height="120px">
</center>
<center>
<h3>Name :<%=u.getUsername() %></h3>
<h3>Email :<%=u.getUseremail() %></h3>
<h3>Contact :<%=u.getUsercontact() %></h3>
</center>

<br><br>
<center><a href="addtask.jsp" id="a">Add Task</a></center><br>
</div>

<br>
<br>
<br>
<center><h2>Tasks</h2></center>
<br>

<%List<Task> tasks = (List)request.getAttribute("tasks");%>

<center><table>
<tr>
<th>id</th>
<th>title</th>
<th>description</th>
<th>priority</th>
<th>due date</th>
<th>status</th>
<th>Delete</th>
</tr>

<%for(Task task : tasks){ %>
<tr>
<td><%= task.getTaskid() %></td>
<td><%= task.getTasktitle() %></td>
<td><%= task.getTaskdescription() %></td>
<td><%= task.getTaskpriority()%></td>
<td><%= task.getTaskduedate() %></td>
<td><%= task.getTaskstatus() %></td>
<td><a href="delete?id=<%=task.getTaskid()%>">Delete</a></td>
</tr>
<%} %>

</table>
</center>
</div>
</body>
</html>