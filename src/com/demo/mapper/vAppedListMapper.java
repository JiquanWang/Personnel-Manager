package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.Employee;
import com.demo.vo.vAppedListVo;

public interface vAppedListMapper {

	public List<vAppedListVo> selectvAppedList(Employee e) throws Exception;
	public List<vAppedListVo> chaxun(vAppedListVo vo) throws Exception;
	public List<vAppedListVo> chakan1(vAppedListVo vo) throws Exception;
	public List<vAppedListVo> chakan2(vAppedListVo vo) throws Exception;

}
