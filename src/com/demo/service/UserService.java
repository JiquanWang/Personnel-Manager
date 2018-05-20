package com.demo.service;

import java.util.List;

import com.demo.po.Employee;
import com.demo.vo.UserInfoVo;
import com.demo.vo.UserLoginVo;
import com.demo.vo.changePasswordVo;

public interface UserService {
	public List<Employee> getAllEmployee() throws Exception;
	public Employee userLogin(UserLoginVo vo) throws Exception;
	public int changePassConform(changePasswordVo vo, String id) throws Exception;
}
