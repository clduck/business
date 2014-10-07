package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.NewsInfoDao;
import com.business.model.NewsInfo;

@Transactional
@Repository
public class NewsInfoDaoImpl extends AbstractDao implements NewsInfoDao {
	private static final Log logger = LogFactory.getLog(NewsInfoDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<NewsInfo> queryNewsInfo(NewsInfo NewsInfoParam) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.NewsInfo.queryNewsInfo", NewsInfoParam);
	}

	@SuppressWarnings("unchecked")
	public List<NewsInfo> queryNews(NewsInfo NewsInfoParam,int start,int num) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.NewsInfo.queryNews", NewsInfoParam, new RowBounds(start, num));
	}

	public int queryNewsCount() throws SQLException {
		return (Integer) getSqlSession().selectOne("com.cn.duck.model.NewsInfo.queryNewsCount");
	}

	public void insertNewsInfo(NewsInfo NewsInfoParam)throws SQLException {
		getSqlSession().insert("com.cn.duck.model.NewsInfo.insertNewsInfo", NewsInfoParam);
	}

	public void modifyNewsInfo(NewsInfo NewsInfoParam)throws SQLException {
		getSqlSession().update("com.cn.duck.model.NewsInfo.modifyNewsInfo", NewsInfoParam);
	}

	public void deleteNewsInfos(List<Integer> NewsInfoIds) throws SQLException {
		getSqlSession().delete("com.cn.duck.model.NewsInfo.deleteNewsInfos", NewsInfoIds);
	}
}
