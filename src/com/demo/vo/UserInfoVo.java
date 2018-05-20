package com.demo.vo;

import java.sql.Date;

public class UserInfoVo {
	public String employeeID;
	public String employeeName;
	public String departmentName;
	public String headshipName;
	public int headshipLevel;
	public String sex;
	public Date hireDate;
	public Date birthday;
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public int getHeadshipLevel() {
		return headshipLevel;
	}
	public void setHeadshipLevel(int headshipLevel) {
		this.headshipLevel = headshipLevel;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
