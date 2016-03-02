<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Exam</title>
</head>
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript">

$( document ).ready(function() {
	 $("#submit").on("click",function(){
		 $.ajax({
			  method: "POST",
			  url: "http://localhost:8080/onlineexam/rest/login",
		  	  data: { userName: $("[name=userName]").val(), password:$(":input")[1].value }
			}).done(function(responseData){
				alert(responseData);
			}).fail(function(){
				$("#message").innerHTML("error in process");
			})
	 });
});






</script>
<body>
	<div id="messge"></div>
	<form method="post" action="home">
		<table>
			<tr>
				<td>Login Id:</td>
				<td><input type="text" id="userName" name="userName" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="button" id="submit" value="Login" /></td>
				<td><a href="register">Register here</a></td>
			</tr>
		</table>
	</form>
</body>
</Html>