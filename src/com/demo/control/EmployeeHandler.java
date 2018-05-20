package com.demo.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.Department;
import com.demo.po.EDdetails;
import com.demo.po.EHdetails;
import com.demo.po.Employee;
import com.demo.po.Headship;
import com.demo.service.DeptService;
import com.demo.service.EmployeeService;
import com.demo.service.HeadshipService;
import com.demo.vo.DisplayDepartmentVo;
import com.demo.vo.EDHVo;
import com.demo.vo.EDdetailsVo;
import com.demo.vo.EHdetailsVo;
import com.demo.vo.EmpInfoVo;
import com.demo.vo.EmpRequestVo;
import com.demo.vo.UserInfoVo;
import com.demo.vo.changePasswordVo;

@Controller
public class EmployeeHandler {
	@Autowired
	private EmployeeService es;
	@Autowired
	private DeptService ds;
	@Autowired
	private HeadshipService hs;
	
	@RequestMapping("/empinfo.action")
	public ModelAndView getUserInfo(ModelAndView mv,HttpServletRequest req) throws Exception{
		Employee e = (Employee)req.getSession().getAttribute("user");
		System.out.println(req.getSession().getAttribute("user"));
		System.out.println("进入empinfo.action");
		String eid = e.getEmployeeID();
		List<EDdetailsVo> eds = es.getEDdetails(eid);
		List<EHdetailsVo> hds = es.getEHdetails(eid);
		UserInfoVo ui = es.getUserInfo(eid);
		if(ui != null && !(eds.size() == 0 || eds.isEmpty()) && !(hds.size() == 0 || hds.isEmpty()))
		{
			System.out.println(eds.get(0).getEmployeeName());
			System.out.println(hds.get(0).getEmployeeName());
			mv.addObject("userInfo", ui);
			mv.addObject("edlist", eds);
			mv.addObject("ehlist", hds);
			mv.setViewName("/empinfo.jsp");
			return mv;
		}
		else{
			return null;
		}
	}
	
	@RequestMapping("/getAllEmpInfo.action")
	public ModelAndView getAllEmpInfo(ModelAndView mv) throws Exception{
		List<EmpInfoVo> empInfos = es.getAllEmpInfo();
		List<Department> depts = ds.getAllDept();
		List<Headship> headships = hs.getAllHeadship();
		if(empInfos.size() != 0 && depts.size()!=0 && headships.size()!= 0)
		{
			System.out.println(empInfos.get(0).getEmployeeName());
			System.out.println(depts.get(0).getDepartmentName());
			System.out.println(headships.get(0).getHeadshipName());
			mv.addObject("empInfoList", empInfos);
			mv.addObject("depts", depts);
			mv.addObject("headships", headships);
		}
		mv.setViewName("/emplist.jsp");
		return mv;
	}
	
	
	
	@RequestMapping("/empDetail.action")
	public ModelAndView getEmpInfo(ModelAndView mv, HttpServletRequest req) throws Exception{
		String id = req.getParameter("id");
		System.out.println(id);
		UserInfoVo ui = es.getUserInfo(id);
		List<EDdetailsVo> eds = es.getEDdetails(id);
		List<EHdetailsVo> hds = es.getEHdetails(id);
		if(ui != null && !(eds.size() == 0 || eds.isEmpty()) && !(hds.size() == 0 || hds.isEmpty()))
		{
			System.out.println(eds.get(0).getEmployeeName());
			System.out.println(hds.get(0).getEmployeeName());
			mv.addObject("empInfo", ui);
			mv.addObject("edlist", eds);
			mv.addObject("ehlist", hds);
			mv.setViewName("/viewempinfo.jsp");
			return mv;
		}
		else{
			return null;
		}
	}
	
	
	@RequestMapping("/selectEmp.action")
	public ModelAndView selectEmp(ModelAndView mv,EmpRequestVo vo) throws Exception{
		System.out.println(vo.getEmployeeName());
		System.out.println(vo.getHeadshipName());
		System.out.println(vo.getStartDate());
		List<EmpInfoVo> empInfos = es.selectEmp(vo);
		List<Department> depts = ds.getAllDept();
		List<Headship> headships = hs.getAllHeadship();
		if(empInfos.size() != 0 && depts.size()!=0 && headships.size()!= 0)
		{
			System.out.println(empInfos.get(0).getEmployeeName());
			System.out.println(depts.get(0).getDepartmentName());
			System.out.println(headships.get(0).getHeadshipName());
			mv.addObject("empInfoList", empInfos);
			mv.addObject("depts", depts);
			mv.addObject("headships", headships);
		}
		mv.setViewName("/emplist.jsp");
		return mv;
	}
	
