package com.demo.control;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.po.HolidayType;
import com.demo.po.Rdays;
import com.demo.service.DeptService;
import com.demo.service.EmployeeService;
import com.demo.service.HolidayExService;
import com.demo.service.HolidayReqService;
import com.demo.vo.HolidayRequestVo;

@Controller
public class HolidayRequestController {
	@Autowired
	private HolidayReqService hos;
	@Autowired
	private HolidayExService hes;
	@Autowired
	private DeptService ds;
	@Autowired
	private EmployeeService es;
	
	@RequestMapping("/beforeHolidayReq.action")
	public ModelAndView getHolidayList(ModelAndView mv) throws Exception{
		List<HolidayType> holist = hos.getAllTypes();
		if(holist.size() != 0 && !holist.isEmpty())
		{
			System.out.println(holist.get(0).getHolidayTypeName());
			mv.addObject("holist", holist);
		}
		mv.setViewName("/vAddVocation.jsp");
		return mv;
	}
	@RequestMapping("/getRemainDays.action")
	@ResponseBody
	public Integer getRemainDays(String employeeID, String holidayTypeID) throws Exception
	{
		int i =hos.getRemain(employeeID, holidayTypeID);
		if(i == -1) return null;
		else return i;
	}
	
	@RequestMapping("/reqSubmit.action")
	public ModelAndView submitReq(ModelAndView mv, HolidayRequestVo vo) throws Exception{
		System.out.println(vo.getEmployeeID());
		System.out.println(vo.getHolidayTypeID());
		System.out.println(vo.getStartDay());
		vo.setApplyDay(new java.util.Date(System.currentTimeMillis()));
		//得到当前请假单id，并传入vo类中
		int takeOffID = hos.getReqNum() + 1;
		vo.setTakeOffID(Integer.toString(takeOffID));
		//添加请假数据库中
		hos.addReq(vo);
		
		
		//二、添加审批记录
		//1. 获取审批表当前id
		int exid = hes.getExNum() + 1;
		String examineTableID = Integer.toString(exid);
		//2.获取请假单id
		String tid = Integer.toString(takeOffID);
		System.out.println("jkjdlkjdkjfdkfdjksjfkjfdkjdfkdj"+tid);
		//3.1获取部门主管id
		String exrid = ds.getMan(vo.getEmployeeID());
		System.out.println(exrid);
		System.out.println(vo.getEmployeeID());
		if(exrid.equals(vo.getEmployeeID())){
			//当部门的主管是自己时,根据本部门id查找其上级部门
			
			//获取所在部门id
			String did = es.getDeptID(vo.getEmployeeID());
			System.out.println("。。。。。。。你所在的部门是........"+did);
			//查找上级部门主管ID
			String mid = ds.getUpperDeptManID(did);
			System.out.println("................上级部门主管是"+mid);
			if(mid == null)
			{
				//没有上级部门，直接审批通过，不用再给别人审批了
				System.out.println("自己审批自己 通过了");
				hes.approve(examineTableID, tid, exrid);
			}
			else
			{
				//交给上级部门主管审批
				System.out.println("给上级部门审批，待定");
				hes.addEx(examineTableID, tid, mid);
			}
		} 
		else{
			//交给部门主管审批
			System.out.println("给你的主管审批去吧");
			hes.addEx(examineTableID, tid, exrid);
		}
		
		//三、根据类型减去剩余天数
		String remain = vo.getRemain();
		System.out.println(remain);
		if(!remain.equals("无限制"))
		{
			System.out.println("剩余天数执行了。。。。。。。。。。。。");
			int remaindays = Integer.parseInt(remain) - vo.getTakeOffDays();
			Rdays rd = new Rdays();
			rd.setEmployeeID(vo.getEmployeeID());
			rd.setHolidayID(vo.getHolidayTypeID());
			if(remaindays >= 0)
			{
				rd.setRemainingDays(remaindays);
			}
			else
			{
				rd.setRemainingDays(0);
			}	
			hos.updateRdays(rd);
		}
		mv.setViewName("/beforeHolidayReq.action");
		return mv;
	}
}
