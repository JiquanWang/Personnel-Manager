package com.demo.vo;

import java.sql.Date;

public class DisplayHolidayVo {
	private String takeOffID;
	private String employeeName;
	private String holidayTypeName;
	private int takeOffDays;
	private Date startDay;
	private Date endDay;
	public String getTakeOffID() {
		return takeOffID;
	}
	public void setTakeOffID(String takeOffID) {
		this.takeOffID = takeOffID;
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
}