	@RequestMapping("/modifyEmp.action")
	public ModelAndView beforeModify(ModelAndView mv, HttpServletRequest req) throws Exception{
		String id = req.getParameter("id");
		System.out.println(id);
		Employee e = es.getEmpPoInfo(id);
		if(e != null)
		{
			mv.addObject("empInfo", e);
			mv.setViewName("/modifyEmp.jsp");
			return mv;
		}
		else{
			return null;
		}
	}
	
	@RequestMapping("/updateEmp.action")
	public ModelAndView updateEmp(ModelAndView mv, Employee e) throws Exception{
		System.out.println(e.getEmployeeName());
		System.out.println(e.getUsername());
		System.out.println(e.getPower());
		System.out.println(e.getPassword());
		System.out.println(e.getEmployeeID());
		String username = e.getUsername();
		/*int flag1 = es.getEmpByUsername(username);*/
		es.updateEmp(e);
		/*if(flag1 == 0&& flag2==1)
		{
			mv.addObject("flag",1);
		}
		else
		{
			mv.addObject("flag", 0);
		}*/
		mv.setViewName("getAllEmpInfo.action");
		return mv;
	}
	
	@RequestMapping("/beforeAdd.action")
	public ModelAndView beforeAdd(ModelAndView mv) throws Exception{
		List<Department> depts = ds.getAllDept();
		List<Headship> headships = hs.getAllHeadship();
		mv.addObject("depts", depts);
		mv.addObject("headships", headships);
		mv.setViewName("/addEmp.jsp");
		return mv;
	}
	
	@RequestMapping("/addEmp.action")
	public ModelAndView addEmp(ModelAndView mv, Employee e) throws Exception{
		EDdetails ed = new EDdetails();
		EHdetails eh = new EHdetails();
		int num = es.getEmpNum();
		int ednum = ds.getAllEDdetails();
		int ehnum = hs.getAllEHdetails();
		e.setEmployeeID(Integer.toString(num+1));
		
		//添加员工部门表，新员工入职
		ed.setEDdetailsID(Integer.toString(ednum+1));
		ed.setEmployeeID(e.getEmployeeID());
		ed.setDepartmentID(e.getDepartmentID());
		ed.setStartDate(e.getHiredate());
		ed.setEndDate(null);
		
		//添加员工职位表
		eh.setEHdetailsID(Integer.toString(ehnum+1));
		eh.setEmployeeID(e.getEmployeeID());
		eh.setHeadshipID(e.getHeadshipID());
		eh.setStartDate(e.getHiredate());
		eh.setEndDate(null);
		

		
		//数据库四个添加操作
		es.addEmp(e);
		System.out.println("1操作了");
		ds.addEDdetail(ed);
		System.out.println("2操作了");
		hs.addEHdetail(eh);
		System.out.println("3操作了");
		es.addRdays(e.getEmployeeID());
		System.out.println("4操作了");
		mv.setViewName("getAllEmpInfo.action");
		return mv;
	}
	
	@RequestMapping("/resetEmpMark.action")
	public ModelAndView resetEmpMark(ModelAndView mv, HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("employeeID");
		System.out.println(id);
		es.changeEmpMark(id);
		mv.setViewName("getAllEmpInfo.action");
		return mv;
	}
	
	@RequestMapping("/beforeChange.action")
	public ModelAndView beforeChange(ModelAndView mv, HttpServletRequest req) throws Exception{
		String id = req.getParameter("id");
		System.out.println(id);
		EDHVo v = es.getEDHVOInfo(id);
		List<Department> depts = ds.getOtherDept(id);
		List<Headship> headships = hs.getOtherHeadship(id);
		if(v != null  && depts.size()!=0 && headships.size()!= 0)
		{
			mv.addObject("emp",v);
			mv.addObject("depts", depts);
			mv.addObject("headships", headships);
			mv.setViewName("/changeEmp.jsp");
			return mv;
		}
		return null;
	}
	
	@RequestMapping("/changeDept.action")
	public ModelAndView changeDept(ModelAndView mv, Employee e) throws Exception{
		System.out.println(e.getDepartmentID());
		System.out.println(e.getEmployeeID());
		System.out.println(e.getHeadshipID());
		ds.changeDept(e.getEmployeeID(), e.getDepartmentID());
		mv.setViewName("beforeChange.action?id="+e.getEmployeeID());
		return mv;
	}
	
	@RequestMapping("/changeHeadship.action")
	public ModelAndView changeHeadship(ModelAndView mv, Employee e) throws Exception{
		System.out.println(e.getDepartmentID());
		System.out.println(e.getEmployeeID());
		System.out.println(e.getHeadshipID());
		hs.changeHeadship(e.getEmployeeID(), e.getHeadshipID());
		mv.setViewName("beforeChange.action?id="+e.getEmployeeID());
		return mv;
	}
}
