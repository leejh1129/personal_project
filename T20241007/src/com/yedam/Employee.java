package com.yedam;

public class Employee {

	private String employeeId;
	private String employeeName;
	private String phone;
	private String hireDate;
	private int salary;
	
	public Employee() {
		
	}
	
	public Employee(String employeeId, String employeeName, String phone, String hireDate, int salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.phone = phone;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	public Employee(String employeeId, int salary) {
		this.employeeId = employeeId;
		this.salary = salary;
	}

	public Employee(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return " 사번 : " + employeeId + "\t" + "이름 : " + employeeName + "\t" + "전화번호 : " + phone
				+ "\t" + "입사일 : " +  hireDate + "\t" + "급여 : " + "\t" + salary;
	}
	

	

}
