package com.demo.control;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.mapper.DepartmentMapper;
import com.demo.po.Department;
import com.demo.po.Employee;
import com.demo.service.DepartmentService;
import com.demo.service.EmployeeService;
import com.demo.vo.UpdateDepartmentVo;
import com.demo.vo.DepartmentDetailsVo;
import com.demo.vo.DepartmentEmployeeVo;
import com.demo.vo.DisplayDepartmentVo;
import com.demo.vo.EmpInfoVo;
import com.demo.vo.SelectDepartmentVo;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService ds;
	
	@Autowired
	private EmployeeService es;
	
	@RequestMapping("/selectDepartment.action")
	public ModelAndView selectDepartment(ModelAndView mv, SelectDepartmentVo vo) throws Exception{
		System.out.println(vo.getDepartmentName());
		System.out.println(vo.getDepartmentMark());
		List<DisplayDepartmentVo> dt = ds.selectDeparment(vo);
		if(!dt.isEmpty() && dt.size() != 0){
			System.out.println(dt.get(0).getDepartmentID());
		}
		mv.addObject("dlist", dt);
		mv.setViewName("/deptlist.jsp");
		return mv;
	}
	
	@RequestMapping("/getAllDepartment.action")
	public ModelAndView getAllDepartment(ModelAndView mv) throws Exception{
		List<DisplayDepartmentVo> dt = ds.selectAllDepartment();
		mv.addObject("dlist", dt);
		mv.setViewName("/addDept.jsp");
		return mv;
	}
	
	@RequestMapping("/addDepartment.action")
	public ModelAndView addDepartment(ModelAndView mv, UpdateDepartmentVo vo) throws Exception{
		System.out.println(vo.getDepartmentName());
		int departmentNo;
		String id;
		departmentNo = ds.getDepartmentID() + 1;
		id = Integer.toString(departmentNo);
		vo.setDepartmentID(id);
		System.out.println(vo.getDepartmentID());
		vo.setNewdate(new Date(System.currentTimeMillis()));
		System.out.println(vo.getFatherDepartmentID());
		if(vo.getFatherDepartmentID().equals("noUplevel")){
			System.out.println("yes");
			vo.setFatherDepartmentID(null);
		}
		int flag = ds.addDepartment(vo);
		System.out.println(flag);
		if(flag != 0){
			System.out.println("添加成功！");
			mv.addObject("flag", flag);
			mv.setViewName("/addDept.jsp");
			return mv;
		}else{
			System.out.println("添加失败！");
			return null;
		}
	}
	
	@RequestMapping("/initDepartment.action")
	public ModelAndView initDepartment(ModelAndView mv) throws Exception{
		List<DisplayDepartmentVo> dt = ds.selectAllDepartment();
		mv.addObject("dlist", dt);
		mv.setViewName("/deptlist.jsp");
		return mv;
	}
	
	@RequestMapping("/departmentDetails.action")
	public ModelAndView departmentDetails(ModelAndView mv, HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		String departmentID = req.getParameter("departmentID");
		System.out.println(departmentID);
		DepartmentDetailsVo ddv = ds.selectDepartmentDetails(departmentID);
		List<DepartmentEmployeeVo> ldev = ds.selectDepartmentEmployee(departmentID);
		if(!(ldev.isEmpty()) && (ldev.size() != 0)){
			mv.addObject("ddv",ddv);
			mv.addObject("ldev",ldev);
			mv.setViewName("/viewdeptinfo.jsp");
			return mv;
		}else{
			ddv.setNumberOfEmployee(0);
			mv.addObject("ddv",ddv);
			mv.setViewName("/viewdeptinfo.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/initUpdateDepartment.action")
	public ModelAndView initUpdateDepartment(ModelAndView mv, HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		String departmentID = req.getParameter("departmentID");
		System.out.println(departmentID);
		DepartmentDetailsVo ddv = ds.selectDepartmentDetails(departmentID);
		System.out.println(ddv.getDepartmentName());
		List<DisplayDepartmentVo> dt = ds.selectAllDepartment();
		mv.addObject("dlist", dt);
		mv.addObject("ddv", ddv);
		mv.setViewName("/modifydept.jsp");
		return mv;
	}
	@RequestMapping("/updateDepartment.action")
	public ModelAndView updateDepartment(ModelAndView mv, UpdateDepartmentVo vo) throws Exception{
		vo.setNewdate(new Date(System.currentTimeMillis()));
		System.out.println(vo.getFatherDepartmentID());
		if(vo.getFatherDepartmentID().equals("noUplevel")){
			System.out.println("yes");
			vo.setFatherDepartmentID(null);
		}
		int flag = ds.updateDepartment(vo);
		System.out.println(flag);
		if(flag != 0){
			System.out.println("修改成功！");
			mv.addObject("flag", flag);
			mv.setViewName("/modifydept.jsp");
			return mv;
		}else{
			System.out.println("修改失败！");
			return null;
		}
	}
	@RequestMapping("/resetDepartmentMark.action")
	public ModelAndView resetDepartmentMark(ModelAndView mv, HttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		String departmentID = req.getParameter("departmentID");
		ds.resetDepartmentMark(departmentID);
		List<DisplayDepartmentVo> dt = ds.selectAllDepartment();
		mv.addObject("dlist", dt);
		mv.setViewName("/deptlist.jsp");
		return mv;
	}
	@RequestMapping("/searchEmpName.action")
	@ResponseBody
	public Employee getNameByID(String employeeID) throws Exception{
		System.out.println(employeeID);
		Employee e = es.getEmpPoInfo(employeeID);
		if(e == null)
		{
			e =new Employee();
			e.setEmployeeName("error");
		}
		System.out.println(e.getEmployeeName());
		return e;
	}
}
