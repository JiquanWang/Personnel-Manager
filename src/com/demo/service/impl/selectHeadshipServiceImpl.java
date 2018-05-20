package com.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.UserMapper;
import com.demo.po.Headship;
import com.demo.service.selectHeadshipService;
import com.demo.vo.seeVo;
import com.demo.vo.selectHeadshipVo;
@Service
public class selectHeadshipServiceImpl implements selectHeadshipService{
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<Headship> getAllHeadship() throws Exception {
		// TODO 自动生成的方法存根
		return mapper.getAllHeadship();
	}

	@Override
	public int addHeadship(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.addHeadship(vo);
	}

	@Override
	public int getHeadshipID() throws Exception {
		// TODO 自动生成的方法存根
		return mapper.getHeadshipID();
	}
	
	@Override
	public List<Headship> selectHeadship(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("service执行成功");
		System.out.println(vo.getHeadshipName()+"service");
		return mapper.selectHeadship(vo);
	}
	@Override
	public List<Headship> selectAllHeadship(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("selectAllHeadship");
		return mapper.selectAllHeadship(vo);
	}
	@Override
	public List<seeVo> chakan1(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("chakan1");
		return mapper.chakan1(vo);
	}
	@Override
	public List<selectHeadshipVo> chakan2(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("chakan2");
		return mapper.chakan2(vo);
	}
	@Override
	public int huifu(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.huifu(vo);
	}
	@Override
	public int huifu1(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.huifu1(vo);
	}
	@Override
	public int update(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.update(vo);
	}
	@Override
	public int selectByName(selectHeadshipVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.selectByName(vo);
	}
	
}
