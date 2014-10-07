package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.JobInfoDao;
import com.business.model.JobInfo;
import com.business.model.param.JobInfoParam;
@Transactional
@Repository
public class JobInfoDaoImpl extends AbstractDao implements JobInfoDao {

	@SuppressWarnings("unchecked")
	public List<JobInfo> queryJobInfos(JobInfo jobInfoParam)
			throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.JobInfo.queryJobInfo",jobInfoParam);
	}

	@SuppressWarnings("unchecked")
	public List<JobInfo> queryJobInfo(JobInfoParam jobInfoParam,
			int start, int nums) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.JobInfo.queryJob", jobInfoParam, new RowBounds(start, nums));
	}

	public int queryJobInfoCount(JobInfoParam jobParam) throws SQLException {
		return  (Integer) getSqlSession().selectOne("com.cn.duck.model.JobInfo.queryJobCount",jobParam);
	}


	public Integer insertJobInfo(JobInfo jobInfoParam)
			throws SQLException {
		return getSqlSession().insert("com.cn.duck.model.JobInfo.insertJobInfo", jobInfoParam);
	}

	public void modifyJobInfo(JobInfo jobInfoParam)
			throws SQLException {
       getSqlSession().update("com.cn.duck.model.JobInfo.modifyJobInfo", jobInfoParam);
	}

	public void deleteJobInfos(List<Integer> jobIds)
			throws SQLException {
       getSqlSession().delete("com.cn.duck.model.JobInfo.deleteJobInfos", jobIds);
	}


}
