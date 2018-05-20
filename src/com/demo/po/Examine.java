package com.demo.po;

import java.sql.Timestamp;

public class Examine {
	private String examineTableID;
	private String takeOffID;
	private String examineLevel;
	private String examinerID;
	private int examineResult;
	private Timestamp examineDate;
	private String examineOpinion;
	public String getExamineTableID() {
		return examineTableID;
	}
	public void setExamineTableID(String examineTableID) {
		this.examineTableID = examineTableID;
	}
	public String getTakeOffID() {
		return takeOffID;
	}
	public void setTakeOffID(String takeOffID) {
		this.takeOffID = takeOffID;
	}
	public String getExamineLevel() {
		return examineLevel;
	}
	public void setExamineLevel(String examineLevel) {
		this.examineLevel = examineLevel;
	}
	public String getExaminerID() {
		return examinerID;
	}
	public void setExaminerID(String examinerID) {
		this.examinerID = examinerID;
	}
	public int getExamineResult() {
		return examineResult;
	}
	public void setExamineResult(int examineResult) {
		this.examineResult = examineResult;
	}
	public Timestamp getExamineDate() {
		return examineDate;
	}
	public void setExamineDate(java.util.Date examineDate) {
		this.examineDate = new Timestamp(examineDate.getDate());
	}
	public String getExamineOpinion() {
		return examineOpinion;
	}
	public void setExamineOpinion(String examineOpinion) {
		this.examineOpinion = examineOpinion;
	}
	
}
