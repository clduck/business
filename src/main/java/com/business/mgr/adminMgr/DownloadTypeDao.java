package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.business.model.DownloadType;

/**
 * 
 * @author duck
 * 
 */
public interface DownloadTypeDao  {
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : 
	 * @void description : 获取下载类别信息
	 */
	public List<DownloadType> queryDownloadTypes(DownloadType downloadTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入下载类别信息
	 *  @return : void
	 *
	 */
	public Integer insertDownloadType(DownloadType downloadTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改下载类别信息
	 *  @return : void
	 *
	 */
	public void modifyDownloadType(DownloadType downloadTypeParam) throws SQLException;
	
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除下载类别信息
	 *  @return : void
	 *
	 */
	public void deleteDownloadTypes(DownloadType downloadTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-25 
	 *  @author :cl
	 *  @description : 修改下载类型的sortPath
	 *  @return : void
	 *
	 */
	public void modifySortPath(Map<String, String> sortPathMap) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-26 
	 *  @author :cl
	 *  @description : 修改父节点的leaf状态
	 *  @return : void
	 *
	 */
	public void modifyParentLeaf(Integer parentID) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-26 
	 *  @author :cl
	 *  @description : 修改父节点的leaf状态
	 *  @return : void
	 *
	 */
	public List<DownloadType> selectSortPath(DownloadType downloadTypeParam) throws SQLException;
}
