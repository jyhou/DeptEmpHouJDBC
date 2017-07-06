package com.johnny.deptemp.businessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.johnny.deptemp.entity.Department;
import com.johnny.deptemp.entity.Employee;
import com.johnny.deptemp.utility.JdbcUtility;

public class AddEmpService {
	
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer empDeptId;
	private ArrayList<Employee> empList;
	@SuppressWarnings("unchecked")
	public AddEmpService(String firstName, String lastName, Integer age, Integer empDeptId, Object empList){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.empDeptId = empDeptId;
		this.empList = (ArrayList<Employee>) empList;
	}

	public void addEmpToDB(){	
		////////////// Insert newEmp into database //////////////////
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/deptemp_test","johnny","123");
				PreparedStatement stmtFindDept = conn.prepareStatement("select * from department where dept_id = ?");
				PreparedStatement stmt = conn.prepareStatement("insert into employee (first_name, last_name, age, dept_id) value(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
				){
			Employee newEmp = new Employee(null, firstName, lastName, age, null);
			stmtFindDept.setInt(1, empDeptId);
			ResultSet empDeptRS = stmtFindDept.executeQuery();
			if (empDeptRS.next()){
				Department empDept = new Department(empDeptRS.getInt("dept_id"),empDeptRS.getString("dept_name"),
						empDeptRS.getString("dept_email"),null);
				newEmp.setDept(empDept);
			}
			empDeptRS.close();
			stmt.setString(1, newEmp.getFirstName());
			stmt.setString(2, newEmp.getLastName());
			stmt.setInt(3, newEmp.getAge());
			stmt.setInt(4, newEmp.getDept().getDeptId());
			stmt.executeUpdate();
			ResultSet empIdRS = stmt.getGeneratedKeys();
			newEmp.setId(empIdRS.getInt(1));//get new emp's id from DB and update emp object in java code	
			empIdRS.close();
			if (empList == null) empList = new ArrayList<Employee>();
			empList.add(newEmp);
			
		} catch (SQLException sqle){
			
		}
	}
	
//	public List<Employee> getEmpList(){
//		List<Employee> empList = new ArrayList<Employee>();
//		try (Connection conn = JdbcUtility.getConnection();
//				Statement stmtGetEmpList = conn.createStatement();
//				ResultSet getEmpListRS = stmtGetEmpList.executeQuery("select * from employee");){
//			List<Department> deptList = AddDeptService.getDeptList();
//			
//			while (getEmpListRS.next()){
//				Integer empDeptId = getEmpListRS.getInt("dept_id");
//				Department dept = null;
//				while (deptList.iterator().hasNext()){
//					if(empDeptId.equals(deptList.iterator().next().getDeptId())){
//						dept = deptList.iterator().next();
//						break;
//					}
//				}
//				
//				empList.add(new Employee(getEmpListRS.getInt("emp_id"), getEmpListRS.getString("first_name"), 
//						getEmpListRS.getString("last_name"), getEmpListRS.getInt("age"), dept));
//			}
//		} catch (SQLException se){
//			se.printStackTrace();
//		}
//		return empList;
//	}

}
