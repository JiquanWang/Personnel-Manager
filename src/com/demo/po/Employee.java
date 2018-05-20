package com.demo.po;

import java.sql.Date;

public class Employee {
	private String employeeID;//PK
	private String employeeName;
	private String username;
	private String password;
	private String sex;
	private Date birthday;
	private Date hiredate;
	private int salary;
	private int power;//only can be 1 or 2
	private String departmentID;//FK
	private String headshipID;//FK
	private int employeeMark;//only can be 1 or 2
	
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getHeadshipID() {
		return headshipID;
	}
	public void setHeadshipID(String headshipID) {
		this.headshipID = headshipID;
	}
	public int getEmployeeMark() {
		return employeeMark;
	}
	public void setEmployeeMark(int employeeMark) {
		this.employeeMark = employeeMark;
	}
	
}
