package com.demo.vo;

import java.sql.Date;

public class TakeOffExamineVo {
	private int examineLevel;
	private String examinerName;
	private String examineOpinion;
	private Date examineDate;
	private String examineResult;
	public int getExamineLevel() {
		return examineLevel;
	}
	public void setExamineLevel(int examineLevel) {
		this.examineLevel = examineLevel;
	}
	public String getExaminerName() {
		return examinerName;
	}
	public void setExaminerName(String examinerName) {
		this.examinerName = examinerName;
	}
	public String getExamineOpinion() {
		return examineOpinion;
	}
	public void setExamineOpinion(String examineOpinion) {
		this.examineOpinion = examineOpinion;
	}
	public Date getExamineDate() {
		return examineDate;
	}
	public void setExamineDate(java.util.Date examineDate) {
		this.examineDate = new Date(examineDate.getTime());
	}
	public String getExamineResult() {
		return examineResult;
	}
	public void setExamineResult(String examineResult) {
		this.examineResult = examineResult;
	}
}
