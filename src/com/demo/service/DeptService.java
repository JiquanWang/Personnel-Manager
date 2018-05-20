package com.demo.service;

import java.util.List;

import com.demo.po.Department;
import com.demo.po.EDdetails;

public interface DeptService {
	public List<Department> getAllDept() throws Exception;
	public int getAllEDdetails() throws Exception;
	public void addEDdetail(EDdetails ed) throws Exception;
	public List<Department> getOtherDept(String id) throws Exception;
	public void changeDept(String eid, String did) throws Exception;
	public String getMan(String eid) throws Exception;
	public String getUpperDeptManID(String id) throws Exception;
}
