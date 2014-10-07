package com.business.mgr;

import org.apache.ibatis.session.SqlSession;

/**
 * @Dao 抽象类
 * @author cl
 * 
 */
public abstract class AbstractDao {
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}
}
