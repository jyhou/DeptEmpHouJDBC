<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Department</title>
<style>
td{
border:1px solid black;
}
</style>
</head>
<body style="text-align: center;">
	<img src="${pageContext.request.contextPath}/images/AntraLogo.jpg"
		width="396" height="144" />

	<h3>Welcome, ${currentUser}!</h3>

	<h2>Add new department</h2>
	<c:choose>
		<c:when test="${isValidUser && not empty isValidUser}">

			<form action="/DeptEmpHouJDBC/addDept" method="post">
				<table align="center"
					style="text-align: left; fontsize: 120%; border: 1px solid black;">
					<tr>
						<td>Dept Name:</td>
						<td><input type="text" name="deptName"
							style="fontsize: 120%;" /></td>
					</tr>
					<tr>
						<td>Dept Email:</td>
						<td><input type="text" name="deptEmail"
							style="fontsize: 120%;" /></td>
					</tr>
					<!-- <tr>
						<td>Employee:</td>
						<td><c:forEach items="${empList}" var="emp">

								<p>
									<input type="checkbox" name="deptEmpIdList" value="${emp.getId()}" />${emp.getFirstName()}
									${emp.getLastName()}
								</p>

							</c:forEach></td>
					<tr> -->
					<tr>
						<td align="center"><input type="submit" value="submit" /></td>
						<td align="center"><button
								onclick="location.href='/DeptEmpHouJDBC/success.jsp'" type="button">Back</button></td>
					</tr>

				</table>
			</form>
			<br>
			<br>

			<button onclick="location.href='/logout'" type="button">Log
				out</button>

		</c:when>
		<c:otherwise>
			<p style="color: red">
				Please log in first! <a href="/DeptEmpHouJDBC">Log in here!</a>
		</c:otherwise>
	</c:choose>

	<c:if test="${not empty allDept}">
	Added departments:
		<table align="center" style="background-color: powderblue">
			<tr>
			<td>Dept ID: </td>
			<td>Dept Name:</td>
			<td>Dept Email:</td>
			<!--  <td>Dept Employees:</td> -->
			</tr>
			<c:forEach items="${applicationScope.allDept}" var="dept">
				<tr>
					<td>${dept.getDeptId()}</td>
					<td>${dept.getDeptName()}</td>
					<td>${dept.getDeptEmail()}</td>
					
					<!-- <td>
					<c:forEach items="${dept.getDeptEmpList()}" var="deptEmp">
					<p>${deptEmp.getFirstName()} ${deptEmp.getLastName()}</p>
					</c:forEach>
					</td> -->
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>