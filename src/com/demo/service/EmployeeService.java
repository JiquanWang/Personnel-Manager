package com.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.EDdetails;
import com.demo.po.EHdetails;
import com.demo.po.Employee;
import com.demo.vo.EDHVo;
import com.demo.vo.EDdetailsVo;
import com.demo.vo.EHdetailsVo;
import com.demo.vo.EmpInfoVo;
import com.demo.vo.EmpRequestVo;
import com.demo.vo.UserInfoVo;

public interface EmployeeService {
	public UserInfoVo getUserInfo(String id) throws Exception;
	public List<EDdetailsVo> getEDdetails(String id) throws Exception;
	public List<EHdetailsVo> getEHdetails(String id) throws Exception;
	public List<EmpInfoVo> getAllEmpInfo() throws Exception;
	public List<EmpInfoVo> selectEmp(EmpRequestVo vo) throws Exception;
	public Employee getEmpPoInfo(String id) throws Exception;
	public int updateEmp(Employee e) throws Exception;
	public int getEmpByUsername(String username) throws Exception;
	public int getEmpNum() throws Exception;
	public void addEmp(Employee e) throws Exception;
	public void changeEmpMark(String id) throws Exception;
	public EDHVo getEDHVOInfo(String id) throws Exception;
	public void addRdays(String eid) throws Exception;
	public String getDeptID(String id)  throws Exception;
}
