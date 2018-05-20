package com.demo.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class vAppedListVo {
	private String takeOffID; 
	private String employeeID;
	private String employeeName;
	private String holidayTypeName;
	private Date startDay;
	private Date endDay;
	private Date applyDay;
	private String examinerID;
	public int takeOffDays;
	
	public int examineLevel;
	public String examineOpinion;
	public Timestamp examineDate;
	public String examineResult;
	public String examineTableID;
	
	
	
	public String getExamineTableID() {
		return examineTableID;
	}
	public void setExamineTableID(String examineTableID) {
		this.examineTableID = examineTableID;
	}
	public int getExamineLevel() {
		return examineLevel;
	}
	public void setExamineLevel(int examineLevel) {
		this.examineLevel = examineLevel;
	}
	public String getExamineOpinion() {
		return examineOpinion;
	}
	public void setExamineOpinion(String examineOpinion) {
		this.examineOpinion = examineOpinion;
	}

    
	public Timestamp getExamineDate() {
		return examineDate;
	}
	public void setExamineDate(java.util.Date examineDate) {
		this.examineDate = new Timestamp(examineDate.getTime());
	}
	public String getExamineResult() {
		return examineResult;
	}
	public void setExamineResult(String examineResult) {
		this.examineResult = examineResult;
	}
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
	public int getTakeOffDays() {
		return takeOffDays;
	}
	public void setTakeOffDays(int takeOffDays) {
		this.takeOffDays = takeOffDays;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public Date getApplyDay() {
		return applyDay;
	}
	public void setApplyDay(java.util.Date applyDay) {
		this.applyDay = new Date(applyDay.getTime());
	}
	public String getExaminerID() {
		return examinerID;
	}
	public void setExaminerID(String examinerID) {
		this.examinerID = examinerID;
	}
	
}
