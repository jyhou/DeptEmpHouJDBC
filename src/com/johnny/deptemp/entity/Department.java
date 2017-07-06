package com.johnny.deptemp.entity;

import java.util.ArrayList;

public class Department {
	private Integer deptId;
	private String deptName;
	private String deptEmail;
	private ArrayList<Employee> deptEmpList;
	
	public Department(Integer deptId, String deptName, String deptEmail, ArrayList<Employee> deptEmpList){
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptEmail = deptEmail;
		this.deptEmpList = deptEmpList;
	}
	
	public String getDeptName(){
		return deptName;
	}
	public void setDeptName(String deptName){
		this.deptName = deptName;
	}
	
	public String getDeptEmail(){
		return deptEmail;
	}
	public void setDeptEmail(String deptEmail){
		this.deptEmail = deptEmail;
	}
	
	public ArrayList<Employee> getDeptEmpList(){
		return deptEmpList;
	}
	public void setDeptEmpList(ArrayList<Employee> deptEmpList){
		this.deptEmpList = deptEmpList;
	}
	
	public Integer getDeptId(){
		return deptId;
	}
	public void setDeptId(Integer deptId){
		this.deptId = deptId;
	}
	
	@Override
	public boolean equals(Object deptObj){
		if(deptObj instanceof Department){
			return ((Department) deptObj).deptName.equalsIgnoreCase(this.deptName);
		}else{
			return false;
		}
	}

}
