package com.demo.vo;

import java.sql.Date;

public class TakeOffDetailsVo {
	private String employeeID;
	private String employeeName;
	private String holidayTypeName;
	private int takeOffDays;
	private Date startDay;
	private Date endDay;
	private Date applyDay;
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
	public String getHolidayTypeName() {
		return holidayTypeName;
	}
	public void setHolidayTypeName(String holidayTypeName) {
		this.holidayTypeName = holidayTypeName;
	}
	public int getTakeOffDays() {
		return takeOffDays;
	}
	public void setTakeOffDays(int takeOffDays) {
		this.takeOffDays = takeOffDays;
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
	public Date getApplyDay() {
		return applyDay;
	}
	public void setApplyDay(java.util.Date applyDay) {
		this.applyDay = new Date(applyDay.getTime());
	}
}
