package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.business.model.NewsType;

/**
 * 
 * @author duck
 * 
 */
public interface NewsTypeDao  {
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : 
	 * @void description : 获取新闻类别信息
	 */
	public List<NewsType> queryNewsType(NewsType newsTypeParam) throws SQLException;
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取新闻类别信息（分页）
	 */
	public List<NewsType> queryNewsType(NewsType newsTypeParam,int start,int nums) throws SQLException;
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取新闻类别总数（分页）
	 */
	public int queryNewsTypeCount() throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-1 
	 *  @author :cl
	 *  @description : 获取新闻类别信息（不分页）
	 *  @return : List<NewsType>
	 *
	 */
	public List<NewsType> queryNewsTypes(NewsType newsTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入新闻类别信息
	 *  @return : void
	 *
	 */
	public Integer insertNewsType(NewsType newsTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改新闻类别信息
	 *  @return : void
	 *
	 */
	public void modifyNewsType(NewsType newsTypeParam) throws SQLException;
	
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除新闻类别信息
	 *  @return : void
	 *
	 */
	public void deleteNewsTypes(NewsType newsTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-25 
	 *  @author :cl
	 *  @description : 修改新闻类型的sortPath
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
	public List<NewsType> selectSortPath(NewsType newsTypeParam) throws SQLException;
}
