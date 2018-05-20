package com.demo.po;

import java.sql.Date;

public class EDdetails {
	private String EDdetailsID;
	private String employeeID;
	private String departmentID;
	private Date startDate;
	private Date endDate;
	public String getEDdetailsID() {
		return EDdetailsID;
	}
	public void setEDdetailsID(String eDdetailsID) {
		EDdetailsID = eDdetailsID;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
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
	
}
