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
		//�õ���ǰ��ٵ�id��������vo����
		int takeOffID = hos.getReqNum() + 1;
		vo.setTakeOffID(Integer.toString(takeOffID));
		//���������ݿ���
		hos.addReq(vo);
		
		
		//�������������¼
		//1. ��ȡ������ǰid
		int exid = hes.getExNum() + 1;
		String examineTableID = Integer.toString(exid);
		//2.��ȡ��ٵ�id
		String tid = Integer.toString(takeOffID);
		System.out.println("jkjdlkjdkjfdkfdjksjfkjfdkjdfkdj"+tid);
		//3.1��ȡ��������id
		String exrid = ds.getMan(vo.getEmployeeID());
		System.out.println(exrid);
		System.out.println(vo.getEmployeeID());
		if(exrid.equals(vo.getEmployeeID())){
			//�����ŵ��������Լ�ʱ,���ݱ�����id�������ϼ�����
			
			//��ȡ���ڲ���id
			String did = es.getDeptID(vo.getEmployeeID());
			System.out.println("�������������������ڵĲ�����........"+did);
			//�����ϼ���������ID
			String mid = ds.getUpperDeptManID(did);
			System.out.println("................�ϼ�����������"+mid);
			if(mid == null)
			{
				//û���ϼ����ţ�ֱ������ͨ���������ٸ�����������
				System.out.println("�Լ������Լ� ͨ����");
				hes.approve(examineTableID, tid, exrid);
			}
			else
			{
				//�����ϼ�������������
				System.out.println("���ϼ���������������");
				hes.addEx(examineTableID, tid, mid);
			}
		} 
		else{
			//����������������
			System.out.println("�������������ȥ��");
			hes.addEx(examineTableID, tid, exrid);
		}
		
		//�����������ͼ�ȥʣ������
		String remain = vo.getRemain();
		System.out.println(remain);
		if(!remain.equals("������"))
		{
			System.out.println("ʣ������ִ���ˡ�����������������������");
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
