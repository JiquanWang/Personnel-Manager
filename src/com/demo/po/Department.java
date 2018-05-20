package com.demo.po;

public class Department {
	private String departmentID;
	private String departmentName;
	private String employeeID;// Empolyee in charge of the department
	private int maxPeople;
	private int departmentMark;
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public int getDepartmentMark() {
		return departmentMark;
	}
	public void setDepartmentMark(int departmentMark) {
		this.departmentMark = departmentMark;
	}
	
}
