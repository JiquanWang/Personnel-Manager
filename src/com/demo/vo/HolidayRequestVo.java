package com.demo.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class HolidayRequestVo {
	private String takeOffID;
	private String employeeID;
	private String employeeName;
	private String holidayTypeID;
	private String remain;
	private int takeOffDays;
	private Timestamp applyDay;
	private Date startDay;
	private Date endDay;
	private String reason;
	private int status;
	
	
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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

	
	
	public Timestamp getApplyDay() {
		return applyDay;
	}
	public void setApplyDay(java.util.Date applyDay) {
		this.applyDay = new Timestamp(applyDay.getTime());
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
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
