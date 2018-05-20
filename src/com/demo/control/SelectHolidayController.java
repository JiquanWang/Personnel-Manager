package com.demo.control;

import java.util.List;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.Employee;
import com.demo.service.SelectHolidayService;
import com.demo.vo.DisplayHolidayVo;
import com.demo.vo.SelectHolidayVo;
import com.demo.vo.TakeOffDetailsVo;
import com.demo.vo.TakeOffExamineVo;

@Controller
public class SelectHolidayController {
	@Autowired
	private SelectHolidayService shs;
	
	@RequestMapping("/selectHolidayList.action")
	public ModelAndView selectHolidayList(ModelAndView mv,SelectHolidayVo vo,HttpServletRequest req) throws Exception{
		Employee e = (Employee)req.getSession().getAttribute("user");
		vo.setEmployeeID(e.getEmployeeID());
		List<DisplayHolidayVo> hlist = shs.selectHolidayList(vo);
		mv.addObject("hlist", hlist);
		mv.setViewName("/vMyVocation.jsp");
		return mv;
	}
	
	@RequestMapping("/initHolidayList.action")
	public ModelAndView initHolidayList(ModelAndView mv,HttpServletRequest req) throws Exception{
		Employee e = (Employee)req.getSession().getAttribute("user");
		SelectHolidayVo vo = new SelectHolidayVo();
		vo.setEmployeeID(e.getEmployeeID());
		List<DisplayHolidayVo> hlist = shs.selectHolidayList(vo);
		mv.addObject("hlist", hlist);
		mv.setViewName("/vMyVocation.jsp");
		return mv;
	}
	
	@RequestMapping("/takeOffDetails.action")
	public ModelAndView takeOffDetails(ModelAndView mv,HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		String takeOffID = req.getParameter("takeOffID");
		System.out.println(takeOffID);
		TakeOffDetailsVo todv = shs.selectTakeOffDetails(takeOffID);
		List<TakeOffExamineVo> ltoev = shs.selectTakeOffExamine(takeOffID);
		System.out.println(todv.getApplyDay());
		mv.addObject("todv", todv);
		mv.addObject("ltoev", ltoev);
		mv.setViewName("/vReqVocationDetail.jsp");
		return mv;
	}
}
