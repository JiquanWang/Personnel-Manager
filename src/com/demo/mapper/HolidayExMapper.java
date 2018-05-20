package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.Examine;

public interface HolidayExMapper {
	public List<Examine> getAllExamines() throws Exception;
	public void addEx(@Param(value="exid")String exid, @Param(value="tid") String tid,@Param(value="exrid") String exrid) throws Exception;
	public void approve(@Param(value="exid")String exid, @Param(value="tid") String tid,@Param(value="exrid") String exrid) throws Exception;
	public void bohui(@Param(value="tid")String tid, @Param(value="opinion") String opinion) throws Exception;
	public void bohuiReq(@Param(value="tid")String tid) throws Exception;
}
