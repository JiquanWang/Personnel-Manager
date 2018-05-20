package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.vAppedListMapper;
import com.demo.po.Employee;
import com.demo.service.vAppedListService;
import com.demo.vo.vAppedListVo;
@Service
public class vAppedListServiceImpl implements vAppedListService {
	@Autowired
	private vAppedListMapper mapper;

	@Override
	public List<vAppedListVo> selectvAppedList(Employee e) throws Exception {
		// TODO 自动生成的方法存根
		
		return mapper.selectvAppedList(e);
	}

	@Override
	public List<vAppedListVo> chaxun(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.chaxun(vo);
	}

	@Override
	public List<vAppedListVo> chakan1(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.chakan1(vo);
	}

	@Override
	public List<vAppedListVo> chakan2(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.chakan2(vo);
	}	
}
