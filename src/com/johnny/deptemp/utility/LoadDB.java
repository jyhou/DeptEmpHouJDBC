package com.johnny.deptemp.utility;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;

public class LoadDB {
	public static List<Department> loadDept(){
		List<Department> allDept = new ArrayList<Department>();
		Integer deptId;
		String deptName;
		String deptEmail;
		 try (Connection conn = JdbcUtility.getConnection();
				 Statement stmtLoadAllDept = conn.createStatement();
				 ResultSet loadAllDeptRS = stmtLoadAllDept.executeQuery("select * from department");){
			 while (loadAllDeptRS.next()){
				 deptId = loadAllDeptRS.getInt("dept_id");
				 deptName = loadAllDeptRS.getString("dept_name");
				 deptEmail = loadAllDeptRS.getString("dept_email");
				 allDept.add(new Department(deptId, deptName, deptEmail, null));
			 }
		 } catch (SQLException se){
			 se.printStackTrace();
		 }
		 return allDept;
	}
	
	public static List<Employee> loadEmp(){
		List<Employee> allEmp = new ArrayList<Employee>();
		Integer empId;
		String firstName;
		String lastName;
		Integer age;
		List<Department> allDept = LoadDB.loadDept();
		
		try (Connection conn = JdbcUtility.getConnection();
				Statement stmtLoadAllEmp = conn.createStatement();
				ResultSet loadAllEmpRS = stmtLoadAllEmp.executeQuery("select * from employee;");
				){
			Integer empDeptId;
			Department empDept;
			while (loadAllEmpRS.next()){
				empDeptId = loadAllEmpRS.getInt("dept_id");
				empDept = DBsearch.getDeptById(allDept, empDeptId);
				empId = loadAllEmpRS.getInt("emp_id");
				firstName = loadAllEmpRS.getString("first_name");
				lastName = loadAllEmpRS.getString("last_name");
				age = loadAllEmpRS.getInt("age");
				allEmp.add(new Employee(empId, firstName, lastName, age, empDept));
			}
		} catch (SQLException se){
			se.printStackTrace();
		}
		
		return allEmp;
	}

}
