package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.vo.DisplayHolidayVo;
import com.demo.vo.SelectHolidayVo;
import com.demo.vo.TakeOffDetailsVo;
import com.demo.vo.TakeOffExamineVo;

public interface SelectHolidayMapper {
	public List<DisplayHolidayVo> selectHolidayList(SelectHolidayVo vo) throws Exception;
	public TakeOffDetailsVo selectTakeOffDetails(@Param(value="takeOffID") String takeOffID) throws Exception;
	public List<TakeOffExamineVo> selectTakeOffExamine(@Param(value="takeOffID") String takeOffID) throws Exception;
}
