package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;

import com.business.model.NewsInfo;

/**
 * 
 * @author duck
 * 
 */
public interface NewsInfoDao  {
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : 
	 * @void description : 获取新闻信息
	 */
	public List<NewsInfo> queryNewsInfo(NewsInfo NewsInfoParam) throws SQLException;
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取新闻信息（分页）
	 */
	public List<NewsInfo> queryNews(NewsInfo NewsInfoParam,int start,int nums) throws SQLException;
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取新闻总数（分页）
	 */
	public int queryNewsCount() throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入新闻信息
	 *  @return : void
	 *
	 */
	public void insertNewsInfo(NewsInfo NewsInfoParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改新闻信息
	 *  @return : void
	 *
	 */
	public void modifyNewsInfo(NewsInfo NewsInfoParam) throws SQLException;
	
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除新闻信息
	 *  @return : void
	 *
	 */
	public void deleteNewsInfos(List<Integer> NewsInfoIds) throws SQLException;

}
