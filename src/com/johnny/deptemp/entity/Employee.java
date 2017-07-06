package com.johnny.deptemp.entity;

public class Employee {
	
	private Integer empId;
	private String firstName;
	private String lastName;
	private Integer age;
	private Department empDept;
	
	public Employee(){
		
	}
	public Employee(Integer empId, String firstName, String lastName, Integer age, Department empDept){
		super();
		if (empId != null) this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.empDept = empDept;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public Integer getAge(){
		return age;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	
	public int getId(){
		return empId;
	}
	public void setId(Integer empId){
		this.empId = empId;
	}
	
	public Department getDept(){
		return empDept;
	}
	public void setDept(Department empDept){
		this.empDept = empDept;
	}

}
