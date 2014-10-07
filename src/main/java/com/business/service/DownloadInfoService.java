package com.business.service;

import java.util.List;

import com.business.model.CommonObject;
import com.business.model.DownloadInfo;
import com.business.model.param.DownloadParam;

public interface DownloadInfoService {

	/**
	 *  @author cl
	 *  @time : 2012-1-13 
	 *  @return : CommonObject
	 *  @description : 获取下载信息列表分页
	 */
	public CommonObject getDownloadInfos(DownloadParam downloadInfoParam,int start,int num) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<DownloadInfo>
	 *  @description :获取下载信息
	 */
	public DownloadInfo getDownloadInfo(DownloadInfo downloadInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入下载信息
	 *  @return : void
	 *
	 */
	public void insertDownloadInfo(DownloadInfo downloadInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改下载信息
	 *  @return : void
	 *
	 */
	public void modifyDownloadInfo(DownloadInfo downloadInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除下载信息
	 *  @return : void
	 *
	 */
	public void deleteDownloadInfo(List<Integer> downloadInfoIds) throws Exception;
}
