package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.EmployeeMapper;
import com.demo.po.EDdetails;
import com.demo.po.EHdetails;
import com.demo.po.Employee;
import com.demo.service.EmployeeService;
import com.demo.vo.EDHVo;
import com.demo.vo.EDdetailsVo;
import com.demo.vo.EHdetailsVo;
import com.demo.vo.EmpInfoVo;
import com.demo.vo.EmpRequestVo;
import com.demo.vo.UserInfoVo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper mapper;
	
	public UserInfoVo getUserInfo(String id) throws Exception{
		List<UserInfoVo> uis = mapper.getUserInfo(id);
		if(uis.isEmpty() || uis.size() == 0)
		{
			return null;
		}
		else
		{
			return uis.get(0);
		}
	}


	public List<EDdetailsVo> getEDdetails(String id) throws Exception {
		System.out.println("进入edService");
		return mapper.getEDdetails(id);
	}

	
	public List<EHdetailsVo> getEHdetails(String id) throws Exception {
		System.out.println("进入ehService");
		return mapper.getEHdetails(id);
	}


	@Override
	public List<EmpInfoVo> getAllEmpInfo() throws Exception {
		return mapper.getAllEmpInfo();
	}


	@Override
	public List<EmpInfoVo> selectEmp(EmpRequestVo vo) throws Exception {
		return mapper.selectEmp(vo);
	}


	@Override
	public Employee getEmpPoInfo(String id) throws Exception {
		List<Employee> es = mapper.getEmpPoInfo(id);
		if(es.isEmpty() || es.size() == 0)
		{
			return null;
		}
		else
		{
			return es.get(0);
		}
	}


	@Override
	public int updateEmp(Employee e) throws Exception {
		return mapper.updateEmp(e);
	}


	@Override
	public int getEmpByUsername(String username) throws Exception {
		List<Employee> employees = mapper.getEmpByUsername(username);
		if(employees.size() == 0)
		{
			return 0;
		}
		else
		return 1;
	}


	@Override
	public int getEmpNum() throws Exception {
		List<EmpInfoVo> ev = mapper.getAllEmpInfo();
		return ev.size();
	}


	
	public void addEmp(Employee e) throws Exception {
		mapper.addEmp(e);
	}


	@Override
	public void changeEmpMark(String id) throws Exception {
		mapper.changeEmpMark(id);
	}


	@Override
	public EDHVo getEDHVOInfo(String id) throws Exception {
		List<EDHVo> vs = mapper.getEDHVOInfo(id);
		if(vs.size()!=0 && !vs.isEmpty())
		{
			return vs.get(0);
		}
		else
		return null;
	}


	@Override
	public void addRdays(String eid) throws Exception {
		mapper.addRdays(eid);
	}


	@Override
	public String getDeptID(String id) throws Exception {
		return mapper.getDeptID(id);
	}
}
