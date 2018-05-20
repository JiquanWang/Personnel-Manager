package com.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.Headship;
import com.demo.po.HolidayType;
import com.demo.service.SelectHolidayTypeService;
import com.demo.service.selectHeadshipService;
import com.demo.vo.DisplayDepartmentVo;
import com.demo.vo.HolidayTypeSelectVo;
import com.demo.vo.seeVo;
import com.demo.vo.selectHeadshipVo;
@Controller
public class HolidayController {
	@Autowired
	private SelectHolidayTypeService shs;
	
	@RequestMapping("/before.action")
	public ModelAndView selectAllHolidayType(ModelAndView mv) throws Exception{
		List<HolidayType> po=shs.selectAllHolidayType();
		mv.addObject("list", po);
		mv.setViewName("/vtypelist.jsp");
		return mv;
	}
	@RequestMapping("/selectHoliday.action")
	public ModelAndView selectHolidayType(ModelAndView mv,HolidayTypeSelectVo vo) throws Exception{
		System.out.println("什么鬼");
		List<HolidayType> po=shs.selectHolidayType(vo);
		System.out.println(po.get(0).getHolidayTypeName());
		
		if(!(po.isEmpty()) && (po.size() != 0)){
			mv.addObject("list",po);
			mv.setViewName("/vtypelist.jsp");
			return mv;
		}
		else
		{
			mv.setViewName("/vtypelist.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/vAddType.action")
	public ModelAndView addHolidayType(ModelAndView mv, HolidayTypeSelectVo vo) throws Exception{
		System.out.println("进来啦");
		if(shs.selectByName(vo)==0){
			int i = shs.selectNumberofType(vo)+1;
			String s = Integer.toString(i);
			vo.setHolidayTypeID(s);
			shs.addHolidayType(vo);	
			mv.addObject("a",1);
			mv.setViewName("/before.action");
			return mv;
		}else{
			mv.addObject("a",0);
			mv.setViewName("/before.action");
			return mv;
		}
	} 
	@RequestMapping("/updateHoliday.action")
	public ModelAndView updateHoliday(ModelAndView mv, HttpServletRequest req) throws Exception {
		HolidayTypeSelectVo vo = new HolidayTypeSelectVo();
		vo.setHolidayTypeID(req.getParameter("id"));
		HolidayType vo1=shs.selectHolidayTypeByID(vo).get(0);
		mv.addObject("list1",vo1);
		mv.setViewName("/UpdateHolidayType.jsp");
		return mv;
		
		/*vo.setHolidayTypeID(req.getParameter("id"));
		System.out.println("到这了吗？");
		List<HolidayType> po = shs.selectHolidayTypeByID(vo);
		System.out.println("到这了吗？");
		mv.addObject("list1",po);
		mv.setViewName("UpdateHolidayType.jsp");
		return mv;*/
	}
	@RequestMapping("/vUpdate.action")
	public ModelAndView updateHoliday(ModelAndView mv, HolidayTypeSelectVo vo) throws Exception {
		if(shs.updateHolidayType(vo) == 1){
			System.out.println("修改成功！");
			mv.addObject("list",1);
			mv.setViewName("/before.action");
		}else{
			System.out.println("修改失败！");
			mv.setViewName("UpdateHolidayType.jsp");
		}
		return mv;
	}
	@RequestMapping("/changeStatus.action")
	public ModelAndView resetDepartmentMark(ModelAndView mv, HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		String holidayTypeID = req.getParameter("id");
		int i = shs.resetHolidayMark(holidayTypeID);
		List<HolidayType> dt = shs.selectAllHolidayType();
		mv.addObject("list", dt);
		mv.setViewName("/vtypelist.jsp");
		return mv;
	}
}
