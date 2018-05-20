package com.demo.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.DepartmentMapper;
import com.demo.po.Department;
import com.demo.service.DepartmentService;
import com.demo.vo.UpdateDepartmentVo;
import com.demo.vo.DepartmentDetailsVo;
import com.demo.vo.DepartmentEmployeeVo;
import com.demo.vo.DisplayDepartmentVo;
import com.demo.vo.SelectDepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentMapper mapper;
	@Override
	public List<DisplayDepartmentVo> selectDeparment(SelectDepartmentVo vo) throws Exception {
		return mapper.selectDepartment(vo);
	}
	public List<DisplayDepartmentVo> selectAllDepartment() throws Exception{
		return mapper.selectAllDepartment();
	}
	public int getDepartmentID() throws Exception{
		return mapper.getDepartmentID();
	}
	public int addDepartment(UpdateDepartmentVo vo) throws Exception{
		return mapper.addDepartment(vo);
	}
	public DepartmentDetailsVo  selectDepartmentDetails(String departmentID) throws Exception{
		return mapper.selectDepartmentDetails(departmentID);
	}
	public List<DepartmentEmployeeVo> selectDepartmentEmployee(String departmentID) throws Exception{
		return mapper.selectDepartmentEmployee(departmentID);
	}
	public int updateDepartment(UpdateDepartmentVo vo) throws Exception{
		return mapper.updateDepartment(vo);
	}
	public int resetDepartmentMark(String departmentID) throws Exception{
		return mapper.resetDepartmentMark(departmentID);
	}
}
