package com.business.mgr.usermgr.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.usermgr.UserInfoDao;
import com.business.model.UserInfo;
import com.business.model.Wch;

@Transactional
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
	private static final Log logger = LogFactory.getLog(UserInfoDaoImpl.class);
	private SqlSession sqlSession;

	public void insertUserInfo(UserInfo userInfo) throws SQLException {
		sqlSession.insert("com.cn.duck.model.UserInfo.insertUserInfo", userInfo);
	}

	public void modifyUserInfo(UserInfo userInfo) throws SQLException {
		sqlSession.update("com.cn.duck.model.UserInfo.modifyUserInfo", userInfo);
	}

	@SuppressWarnings("unchecked")
	public List<UserInfo> queryUserInfo(UserInfo userInfo) throws SQLException {
		return sqlSession.selectList("com.cn.duck.model.UserInfo.queryUserInfo", userInfo);
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Wch> queryWch(Wch wch) throws SQLException {
	
		return sqlSession.selectList("com.cn.duck.model.UserInfo.wchSelect", wch);
	}

	public List<Wch> wchSelectByLike(List<String> wchInfoIds) throws SQLException {
		return sqlSession.selectList("com.cn.duck.model.UserInfo.wchSelectByLike", wchInfoIds);
	}

	public void updateWch(Wch wch) throws SQLException {
		sqlSession.update("com.cn.duck.model.UserInfo.updateWch", wch);
	}
	public void insertWch(Wch wch) throws SQLException {
		sqlSession.update("com.cn.duck.model.UserInfo.inertWch2", wch);
	}

}
