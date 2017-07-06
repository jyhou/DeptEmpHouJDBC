<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
<style>
td{
border:1px solid black;
}
</style>
</head>
<body style="text-align:center">

	<img src="${pageContext.request.contextPath}/images/AntraLogo.jpg"
		width="396" height="144"/>

	<h3 style="text-align:center">Welcome, ${currentUser}!</h3>

	<h2 style="text-align:center">Add new employee</h2>
	<c:choose>
		<c:when test="${isValidUser && not empty isValidUser}">
			<form action="/DeptEmpHouJDBC/addEmp" method="post">
				<table align="center" style="text-align: left; fontsize: 120%; border: 1px solid black;">
					<tr>
						<td>First Name:</td>
						<td><input type="text" name="firstName" style="fontsize: 120%;" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><input type="text" name="lastName" style="fontsize: 120%;" /></td>
					</tr>
					<tr>
						<td>Age:</td>
						<td><input type="number" name="age" style="fontsize: 120%;" /></td>
					</tr>
					<tr>
						<td>Department: </td>
						<td>
							<select name="department" required="required">
								<option value="">Select department</option>
								<c:forEach items="${applicationScope.allDept}" var="dept">
									<option value="${dept.getDeptId()}">${dept.getDeptName()}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
					    <td align="center"><input type="submit" value="Submit"/></td>
					    <td align="center"><button onclick="location.href='/DeptEmpHouJDBC/success.jsp'" type="button">Back</button></td>
					</tr>
	
				</table>
			</form>
			<br><br>
			<button onclick="location.href='/logout'" type="button">Log out</button>
		</c:when>
		<c:otherwise>
			<p style="color: red">Please log in first! <a href="/DeptEmpHouJDBC">Log in here!</a>
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty allEmp}">
	<p align="center">Added employees:</p>
		<table align="center" style="background-color:powderblue">
			<tr style="font-family:verdana">
				<td>ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td> Age </td>
				<td> Department</td>
			</tr>
			<c:forEach items="${applicationScope.allEmp}" var="emp">
				<tr>
					<td>${emp.getId()}</td>
					<td>${emp.getFirstName()}</td>
					<td>${emp.getLastName()}</td>
					<td>${emp.getAge()}</td>
					<td>${emp.getDept().getDeptName()}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>