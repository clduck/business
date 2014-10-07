package com.business.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.JobInfoDao;
import com.business.model.CommonObject;
import com.business.model.JobInfo;
import com.business.model.param.JobInfoParam;
import com.business.service.JobInfoService;

@Service
public class JobInfoServiceImpl implements JobInfoService {
	private Log logger = LogFactory.getLog(JobInfoServiceImpl.class);
	@Autowired
	private JobInfoDao jobInfoDao;

	public CommonObject getJobInfos(JobInfoParam jobInfoParam,
			int start, int num) throws Exception {
		CommonObject object = new CommonObject();
		int total = jobInfoDao.queryJobInfoCount(jobInfoParam);
		List<JobInfo> list = jobInfoDao.queryJobInfo(jobInfoParam, start, num);
		object.setRows(list);
		object.setTotal(total);
		return object;
	}

	public JobInfo getJobInfo(JobInfo jobInfoParam) throws Exception {
		return jobInfoDao.queryJobInfos(jobInfoParam).get(0);
	}

	public void insertJobInfo(JobInfo jobInfoParam) throws Exception {
		jobInfoDao.insertJobInfo(jobInfoParam);

	}

	public void modifyJobInfo(JobInfo jobInfoParam) throws Exception {
		jobInfoDao.modifyJobInfo(jobInfoParam);

	}

	public void deleteJobInfo(List<Integer> jobInfoIds) throws Exception {
		jobInfoDao.deleteJobInfos(jobInfoIds);
	}

}
