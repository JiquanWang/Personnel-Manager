package com.demo.service;

import java.util.List;

import com.demo.po.Employee;
import com.demo.vo.vAppedListVo;

public interface vAppedListService {

	public List<vAppedListVo> selectvAppedList(Employee e) throws Exception;
	public List<vAppedListVo> chaxun(vAppedListVo vo) throws Exception;
	public List<vAppedListVo> chakan1(vAppedListVo vo) throws Exception;
	public List<vAppedListVo> chakan2(vAppedListVo vo) throws Exception;


}
