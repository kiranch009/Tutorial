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
	<form action="post" action="startExam">
		<table>
			<c:forEach items="${requestScope.QUESTION_LIST}" var="bean">
				<tr>
					<td><c:out value="${bean.question}"></c:out></td>
				</tr>
				<tr>
					<table>
						<c:forEach items="${bean.answerChoices}" var="choices">
							<tr>
								<td><input type="radio" name="${bean.questionId}" value="${choices.key}" />${choices.value}</td>
							</tr>
						</c:forEach>
					</table>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" name="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>