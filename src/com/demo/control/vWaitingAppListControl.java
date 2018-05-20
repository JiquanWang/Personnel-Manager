package com.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.Employee;
import com.demo.service.HolidayExService;
import com.demo.service.vWaitingAppListService;
import com.demo.vo.vAppedListVo;

@Controller
public class vWaitingAppListControl {
	@Autowired
	private vWaitingAppListService vwa;
	@Autowired
	private HolidayExService hes;
	private List<vAppedListVo> vwl;
	private List<vAppedListVo> vwl1;
	
	@RequestMapping("/vWaitingAppList.action")
	public ModelAndView shenpixiujiachushi
			(ModelAndView mv,vAppedListVo vo,HttpServletRequest req) throws Exception{
		Employee e=(Employee)req.getSession().getAttribute("user");
		System.out.println(e.getEmployeeID());
		vo.setExaminerID(e.getEmployeeID());
		vwl=vwa.shenpixiujiachushi(vo);
		System.out.println(vwl.size());
		mv.addObject("firstlist", vwl);
		mv.setViewName("vWaitingAppList.jsp");
		return mv;
	}
	@RequestMapping("/chaxunxiujiashenpi.action")
	public ModelAndView chaxunxiujiashenpi(ModelAndView mv,
			HttpServletRequest req,vAppedListVo vo) throws Exception{
		vo.setExaminerID(((Employee)req.getSession().getAttribute("user")).getEmployeeID());
		vwl=vwa.chaxunxiujiashenpi(vo);
		mv.addObject("firstlist",vwl);
		mv.setViewName("vWaitingAppList.jsp");
		return mv;
	}
	@RequestMapping("/xiangxi.action")
	public ModelAndView xiangxi(ModelAndView mv,vAppedListVo vo,HttpServletRequest req) 
			throws Exception{
		System.out.println(req.getParameter("id"));
		vo.setTakeOffID(req.getParameter("id"));
		vwl=vwa.xiangxi1(vo);
		vwl1=vwa.xiangxi2(vo);
		if(vwl1.size()!=0){
			mv.addObject("employee",vwl.get(0));
			mv.addObject("employee1", vwl1);
			mv.setViewName("vApprovalDetail.jsp");
			return mv;
		}else{
			mv.addObject("employee",vwl.get(0));
			mv.setViewName("vApprovalDetail.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/bohui.action")
	public ModelAndView bohui(ModelAndView mv,HttpServletRequest req)
			throws Exception{
		System.out.println(req.getParameter("id"));
		String tid = req.getParameter("id");
		String opinion = req.getParameter("opinion");
		System.out.println(opinion);
		hes.bohui(tid, opinion);
		hes.bohuiReq(tid);
		mv.setViewName("vWaitingAppList.action");
		return mv;
	}
	
	@RequestMapping("/bohui1.action")
	public ModelAndView bohui1(ModelAndView mv,HttpServletRequest req)
			throws Exception{
		System.out.println(req.getParameter("id"));
		String tid = req.getParameter("id");
		hes.bohui(tid, null);
		hes.bohuiReq(tid);
		mv.setViewName("vWaitingAppList.action");
		return mv;
	}
	
	
	@RequestMapping("/tongguo.action")
	public ModelAndView tongguo(ModelAndView mv,vAppedListVo vo,HttpServletRequest req) 
			throws Exception{
		
		vo.setTakeOffID(req.getParameter("id"));
		String poi= req.getParameter("Opinion");
		vo.setExamineOpinion(poi);
		vwa.tongguo(vo);
		vo = vwa.tgselectByID(vo);
		if(vo.getExamineLevel()==1 && 
				(vo.getHolidayTypeName().equals("ฤ๊ผู") || vo.getHolidayTypeName().equals("ต๗ะÝผู")) &&
						vo.takeOffDays >= 2){
			vwa.shezhierjishenpi(vo);
			mv.setViewName("vWaitingAppList.action");
			return mv;
		}else{
			vwa.setStatus(vo);
			mv.setViewName("vWaitingAppList.action");
			
			return mv;
		}
	}
	
}
