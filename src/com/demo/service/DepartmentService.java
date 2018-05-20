package com.demo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.Department;
import com.demo.vo.UpdateDepartmentVo;
import com.demo.vo.DepartmentDetailsVo;
import com.demo.vo.DepartmentEmployeeVo;
import com.demo.vo.DisplayDepartmentVo;
import com.demo.vo.SelectDepartmentVo;

public interface DepartmentService {
	public List<DisplayDepartmentVo> selectDeparment(SelectDepartmentVo vo) throws Exception;
	public List<DisplayDepartmentVo> selectAllDepartment() throws Exception;
	public int getDepartmentID() throws Exception;
	public int addDepartment(UpdateDepartmentVo vo) throws Exception;
	public DepartmentDetailsVo  selectDepartmentDetails(String departmentID) throws Exception;
	public List<DepartmentEmployeeVo> selectDepartmentEmployee(String departmentID) throws Exception;
	public int updateDepartment(UpdateDepartmentVo vo) throws Exception;
	public int resetDepartmentMark(String departmentID) throws Exception;
}
