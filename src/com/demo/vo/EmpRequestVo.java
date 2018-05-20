package com.demo.vo;

import java.sql.Date;

public class EmpRequestVo {
	private String employeeName;
	private String sex;
	private String headshipName;
	private String departmentName;
	private Date startDate;
	private Date endDate;
	private String employeeMark;
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
	public String getHeadshipName() {
		return headshipName;
	}
	public void setHeadshipName(String headshipName) {
		this.headshipName = headshipName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEmployeeMark() {
		return employeeMark;
	}
	public void setEmployeeMark(String employeeMark) {
		this.employeeMark = employeeMark;
	}
	
	
}	
