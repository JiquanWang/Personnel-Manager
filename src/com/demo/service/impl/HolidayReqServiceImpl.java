package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.HolidayReqMapper;
import com.demo.po.HolidayType;
import com.demo.po.Rdays;
import com.demo.po.Request;
import com.demo.service.HolidayReqService;
import com.demo.vo.HolidayRequestVo;
@Service
public class HolidayReqServiceImpl implements HolidayReqService {
	@Autowired
	private HolidayReqMapper mapper;
	
	public List<HolidayType> getAllTypes() throws Exception {
		return mapper.getAllTypes();
	}

	@Override
	public int getRemain(String eid, String hoid) throws Exception {
		List<Rdays> days = mapper.getRemain(eid, hoid);
		if(days.size() == 0 || days.isEmpty())
		{
			return -1;
		}
		else
		{
			int i = days.get(0).getRemainingDays();
			return i;
		}
	}

	@Override
	public int getReqNum() throws Exception {
		List<Request> rs = mapper.getAllReq();
		return rs.size();
	}

	@Override
	public void addReq(HolidayRequestVo vo) throws Exception {
		mapper.addReq(vo);
	}

	@Override
	public void updateRdays(Rdays rd) throws Exception {
		mapper.updateRdays(rd);
	}

}
