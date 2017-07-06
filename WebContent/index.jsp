<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DeptEmpHouJDBC - Jiangyi Hou</title>

<style>
table, td {
	border: 1px solid black;
	text-align: center;
	font-size: 120%;
}

h2 {
	font-size: 120%;
	text-align: center;
}
</style>
</head>

<body style="text-align: center; fontsize: 120%">

	<img src="${pageContext.request.contextPath}/images/AntraLogo.jpg"
		width="396" height="144" />
	<br>
	<c:if test="${!isValidUser && not empty isValidUser}">
		<p style="color: red;">Invalid input user! Please enter the
			correct user name and password!</p>
	</c:if>
	<br>
	<h2>Log In</h2>

	<form action="/DeptEmpHouJDBC/login" method="post">
		<table align="center">
			<tr>
				<td><label>User name:</label></td>
				<td><input type="text" name="userName" style="fontsize: 120%">
				</td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input type="password" name="password"
					style="fontsize: 120%"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" style="fontsize: 120%">
				</td>
				<td><input type="reset" value="Reset" style="fontsize: 120%">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>