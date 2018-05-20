package com.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.Headship;
import com.demo.service.selectHeadshipService;
import com.demo.vo.seeVo;
import com.demo.vo.selectHeadshipVo;

@Controller
public class selectHeadshipController {
	@Autowired
	private selectHeadshipService shs;
	private List<Headship> asd;
	private List<seeVo> qwe;
	private List<selectHeadshipVo> vox;
	
	private String s;
	private int i;
	
	@RequestMapping("/addHeadship.action")
	public ModelAndView addHeadship(ModelAndView mv, selectHeadshipVo vo) throws Exception{

		if(shs.selectByName(vo)==0){
			i = shs.getHeadshipID()+1;
			s = Integer.toString(i);
			vo.setHeadshipID(s);
			shs.addHeadship(vo);	
			mv.addObject("a",1);
			mv.setViewName("addJob.jsp");
			return mv;
		}else{
			mv.addObject("a",0);
			mv.setViewName("addJob.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/findHeadship.action")
	public ModelAndView selectHeadship(ModelAndView mv,selectHeadshipVo vo) throws Exception{
		System.out.println(vo.getHeadshipName());
		asd=shs.selectHeadship(vo);
		
		if(!(asd.isEmpty()) && (asd.size() != 0)){
			mv.addObject("list",asd);
			mv.setViewName("/joblist.jsp");
			return mv;
		}
		else
		{
			System.out.println("密码错误，登陆失败");
			mv.setViewName("/joblist.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/selectAllHeadship.action")
	public ModelAndView selectAllHeadship(ModelAndView mv,selectHeadshipVo vo) throws Exception{
		System.out.println("selectAllHeadship");
		asd=shs.selectAllHeadship(vo);
		if(!(asd.isEmpty()) && (asd.size() != 0)){
			System.out.println(asd.size());
			mv.addObject("list",asd);
			mv.setViewName("/joblist.jsp");
			return mv;
		}else{
			System.out.println("在看到这个你就是沙雕");
			mv.setViewName("/joblist.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/chakan.action")
	public ModelAndView chakan(ModelAndView mv,HttpServletRequest req,selectHeadshipVo vo) throws Exception{
		
		String id= req.getParameter("id");
		System.out.println(id);
		vo.setHeadshipID(id);
		System.out.println("id"+vo.getHeadshipID());
		vox=shs.chakan2(vo);
		qwe=shs.chakan1(vo);
		if(!(qwe.isEmpty()) && (qwe.size() != 0)){
			mv.addObject("alist",vox);
			mv.addObject("blist",qwe);
			mv.setViewName("viewjobinfo.jsp");
			return mv;
		}else{
			mv.addObject("alist",vox);
			mv.setViewName("viewjobinfo.jsp");
			return mv;
		}
	}

	@RequestMapping("/xiugai.action")
	public ModelAndView xiugai(ModelAndView mv,HttpServletRequest req) throws Exception{
		selectHeadshipVo vo = new selectHeadshipVo();
		vo.setHeadshipID(req.getParameter("id"));
		vo=shs.chakan2(vo).get(0);
		mv.addObject("modifyjob",vo);
		mv.setViewName("/modifyJob.jsp");
		return mv;
	}
	@RequestMapping("/huifu.action")
	public ModelAndView huifu(ModelAndView mv,HttpServletRequest req) throws Exception{
		selectHeadshipVo vo = new selectHeadshipVo();
		vo.setHeadshipID(req.getParameter("id"));
        vo=shs.chakan2(vo).get(0);
		if(vo.getHeadshipMark().equals("活动")){
			shs.huifu(vo);
		}else{
			shs.huifu1(vo);
		}
		
		asd=shs.selectAllHeadship(vo);
		if(!(asd.isEmpty()) && (asd.size() != 0)){
			System.out.println(asd.size());
			mv.addObject("list",asd);
			mv.setViewName("/joblist.jsp");
			return mv;
		}else{
			mv.setViewName("/joblist.jsp");
			return mv;
		}
	}
	@RequestMapping("/xiugai1.action")
	public ModelAndView xiugai1(ModelAndView mv,selectHeadshipVo vo,HttpServletRequest req) throws Exception{
		/*vo.setHeadshipID(req.getParameter("id"));*/
		if(shs.selectByName(vo)==0){
			System.out.println("size");
			mv.addObject("a",1);
			shs.update(vo);
			mv.setViewName("/modifyJob.jsp");
			return mv;
		}else{
			mv.addObject("a",0);
			mv.addObject("modifyjob",vo);
			mv.setViewName("/modifyJob.jsp");
			return mv;
		}
	}
}
