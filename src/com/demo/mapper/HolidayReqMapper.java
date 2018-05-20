package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.HolidayType;
import com.demo.po.Rdays;
import com.demo.po.Request;
import com.demo.vo.HolidayRequestVo;

public interface HolidayReqMapper {
	public List<HolidayType> getAllTypes() throws Exception;
	public List<Rdays> getRemain(@Param(value="eid") String eid, @Param(value="hoid") String hoid) throws Exception;
	public List<Request> getAllReq() throws Exception;
	public void addReq(HolidayRequestVo vo) throws Exception;
	public void updateRdays(Rdays rd) throws Exception;
}
