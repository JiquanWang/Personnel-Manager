package com.demo.service;

import java.util.List;

import com.demo.po.EHdetails;
import com.demo.po.Headship;

public interface HeadshipService {
	public List<Headship> getAllHeadship() throws Exception;
	public int getAllEHdetails() throws Exception;
	public void addEHdetail(EHdetails hd) throws Exception;
	public List<Headship> getOtherHeadship(String id) throws Exception;
	public void changeHeadship(String eid, String hid) throws Exception;
}
