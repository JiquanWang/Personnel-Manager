package com.demo.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.SelectHolidayMapper;
import com.demo.service.SelectHolidayService;
import com.demo.vo.DisplayHolidayVo;
import com.demo.vo.SelectHolidayVo;
import com.demo.vo.TakeOffDetailsVo;
import com.demo.vo.TakeOffExamineVo;

@Service
public class SelectHolidayServiceImpl implements SelectHolidayService {
	@Autowired
	private SelectHolidayMapper mapper;
	public List<DisplayHolidayVo> selectHolidayList(SelectHolidayVo vo) throws Exception{
		return mapper.selectHolidayList(vo);
	}
	public TakeOffDetailsVo selectTakeOffDetails(String takeOffID) throws Exception{
		return mapper.selectTakeOffDetails(takeOffID);
	}
	public List<TakeOffExamineVo> selectTakeOffExamine(String takeOffID) throws Exception{
		return mapper.selectTakeOffExamine(takeOffID);
	}
}
