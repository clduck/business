package com.business.service;

import java.util.List;

import com.business.model.DownloadType;
import com.business.util.tree.EasyUITreeBean;

public interface DownloadTypeService {

	/**
	 * 
	 *  @time : 2012-2-1 
	 *  @author :cl
	 *  @description : 构造下载类别树结构数据
	 *  @return : List<EasyUITreeBean>
	 *
	 */
    public List<EasyUITreeBean> getDownloadTypeTreeData() throws Exception; 
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<DownloadType>
	 *  @description :获取下载类别信息
	 */
	public DownloadType getDownloadType(DownloadType downloadTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入下载类别信息
	 *  @return : void
	 *
	 */
	public void insertDownloadType(DownloadType downloadTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改下载类别信息
	 *  @return : void
	 *
	 */
	public void modifyDownloadType(DownloadType downloadTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除下载类别信息
	 *  @return : void
	 *
	 */
	public void deleteDownloadType(Integer downloadTypeId) throws Exception;
}
