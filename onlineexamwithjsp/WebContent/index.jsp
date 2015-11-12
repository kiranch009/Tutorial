<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.utils.Constants"%>
<%@page import="com.utils.Messages"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%if (request.getAttribute(Constants.LOGIN_FAILED_KEY) != null) { %>

	<h4><%=Messages.getMessage("login.failed")%></h4>
	<%} %>
	<form method="post" action="login">
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
				<td><a href="/register">Register here</a></td>
			</tr>
		</table>
	</form>
</body>
</Html>