package com.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.Employee;
import com.demo.service.vAppedListService;
import com.demo.vo.vAppedListVo;

@Controller
public class vAppedListControler {
	@Autowired
	private vAppedListService vas;
	private List<vAppedListVo> val;
	private List<vAppedListVo> val1;
	@RequestMapping("/ApprovalRecord.action")
	public ModelAndView vAppedListService(ModelAndView mv,
			HttpServletRequest req,vAppedListVo vo) throws Exception{
		Employee e=(Employee)req.getSession().getAttribute("user");
		val=vas.selectvAppedList(e);
		mv.addObject("employee",val);
		mv.setViewName("vAppedList.jsp");
		return mv;		
	}
	@RequestMapping("/chaxun.action")
	public ModelAndView chaxun(ModelAndView mv,
			HttpServletRequest req,vAppedListVo vo) throws Exception{
		vo.setExaminerID(((Employee)req.getSession().getAttribute("user")).getEmployeeID());
		val=vas.chaxun(vo);
		mv.addObject("employee",val);
		mv.setViewName("vAppedList.jsp");
		return mv;
	}
	@RequestMapping("/chakan3.action")
	public ModelAndView chakun(ModelAndView mv,vAppedListVo vo,HttpServletRequest req) 
			throws Exception{
		vo.setTakeOffID(req.getParameter("id"));
		val=vas.chakan1(vo);
		vAppedListVo vo1=val.get(0);
		val1=vas.chakan2(vo);
		if(val1.size()!=0){
			mv.addObject("employee",vo1);
			mv.addObject("employee1", val1);
			mv.setViewName("vVocationDetail.jsp");
			return mv;
		}else{
			mv.addObject("employee",vo1);
			mv.setViewName("vVocationDetail.jsp");
			return mv;
		}
	}
}
