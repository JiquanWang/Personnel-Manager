package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.DeptMapper;
import com.demo.po.Department;
import com.demo.po.EDdetails;
import com.demo.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptMapper mapper;
	
	public List<Department> getAllDept() throws Exception {
		System.out.println("dedededededededede");
		return mapper.getAllDept();
	}

	@Override
	public int getAllEDdetails() throws Exception {
		List<EDdetails> s = mapper.getAllEDdetails();
		return s.size();
	}

	@Override
	public void addEDdetail(EDdetails ed) throws Exception {
		mapper.addEDdetail(ed);
	}

	@Override
	public List<Department> getOtherDept(String id) throws Exception {
		return mapper.getOtherDept(id);
	}

	@Override
	public void changeDept(String eid, String did) throws Exception {
		mapper.changeDept(eid, did);
	}

	@Override
	public String getMan(String eid) throws Exception {
		return mapper.getMan(eid);
	}

	@Override
	public String getUpperDeptManID(String id) throws Exception {
		
		return mapper.getUpperDeptManID(id);
	}
}
