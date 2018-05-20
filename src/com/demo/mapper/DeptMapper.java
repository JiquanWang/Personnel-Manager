package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demo.po.Department;
import com.demo.po.EDdetails;

public interface DeptMapper {
		public List<Department> getAllDept() throws Exception;
		public List<EDdetails> getAllEDdetails() throws Exception;
		public void addEDdetail(EDdetails ed) throws Exception;
		public List<Department> getOtherDept(@Param(value="id") String id) throws Exception;
		public void changeDept(@Param(value="eid") String eid, @Param(value="did") String did) throws Exception;
		public String getMan(@Param(value="eid") String eid) throws Exception;
		public String getUpperDeptManID(@Param(value="id") String id) throws Exception;
}
