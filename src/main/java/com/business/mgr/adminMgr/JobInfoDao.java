package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;

import com.business.model.JobInfo;
import com.business.model.param.JobInfoParam;

/**
 * 
 * @author duck
 * 
 */
public interface JobInfoDao  {
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取招聘信息（分页）
	 */
	public List<JobInfo> queryJobInfo(JobInfoParam jobInfoParam,int start,int nums) throws SQLException;
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取招聘总数（分页）
	 */
	public int queryJobInfoCount(JobInfoParam jobParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-1 
	 *  @author :cl
	 *  @description : 获取招聘信息（不分页）
	 *  @return : List<JobInfo>
	 *
	 */
	public List<JobInfo> queryJobInfos(JobInfo jobInfoParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入招聘信息
	 *  @return : void
	 *
	 */
	public Integer insertJobInfo(JobInfo jobInfoParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改招聘信息
	 *  @return : void
	 *
	 */
	public void modifyJobInfo(JobInfo jobInfoParam) throws SQLException;
	
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除招聘信息
	 *  @return : void
	 *
	 */
	public void deleteJobInfos(List<Integer> jobIds) throws SQLException;
}
