package com.demo.vo;

import java.sql.Date;

public class UpdateDepartmentVo {
	private String departmentID;
	private String departmentName;
	private String employeeID;
	private int maxPeople;
	private Date newdate;
	private String fatherDepartmentID;
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
}
