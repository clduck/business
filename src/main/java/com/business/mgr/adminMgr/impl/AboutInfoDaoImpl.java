package com.business.mgr.adminMgr.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.BaseDaoImpl;
import com.business.mgr.adminMgr.IAboutInfoDao;
import com.business.model.AboutInfo;
@Transactional
@Repository
public class AboutInfoDaoImpl extends BaseDaoImpl<AboutInfo, Long> implements IAboutInfoDao {
	private static final Log logger = LogFactory.getLog(AboutInfoDaoImpl.class);


}
