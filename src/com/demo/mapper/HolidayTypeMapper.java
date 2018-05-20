package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.HolidayType;
import com.demo.po.Headship;
import com.demo.vo.UserInfoVo;
import com.demo.vo.UserLoginVo;
import com.demo.vo.changePasswordVo;
import com.demo.vo.seeVo;
import com.demo.vo.HolidayTypeSelectVo;

public interface HolidayTypeMapper {

	public List<HolidayType> selectHolidayType(HolidayTypeSelectVo vo) throws Exception;
	public int selectByName(HolidayTypeSelectVo vo) throws Exception;
	public int addHolidayType(HolidayTypeSelectVo vo) throws Exception;
	public int selectNumber(HolidayTypeSelectVo vo) throws Exception;
	public List<HolidayType> selectAllHolidayType();
	public int updateHolidayType(HolidayTypeSelectVo vo) throws Exception;
	public List<HolidayType> selectHolidayTypeByID(HolidayTypeSelectVo vo) throws Exception;
	public int resetHolidayMark(@Param(value="holidayTypeID") String holidayTypeID) throws Exception;
}
