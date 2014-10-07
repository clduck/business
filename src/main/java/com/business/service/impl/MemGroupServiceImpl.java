package com.business.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.MemGroupDao;
import com.business.model.MemGroup;
import com.business.service.MemGroupService;

@Service
public class MemGroupServiceImpl implements MemGroupService {
	private Log logger = LogFactory.getLog(MemGroupServiceImpl.class);
	@Autowired
	private MemGroupDao memGroupDao;

	public List<MemGroup> getMemGroups(MemGroup memGroupParam)throws Exception {
		return memGroupDao.queryMemGroup(memGroupParam);
	}

}
