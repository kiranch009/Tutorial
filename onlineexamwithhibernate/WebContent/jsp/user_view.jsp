<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Exam</title>
</head>
<body>
	<form:form method="post" action="register" modelAttribute="user">
		<form:errors path="*"  cssStyle="background: red; width: 250px;"/>
		<table>

			<tr>
				<td>User Id:</td>
				<td><form:input path="userId" readonly="${disableUserId}" /></td>
			</tr>
			<tr>
				<td>User Name:</td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td>Date of birth(dd/MM/yyyy):</td>
				<td><form:input path="dob" /></td>
			</tr>
			<tr>
				<td>Login Id:</td>
				<td><form:input path="loginId" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Qualification:</td>
				<td><form:input path="qualification" /></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><form:input path="mobile" /></td>
			</tr>
			<tr>
				<td><input type="submit" id="submit" value="Save"/></td>
			</tr>
		</table>
	</form:form>
</body>
</Html>