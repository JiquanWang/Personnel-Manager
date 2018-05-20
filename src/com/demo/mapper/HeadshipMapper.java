package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.Department;
import com.demo.po.EHdetails;
import com.demo.po.Headship;

public interface HeadshipMapper {
	public List<Headship> getAllHeadship() throws Exception;
	public List<EHdetails> getAllEHdetails() throws Exception;
	public void addEHdetail(EHdetails eh) throws Exception;
	public List<Headship> getOtherHeadship(@Param(value="id") String id) throws Exception;
	public void changeHeadship(@Param(value="eid") String eid,@Param(value="hid") String hid) throws Exception;
}
