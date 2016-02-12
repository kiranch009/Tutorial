<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Exam</title>
</head>
<body>
	<c:if test="${requestScope.loginError!=null}">
		<h4 style="background: red; width: 250px;"><c:out value="${requestScope.loginError}"></c:out>    </h4>
	</c:if>
	<form:form method="post" action="home">
		<form:errors path="*"/>
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
				<td><input type="submit" id="submit" value="Login" /></td>
				<td><a href="register">Register here</a></td>
			</tr>
		</table>
	</form:form>
</body>
</Html>