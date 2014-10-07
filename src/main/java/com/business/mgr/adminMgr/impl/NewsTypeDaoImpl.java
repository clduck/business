package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.NewsTypeDao;
import com.business.model.NewsType;

@Transactional
@Repository
public class NewsTypeDaoImpl extends AbstractDao implements NewsTypeDao {
	private static final Log logger = LogFactory.getLog(NewsTypeDaoImpl.class);

	@SuppressWarnings("unchecked")
	public List<NewsType> queryNewsType(NewsType newsTypeParam) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.NewsType.queryNewsType", newsTypeParam);
	}

	@SuppressWarnings("unchecked")
	public List<NewsType> queryNewsType(NewsType newsTypeParam,int start,int num) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.NewsType.queryNewsTypes", newsTypeParam, new RowBounds(start, num));
	}
	public List<NewsType> queryNewsTypes(NewsType newsTypeParam) throws SQLException {
       return getSqlSession().selectList("com.cn.duck.model.NewsType.queryNewsTypes",newsTypeParam);
    }
	public int queryNewsTypeCount() throws SQLException {
		return (Integer) getSqlSession().selectOne("com.cn.duck.model.NewsType.queryNewsTypeCount");
	}

	public Integer insertNewsType(NewsType newsTypeParam)throws SQLException {
	   getSqlSession().insert("com.cn.duck.model.NewsType.insertNewsType", newsTypeParam);
	   return newsTypeParam.getNewsTypeID();
	}

	public void modifyNewsType(NewsType newsTypeParam)throws SQLException {
		getSqlSession().update("com.cn.duck.model.NewsType.modifyNewsType", newsTypeParam);
	}

	public void deleteNewsTypes(NewsType newsTypeParam) throws SQLException {
		getSqlSession().delete("com.cn.duck.model.NewsType.deleteNewsTypes", newsTypeParam);
	}

	public void modifySortPath(Map<String, String> sortPathMap) throws SQLException {
        getSqlSession().update("com.cn.duck.model.NewsType.modifySortPath", sortPathMap);
	}

	public void modifyParentLeaf(Integer parentID) throws SQLException {
       getSqlSession().update("com.cn.duck.model.NewsType.modifyParentLeaf",parentID);
    }

	public List<NewsType> selectSortPath(NewsType newsTypeParam) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.NewsType.selectSortPath", newsTypeParam);
	}
	
}
