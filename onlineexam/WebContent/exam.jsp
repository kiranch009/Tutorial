<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#message").empty();
		$.ajax({
			metho:"GET",
			contentType : "application/json",
			url : "http://localhost:8090/onlineexam/rest/selectTechnology",
		}).done(function(responseData){
			$.each(responseData,function(i,item)
			{
				$("#technologies").append("<input type='radio' name='technology' value='"+item.technologyId+"'>"+item.technologyName+"<br>");
			});
			
		}).fail(function(jqXHR,textStatus,errorThrown){
			$("#message").html("error in process"+ jqXHR.responseJSON.message);
			$("#message").css("background-color","red");
			$("#message").css("width","450px");
		});
		$("#submitTechnology").on("click",function(){
			$.ajax({
				metho:"GET",
				contentType : "application/json",
				url : "http://localhost:8090/onlineexam/rest/selectTechnology",
			}).done(function(responseData){
				$.each(responseData,function(i,item)
				{
					$("#technologies").append("<input type='radio' name='technology' value='"+item.technologyId+"'>"+item.technologyName+"<br>");
				});
				
			}).fail(function(jqXHR,textStatus,errorThrown){
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
	<div id="mainDiv">
		<H2>Select technology</H2>
		<form>
			<div id="technologies"></div>
			<input type="button" value="Submit" id="submitTechnology"/>
		</form>
	</div>
</body>
</html>