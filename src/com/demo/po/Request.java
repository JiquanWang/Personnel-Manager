package com.demo.po;

import java.sql.Date;

public class Request {
	private String takeOffID;
	private String employeeID;
	private String holidayTypeID;
	private int  takeOffDays;
	private Date applyDay;
	private Date startDate;
	private Date endDate;
	private String reason;
	private int status;
	public String getTakeOffID() {
		return takeOffID;
	}
	public void setTakeOffID(String takeOffID) {
		this.takeOffID = takeOffID;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getHolidayTypeID() {
		return holidayTypeID;
	}
	public void setHolidayTypeID(String holidayTypeID) {
		this.holidayTypeID = holidayTypeID;
	}
	public int getTakeOffDays() {
		return takeOffDays;
	}
	public void setTakeOffDays(int takeOffDays) {
		this.takeOffDays = takeOffDays;
	}
	public Date getApplyDay() {
		return applyDay;
	}
	public void setApplyDay(Date applyDay) {
		this.applyDay = applyDay;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
