package com.demo.service;

import java.util.List;

import com.demo.po.Headship;
import com.demo.po.HolidayType;
import com.demo.vo.HolidayTypeSelectVo;
import com.demo.vo.selectHeadshipVo;

public interface SelectHolidayTypeService {
	public List<HolidayType> selectHolidayType(HolidayTypeSelectVo vo) throws Exception;
	public int selectByName(HolidayTypeSelectVo vo) throws Exception;
	public int addHolidayType(HolidayTypeSelectVo vo) throws Exception;
	public int selectNumberofType(HolidayTypeSelectVo vo) throws Exception;
	public List<HolidayType> selectAllHolidayType();
	public int updateHolidayType(HolidayTypeSelectVo vo) throws Exception;
	public List<HolidayType> selectHolidayTypeByID(HolidayTypeSelectVo vo) throws Exception;
	public int resetHolidayMark(String holidayTypeID) throws Exception;
}
