package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.DownloadInfoDao;
import com.business.model.DownloadInfo;
import com.business.model.param.DownloadParam;
@Transactional
@Repository
public class DownloadInfoDaoImpl extends AbstractDao implements DownloadInfoDao {

	@SuppressWarnings("unchecked")
	public List<DownloadInfo> queryDownloadInfos(DownloadInfo downloadInfoParam)
			throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.DownloadInfo.queryDownloadInfo",downloadInfoParam);
	}

	@SuppressWarnings("unchecked")
	public List<DownloadInfo> queryDownloadInfo(DownloadParam downloadInfoParam,
			int start, int nums) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.DownloadInfo.queryDownload", downloadInfoParam, new RowBounds(start, nums));
	}

	public int queryDownloadInfoCount(DownloadParam downloadParam) throws SQLException {
		return  (Integer) getSqlSession().selectOne("com.cn.duck.model.DownloadInfo.queryDownloadCount",downloadParam);
	}


	public Integer insertDownloadInfo(DownloadInfo downloadInfoParam)
			throws SQLException {
		return getSqlSession().insert("com.cn.duck.model.DownloadInfo.insertDownloadInfo", downloadInfoParam);
	}

	public void modifyDownloadInfo(DownloadInfo downloadInfoParam)
			throws SQLException {
       getSqlSession().update("com.cn.duck.model.DownloadInfo.modifyDownloadInfo", downloadInfoParam);
	}

	public void deleteDownloadInfos(List<Integer> downloadIds)
			throws SQLException {
       getSqlSession().delete("com.cn.duck.model.DownloadInfo.deleteDownloadInfos", downloadIds);
	}


}
