<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login succeed!</title>
<style>
td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body style="text-align: center; fontsize: 400%;">
	<img src="${pageContext.request.contextPath}/images/AntraLogo.jpg"
		width="396" height="144" />
	<c:choose>
		<c:when test="${isValidUser && not empty isValidUser}">
			<h2>Welcome ${currentUser}!</h2>
			<table align="center" width="20%" style="text-align: center;">
				<tr>
					<td><a href="/DeptEmpHouJDBC/addDepartment.jsp"
						style="fontsize: 120%">Add Department</a></td>
				</tr>
				<tr>
					<td><a href="/DeptEmpHouJDBC/addEmployee.jsp"
						style="fontsize: 120%">Add Employee</a></td>
				</tr>
				<tr>
					<td><a href="/DeptEmpHouJDBC/logout" style="fontsize: 120%">Log
							Out</a></td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<p style="color: red">
				Please log in first! <a href="/DeptEmpHouJDBC">Log in here!</a>
		</c:otherwise>
	</c:choose>
</body>
</html>