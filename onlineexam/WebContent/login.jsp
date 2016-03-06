<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$("#message").empty();

						$("#submit").on("click",function() {
									$.ajax({
										   		method : "POST",
												contentType : "application/json",
												url : "http://localhost:8090/onlineexam/rest/login",
												datatype : "json",
												data : JSON.stringify({"userName" : $("[name=userName]").val(),
																	"password" : $(":input")[1].value})
											}).done(function(responseData) 
													{
														window.location.href="http://localhost:8090/onlineexam/selectTechnology.jsp";
													})
												.fail(function(jqXHR,textStatus,errorThrown) 
													  {
													   		$("#message").html("error in process"+ jqXHR.responseJSON.message);
																$("#message").css("background-color","red");
																$("#message").css("width","450px");
													})
										});
					});
</script>
</head>
<body>
	<div id="message"></div>
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
</html>