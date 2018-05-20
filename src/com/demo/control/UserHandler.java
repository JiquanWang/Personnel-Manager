package com.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.mapper.UserMapper;
import com.demo.po.Employee;
import com.demo.service.UserService;
import com.demo.vo.UserInfoVo;
import com.demo.vo.UserLoginVo;
import com.demo.vo.changePasswordVo;

@Controller
public class UserHandler {
	@Autowired
	private UserService us;
	
	@RequestMapping("/login.action")
	public ModelAndView login(ModelAndView mv, UserLoginVo vo,HttpServletRequest req) throws Exception{
		System.out.println(vo.getUsername());
		System.out.println(vo.getPassword());
		Employee e  = us.userLogin(vo);
		HttpSession session = req.getSession();
		if(e != null){
			System.out.println(e.getEmployeeID());
			session.setAttribute("user", e);
			mv.setViewName("/main.jsp");
		}
		else
		{
			System.out.println("ÃÜÂë´íÎó£¬µÇÂ½Ê§°Ü");
			mv.setViewName("/login.jsp");
		}
		return mv;
	}

	@RequestMapping("/changePassword.action")
	public ModelAndView changePassword(ModelAndView mv, changePasswordVo vo,HttpServletRequest req) throws Exception{
		Employee e = (Employee)req.getSession().getAttribute("user");
		System.out.println("½øÈëaction");
		int result = us.changePassConform(vo,e.getEmployeeID());
		if(result == 1)
		{
			System.out.println("ÐÞ¸Ä³É¹¦£¡");
			mv.setViewName("/main.jsp");
		}
		else{
			mv.setViewName("/changePassword.jsp");
		}
		return mv;
	}
}
