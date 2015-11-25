<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Exam</title>
</head>
<body>

	<form method="post" action="startExam">
		<table>
		
		
			
			<c:forEach items="${requestScope.TECHNOLOGIES_LIST}" var="item">
				<tr>
					<td><input type="radio" name="technology"
						value="${item.key}"/>${item.value} </td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" name="submit" value="submit"/></td>
			</tr>
		</table>
	</form>
</body>
</html>