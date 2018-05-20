package com.demo.vo;

import java.sql.Date;

public class DepartmentDetailsVo {
	private String departmentID;
	private String departmentName;
	private String employeeID;
	private String employeeName;
	private int maxPeople;
	private int numberOfEmployee;
	private Date newdate;
	private String fatherDepartmentID;
	private String fatherDepartmentName;
	private String departmentMark;
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getMaxPeople() {
		return maxPeople;
	}
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}
	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}
	public Date getNewdate() {
		return newdate;
	}
	public void setNewdate(Date newdate) {
		this.newdate = newdate;
	}
	public String getFatherDepartmentID() {
		return fatherDepartmentID;
	}
	public void setFatherDepartmentID(String fatherDepartmentID) {
		this.fatherDepartmentID = fatherDepartmentID;
	}
	public String getFatherDepartmentName() {
		return fatherDepartmentName;
	}
	public void setFatherDepartmentName(String fatherDepartmentName) {
		this.fatherDepartmentName = fatherDepartmentName;
	}
	public String getDepartmentMark() {
		return departmentMark;
	}
	public void setDepartmentMark(String departmentMark) {
		this.departmentMark = departmentMark;
	}
}
