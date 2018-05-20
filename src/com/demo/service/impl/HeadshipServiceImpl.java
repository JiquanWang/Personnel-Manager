package com.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mapper.HeadshipMapper;
import com.demo.po.EDdetails;
import com.demo.po.EHdetails;
import com.demo.po.Headship;
import com.demo.service.HeadshipService;
@Service
public class HeadshipServiceImpl implements HeadshipService {
	@Autowired
	private HeadshipMapper mapper;
	
	public List<Headship> getAllHeadship() throws Exception {
		
		return mapper.getAllHeadship();
	}

	@Override
	public int getAllEHdetails() throws Exception {
		List<EHdetails> s = mapper.getAllEHdetails();
		return s.size();
	}

	@Override
	public void addEHdetail(EHdetails hd) throws Exception {
		mapper.addEHdetail(hd);
	}

	@Override
	public List<Headship> getOtherHeadship(String id) throws Exception {
		return mapper.getOtherHeadship(id);
	}

	@Override
	public void changeHeadship(String eid, String hid) throws Exception {
		mapper.changeHeadship(eid, hid);
		
	}

}
