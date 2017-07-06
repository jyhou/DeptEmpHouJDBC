package com.johnny.deptemp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;
import com.johnny.deptemp.utility.LoadDB;
import com.mysql.cj.jdbc.jmx.LoadBalanceConnectionGroupManager;
import com.johnny.deptemp.businessLogic.AddEmpService;

@WebServlet("/addEmp")
public class AddEmpServlet extends HttpServlet {

	private static final long serialVersionUID = 2522902293631491947L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		Integer age = Integer.parseInt(request.getParameter("age"));
		Integer empDeptId = Integer.parseInt(request.getParameter("department"));

		@SuppressWarnings("unchecked")
		ArrayList<Employee> empList = (ArrayList<Employee>) request.getSession().getAttribute("empList");
		AddEmpService empService = new AddEmpService(firstName, lastName, age, empDeptId, empList);
		empService.addEmpToDB();		
		List<Employee> allEmp = (ArrayList<Employee>) LoadDB.loadEmp();
		request.getServletContext().setAttribute("allEmp", allEmp);
		List<Department> allDept = (ArrayList<Department>) LoadDB.loadDept();
		request.getServletContext().setAttribute("allDept", allDept);
		
		response.sendRedirect("/DeptEmpHouJDBC/addEmployee.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
