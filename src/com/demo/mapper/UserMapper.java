package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.Employee;
import com.demo.po.Headship;
import com.demo.vo.UserInfoVo;
import com.demo.vo.UserLoginVo;
import com.demo.vo.changePasswordVo;
import com.demo.vo.seeVo;
import com.demo.vo.selectHeadshipVo;

public interface UserMapper {
	public List<Employee> getAllEmployee() throws Exception;
	public List<Employee> userLogin(UserLoginVo vo) throws Exception;
	public int passwordConform(@Param(value="oldPass") String oldPass, @Param(value="id")String id) throws Exception;
	public void changePassword(@Param(value="newPass") String newPass, @Param(value="id")String id) throws Exception;
	
	//增加用户
		public int getHeadshipID() throws Exception;
		public List<Headship> getAllHeadship() throws Exception;
		public int addHeadship(selectHeadshipVo vo) throws Exception;
		
		public List<Headship> selectHeadship(selectHeadshipVo vo) throws Exception;
		public List<Headship> selectAllHeadship(selectHeadshipVo vo) throws Exception;
		
		public List<seeVo> chakan1(selectHeadshipVo vo) throws Exception;
		public List<selectHeadshipVo> chakan2(selectHeadshipVo vo) throws Exception;
		
		public int huifu(selectHeadshipVo vo) throws Exception;
		public int huifu1(selectHeadshipVo vo) throws Exception;
		
		public int update(selectHeadshipVo vo) throws Exception;
		public int selectByName(selectHeadshipVo vo) throws Exception;
}
