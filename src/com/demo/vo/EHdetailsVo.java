package com.demo.vo;

import java.sql.Date;

public class EHdetailsVo {
	private String employeeName;
	private String headshipName;
	private Date startDate;
	private Date endDate;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getHeadshipName() {
		return headshipName;
	}
	public void setHeadshipName(String headshipName) {
		this.headshipName = headshipName;
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
