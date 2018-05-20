package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.vo.vAppedListVo;

public interface vWaitingAppListServiceMapper {


	public List<vAppedListVo> shenpixiujiachushi(vAppedListVo vo) throws Exception;

	public List<vAppedListVo> chaxunxiujiashenpi(vAppedListVo vo) throws Exception;

	public List<vAppedListVo> xiangxi1(vAppedListVo vo) throws Exception;

	public List<vAppedListVo> xiangxi2(vAppedListVo vo) throws Exception;
	
	public vAppedListVo tgselectByID(vAppedListVo vo) throws Exception;
	
	public int tongguo(vAppedListVo vo) throws Exception;

	public int shezhierjishenpi(vAppedListVo vo) throws Exception;
	
	public int tableID() throws Exception;

	public int setStatus(vAppedListVo vo) throws Exception;
	

}
