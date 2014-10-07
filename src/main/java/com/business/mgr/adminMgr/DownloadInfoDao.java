package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;

import com.business.model.DownloadInfo;
import com.business.model.param.DownloadParam;

/**
 * 
 * @author duck
 * 
 */
public interface DownloadInfoDao  {
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取下载信息（分页）
	 */
	public List<DownloadInfo> queryDownloadInfo(DownloadParam downloadInfoParam,int start,int nums) throws SQLException;
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取下载总数（分页）
	 */
	public int queryDownloadInfoCount(DownloadParam downloadParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-1 
	 *  @author :cl
	 *  @description : 获取下载信息（不分页）
	 *  @return : List<DownloadInfo>
	 *
	 */
	public List<DownloadInfo> queryDownloadInfos(DownloadInfo downloadInfoParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入下载信息
	 *  @return : void
	 *
	 */
	public Integer insertDownloadInfo(DownloadInfo downloadInfoParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改下载信息
	 *  @return : void
	 *
	 */
	public void modifyDownloadInfo(DownloadInfo downloadInfoParam) throws SQLException;
	
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除下载信息
	 *  @return : void
	 *
	 */
	public void deleteDownloadInfos(List<Integer> downloadIds) throws SQLException;
}
