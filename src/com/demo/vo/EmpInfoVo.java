package com.demo.vo;

import java.sql.Date;

public class EmpInfoVo {
	private String employeeID;
	private String employeeName;
	private String sex;
	private String departmentName;
	private String headshipName;
	private String employeeMark;
	private Date hireDate;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getHeadshipName() {
		return headshipName;
	}
	public void setHeadshipName(String headshipName) {
		this.headshipName = headshipName;
	}
	public String getEmployeeMark() {
		return employeeMark;
	}
	public void setEmployeeMark(String employeeMark) {
		this.employeeMark = employeeMark;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
}
