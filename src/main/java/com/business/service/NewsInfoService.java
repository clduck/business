package com.business.service;

import java.util.List;

import com.business.model.CommonObject;
import com.business.model.NewsInfo;

public interface NewsInfoService {

	/**
	 *  @author cl
	 *  @time : 2012-1-13 
	 *  @return : CommonObject
	 *  @description : 获取新闻信息列表分页
	 */
	public CommonObject getNewsInfos(NewsInfo NewsInfoParam,int start,int num) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<NewsInfo>
	 *  @description :获取新闻信息
	 */
	public NewsInfo getNewsInfo(NewsInfo NewsInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入新闻信息
	 *  @return : void
	 *
	 */
	public void insertNewsInfo(NewsInfo NewsInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改新闻信息
	 *  @return : void
	 *
	 */
	public void modifyNewsInfo(NewsInfo NewsInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除新闻信息
	 *  @return : void
	 *
	 */
	public void deleteNewsInfo(List<Integer> NewsInfoIds) throws Exception;
}
