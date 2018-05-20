package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.HolidayExMapper;
import com.demo.po.Examine;
import com.demo.service.HolidayExService;
@Service
public class HolidayExServiceImpl implements HolidayExService {

	@Autowired
	private HolidayExMapper mapper;
	
	public int getExNum() throws Exception {
		List<Examine> exs = mapper.getAllExamines();
		return exs.size();
	}

	public void addEx(String exid, String tid, String exrid) throws Exception {
		mapper.addEx(exid, tid, exrid);
	}
	@Override
	public void approve(String exid, String tid, String exrid) throws Exception {
		mapper.approve(exid, tid, exrid);
	}

	@Override
	public void bohui(String tid, String opinion) throws Exception {
		mapper.bohui(tid, opinion);
	}

	@Override
	public void bohuiReq(String tid) throws Exception {
		mapper.bohuiReq(tid);
	}

}
