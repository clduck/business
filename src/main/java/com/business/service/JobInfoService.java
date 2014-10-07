package com.business.service;

import java.util.List;

import com.business.model.CommonObject;
import com.business.model.JobInfo;
import com.business.model.param.JobInfoParam;

public interface JobInfoService {

	/**
	 *  @author cl
	 *  @time : 2012-1-13 
	 *  @return : CommonObject
	 *  @description : 获取招聘信息列表分页
	 */
	public CommonObject getJobInfos(JobInfoParam jobInfoParam,int start,int num) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<JobInfo>
	 *  @description :获取招聘信息
	 */
	public JobInfo getJobInfo(JobInfo jobInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入招聘信息
	 *  @return : void
	 *
	 */
	public void insertJobInfo(JobInfo jobInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改招聘信息
	 *  @return : void
	 *
	 */
	public void modifyJobInfo(JobInfo jobInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除招聘信息
	 *  @return : void
	 *
	 */
	public void deleteJobInfo(List<Integer> jobInfoIds) throws Exception;
}
