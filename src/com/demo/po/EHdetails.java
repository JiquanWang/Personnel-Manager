package com.demo.po;

import java.sql.Date;

public class EHdetails {
	private String EHdetailsID;
	private String employeeID;
	private String headshipID;
	private Date startDate;
	private Date endDate;
	public String getEHdetailsID() {
		return EHdetailsID;
	}
	public void setEHdetailsID(String eHdetailsID) {
		EHdetailsID = eHdetailsID;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getHeadshipID() {
		return headshipID;
	}
	public void setHeadshipID(String headshipID) {
		this.headshipID = headshipID;
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
