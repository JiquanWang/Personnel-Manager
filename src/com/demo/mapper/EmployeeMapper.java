package com.demo.mapper;

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

public interface EmployeeMapper {
	public List<UserInfoVo> getUserInfo(@Param(value="id") String id) throws Exception;
	public List<EDdetailsVo> getEDdetails(@Param(value="id") String id) throws Exception;
	public List<EHdetailsVo> getEHdetails(@Param(value="id") String id) throws Exception;
	public List<EmpInfoVo> getAllEmpInfo() throws Exception;
	public List<EmpInfoVo> selectEmp(EmpRequestVo vo) throws Exception;
	public List<Employee> getEmpPoInfo(@Param(value="id") String id) throws Exception;
	public int updateEmp(Employee e) throws Exception;
	public List<Employee> getEmpByUsername(@Param(value="username") String username) throws Exception;
	public int addEmp(Employee e) throws Exception;
	public int changeEmpMark(@Param(value="id") String id) throws Exception;
	public List<EDHVo> getEDHVOInfo(@Param(value="id") String id) throws Exception;
	public void addRdays(@Param(value="eid") String eid) throws Exception;
	public String getDeptID(@Param(value="id") String id) throws Exception;
}
