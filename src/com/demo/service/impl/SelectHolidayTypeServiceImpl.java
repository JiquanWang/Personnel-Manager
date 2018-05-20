package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.HolidayTypeMapper;
import com.demo.po.Headship;
import com.demo.po.HolidayType;
import com.demo.service.SelectHolidayTypeService;
import com.demo.vo.HolidayTypeSelectVo;
@Service
public class SelectHolidayTypeServiceImpl implements SelectHolidayTypeService {
	@Autowired
	private HolidayTypeMapper mapper;
	@Override
	public List<HolidayType> selectHolidayType(HolidayTypeSelectVo vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("service执行成功");
		return mapper.selectHolidayType(vo);
	}
	@Override
	public int selectByName(HolidayTypeSelectVo vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("service执行成功");
		return mapper.selectByName(vo);
	}
	@Override
	public int addHolidayType(HolidayTypeSelectVo vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("service执行成功");
		return mapper.addHolidayType(vo);
	}
	@Override
	public int selectNumberofType(HolidayTypeSelectVo vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectNumber(vo);
	}
	@Override
	public List<HolidayType> selectAllHolidayType() {
		// TODO Auto-generated method stub
		return mapper.selectAllHolidayType();
	}
	@Override
	public int updateHolidayType(HolidayTypeSelectVo vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.updateHolidayType(vo);
	}
	@Override
	public List<HolidayType> selectHolidayTypeByID(HolidayTypeSelectVo vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectHolidayTypeByID(vo);
	}
	@Override
	public int resetHolidayMark(String holidayTypeID) throws Exception {
		// TODO Auto-generated method stub
		return mapper.resetHolidayMark(holidayTypeID);
	}
}
