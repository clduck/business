package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.DownloadTypeDao;
import com.business.model.DownloadType;
@Transactional
@Repository
public class DownloadTypeDaoImpl extends AbstractDao implements DownloadTypeDao {

	public List<DownloadType> queryDownloadTypes(DownloadType downloadTypeParam)
			throws SQLException {
	     return getSqlSession().selectList("com.cn.duck.model.DownloadType.queryDownloadTypes", downloadTypeParam);
	}

	public Integer insertDownloadType(DownloadType downloadTypeParam) throws SQLException {
		 getSqlSession().insert("com.cn.duck.model.DownloadType.insertDownloadType", downloadTypeParam);
		return downloadTypeParam.getDownloadTypeID();
	}

	public void modifyDownloadType(DownloadType downloadTypeParam) throws SQLException {
		 getSqlSession().update("com.cn.duck.model.DownloadType.modifyDownloadType", downloadTypeParam);
	}

	public void deleteDownloadTypes(DownloadType downloadTypeParam) throws SQLException {
        getSqlSession().delete("com.cn.duck.model.DownloadType.deleteDownloadType", downloadTypeParam);
	}

	public void modifySortPath(Map<String, String> sortPathMap) throws SQLException {
		getSqlSession().delete("com.cn.duck.model.DownloadType.modifySortPath", sortPathMap);
	}

	public void modifyParentLeaf(Integer parentID) throws SQLException {
		getSqlSession().delete("com.cn.duck.model.DownloadType.modifyParentLeaf", parentID);
	}

	public List<DownloadType> selectSortPath(DownloadType downloadTypeParam) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.DownloadType.selectSortPath", downloadTypeParam);
	}

}
