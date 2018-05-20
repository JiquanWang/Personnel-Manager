package com.demo.service;

import java.util.List;

import com.demo.po.Headship;
import com.demo.vo.seeVo;
import com.demo.vo.selectHeadshipVo;

public interface selectHeadshipService {
	
	public List<Headship> getAllHeadship() throws Exception;
	public int addHeadship(selectHeadshipVo vo) throws Exception;
	public int getHeadshipID() throws Exception;
	
	public List<Headship> selectHeadship(selectHeadshipVo vo) throws Exception;
	public List<Headship> selectAllHeadship(selectHeadshipVo vo) throws Exception;
	
	public List<seeVo> chakan1(selectHeadshipVo vo) throws Exception;
	public List<selectHeadshipVo> chakan2(selectHeadshipVo vo) throws Exception;
	
	public int huifu(selectHeadshipVo vo) throws Exception;
	public int huifu1(selectHeadshipVo vo) throws Exception;
	public int update(selectHeadshipVo vo) throws Exception;
	public int selectByName(selectHeadshipVo vo) throws Exception;
	
}
