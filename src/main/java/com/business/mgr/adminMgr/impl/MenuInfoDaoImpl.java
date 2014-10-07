package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.MenuInfoDao;
import com.business.model.MenuInfo;

@Transactional
@Repository
public class MenuInfoDaoImpl extends AbstractDao implements MenuInfoDao {
	private static final Log logger = LogFactory.getLog(MenuInfoDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<MenuInfo> queryMenuInfo(MenuInfo menuInfoParam) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.MenuInfo.queryMenuInfo", menuInfoParam);
	}
}
