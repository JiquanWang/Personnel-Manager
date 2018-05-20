package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.vWaitingAppListServiceMapper;
import com.demo.service.vWaitingAppListService;
import com.demo.vo.vAppedListVo;
@Service
public class vWaitingAppListServiceImpl implements vWaitingAppListService {
	@Autowired
	private vWaitingAppListServiceMapper mapper;
	@Override
	public List<vAppedListVo> shenpixiujiachushi(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.shenpixiujiachushi(vo);
	}
	@Override
	public List<vAppedListVo> chaxunxiujiashenpi(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.chaxunxiujiashenpi(vo);
	}
	@Override
	public List<vAppedListVo> xiangxi1(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.xiangxi1(vo);
	}
	@Override
	public List<vAppedListVo> xiangxi2(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.xiangxi2(vo);
	}
	
	public vAppedListVo tgselectByID(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.tgselectByID(vo);
	}
	
	@Override
	public int tongguo(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		return mapper.tongguo(vo);
	}
	@Override
	public int shezhierjishenpi(vAppedListVo vo) throws Exception {
		// TODO 自动生成的方法存根
		vo.setExamineTableID(String.valueOf(mapper.tableID()+1));
		return mapper.shezhierjishenpi(vo);
	}
	@Override
	public int setStatus(vAppedListVo vo) throws Exception {
		
		return mapper.setStatus(vo);
	}

}
