package com.business.service;

import java.util.List;

import com.business.model.CommonObject;
import com.business.model.NewsType;
import com.business.util.tree.EasyUITreeBean;

public interface NewsTypeService {

	/**
	 *  @author cl
	 *  @time : 2012-1-13 
	 *  @return : CommonObject
	 *  @description : 获取新闻类别信息列表分页
	 */
	public CommonObject getNewsTypes(NewsType NewsTypeParam,int start,int num) throws Exception;
	/**
	 * 
	 *  @time : 2012-2-1 
	 *  @author :cl
	 *  @description : 构造新闻类别树结构数据
	 *  @return : List<EasyUITreeBean>
	 *
	 */
    public List<EasyUITreeBean> getNewsTypeTreeData() throws Exception; 
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<NewsType>
	 *  @description :获取新闻类别信息
	 */
	public NewsType getNewsType(NewsType NewsTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入新闻类别信息
	 *  @return : void
	 *
	 */
	public void insertNewsType(NewsType NewsTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改新闻类别信息
	 *  @return : void
	 *
	 */
	public void modifyNewsType(NewsType NewsTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除新闻类别信息
	 *  @return : void
	 *
	 */
	public void deleteNewsType(Integer NewsTypeId) throws Exception;
}
