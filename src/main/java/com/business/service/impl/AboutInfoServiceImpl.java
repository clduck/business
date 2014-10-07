package com.business.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.IBaseDAO;
import com.business.mgr.adminMgr.IAboutInfoDao;
import com.business.model.AboutInfo;
import com.business.service.BaseService;
import com.business.service.IAboutInfoService;

@Service
public class AboutInfoServiceImpl extends BaseService<AboutInfo> implements
		IAboutInfoService {

	private Log logger = LogFactory.getLog(DownloadInfoServiceImpl.class);
	@Autowired
	private IAboutInfoDao aboutInfoDao;

	public void setAboutInfoDao(IAboutInfoDao aboutInfoDao) {
		this.aboutInfoDao = aboutInfoDao;
	}

	@Override
	public IBaseDAO<AboutInfo, Long> getDaseDao() {
		// TODO Auto-generated method stub
		return aboutInfoDao;
	}
}
