package com.johnny.deptemp.businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;
import com.johnny.deptemp.utility.JdbcUtility;

public class AddDeptService {
	
	private String deptName;
	private String deptEmail;
	private String[] deptEmpIdList;
	private ArrayList<Employee> empList;
	private ArrayList<Employee> deptEmpList;
	private ArrayList<Department> deptList;
	
	public AddDeptService(String dName, String dEmail, String[] dEmpIdList, ArrayList<Employee> empList, ArrayList<Department> deptList){
		this.deptName = dName;
		this.deptEmail = dEmail;
		this.deptEmpIdList = dEmpIdList;
		this.empList = empList;
		this.deptList = deptList;
	}
	
	public void addDeptToDB(){
		if (deptList == null){
			deptList = new ArrayList<Department>();
		}
		if (empList == null){
			empList = new ArrayList<Employee>();
		}
		if (deptEmpList == null){
			deptEmpList = new ArrayList<Employee>();
		}
		if (deptEmpIdList == null){
			deptEmpIdList = new String[0];
		}
		
		for (String empIdStr : deptEmpIdList) {
			Integer empId = Integer.parseInt(empIdStr);
			for (Employee emp : empList) {
				if (emp.getId() == empId) {
					deptEmpList.add(emp);
				}
			}
		}
		
		Department newDept = new Department(null, deptName, deptEmail, deptEmpList);
		if (!deptList.contains(newDept)) {
			try (Connection conn = JdbcUtility.getConnection();
					PreparedStatement stmt = conn.prepareStatement("insert into department (dept_name, dept_email) value(?,?)",Statement.RETURN_GENERATED_KEYS);
					PreparedStatement stmtGetInsertedDeptId = conn.prepareStatement("select dept_id from department where dept_name = ?")){
				stmt.setString(1,deptName);
				stmt.setString(2,deptEmail);
				stmt.executeUpdate();
			} catch (SQLException se){
				se.printStackTrace();
			}
		}
	}
	
//	public static List<Department> getDeptList(){
//		List<Department> deptList = new ArrayList<Department>();
//		try (Connection conn = JdbcUtility.getConnection();
//				Statement stmt = conn.createStatement();
//				ResultSet deptListRS = stmt.executeQuery("select * from department")){
//			
//			while (deptListRS.next()){
//				int deptId = deptListRS.getInt("dept_id");
//				String deptName = deptListRS.getString("dept_name");
//				String deptEmail = deptListRS.getString("dept_email");
//				deptList.add(new Department(deptId, deptName, deptEmail, null));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return deptList;
//	}

}
