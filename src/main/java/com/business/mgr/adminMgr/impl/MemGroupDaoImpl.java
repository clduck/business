package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.MemGroupDao;
import com.business.model.MemGroup;

@Transactional
@Repository
public class MemGroupDaoImpl extends AbstractDao implements MemGroupDao {
	private static final Log logger = LogFactory.getLog(MemGroupDaoImpl.class);

	/**
	 * 获取群组信息
	 */
	@SuppressWarnings("unchecked")
	public List<MemGroup> queryMemGroup(MemGroup memGroupParam)
			throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.MemGroup.queryAboutInfo", memGroupParam);
	}


}
