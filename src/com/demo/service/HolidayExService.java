package com.demo.service;

public interface HolidayExService {
	public int getExNum() throws Exception;
	public void addEx(String exid, String tid, String exrid) throws Exception;
	public void approve(String exid, String tid, String exrid) throws Exception;
	public void bohui(String tid, String opinion)  throws Exception;
	public void bohuiReq(String tid) throws Exception;
}
