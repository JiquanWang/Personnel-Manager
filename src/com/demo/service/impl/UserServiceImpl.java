package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.UserMapper;
import com.demo.po.Employee;
import com.demo.service.UserService;
import com.demo.vo.UserInfoVo;
import com.demo.vo.UserLoginVo;
import com.demo.vo.changePasswordVo;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	private UserInfoVo uivo;
	
	public List<Employee> getAllEmployee() throws Exception {
		return mapper.getAllEmployee();
	}
	
	//获取得到的表单，应该只有一个或零个，所以获取第一个值返回给control层
	public Employee userLogin(UserLoginVo vo) throws Exception{
		List<Employee> es = mapper.userLogin(vo);
		if(es.isEmpty() || es.size() == 0)
		{
			return null;
		}
		else{
			return es.get(0);
		}
		
	}
	
	public int changePassConform(changePasswordVo vo, String id) throws Exception{
		if(!vo.getN_pass1().equals(vo.getN_pass2()))
		{
			System.out.println(vo.getN_pass1());
			System.out.println(vo.getN_pass2());
			System.out.println("两次密码不一致！");
			return -1;
		}
		else if(mapper.passwordConform(vo.getO_pass(), id) == 0)
		{
			System.out.println("原密码不正确！");
			return 0;
		}
		else
		{
			mapper.changePassword(vo.getN_pass1(), id);
			return 1;
		}
	}
}
