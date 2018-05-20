package com.demo.service;

import java.util.List;

import com.demo.po.HolidayType;
import com.demo.po.Rdays;
import com.demo.vo.HolidayRequestVo;

public interface HolidayReqService {
	public List<HolidayType> getAllTypes() throws Exception;
	public int getRemain(String eid, String hoid) throws Exception;
	public int getReqNum() throws Exception;
	public void addReq(HolidayRequestVo vo) throws Exception;
	public void updateRdays(Rdays rd) throws Exception;
}
