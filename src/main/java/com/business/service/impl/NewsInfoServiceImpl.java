package com.business.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.NewsInfoDao;
import com.business.model.CommonObject;
import com.business.model.NewsInfo;
import com.business.service.NewsInfoService;

@Service
public class NewsInfoServiceImpl implements NewsInfoService {
	private Log logger = LogFactory.getLog(NewsInfoServiceImpl.class);
	@Autowired
	private NewsInfoDao NewsInfoDao;

	/**
	 * 获取处理后的新闻信息数据
	 */
	public CommonObject getNewsInfos(NewsInfo NewsInfoParam, int start,int num) throws Exception {
		CommonObject object = new CommonObject();
		int total = NewsInfoDao.queryNewsCount();
		List<NewsInfo> list = NewsInfoDao.queryNews(NewsInfoParam, start,num);
		object.setTotal(total);
		object.setRows(list);
		return object;
	}
	/**
	 * 获取新闻信息
	 */
	public NewsInfo getNewsInfo(NewsInfo NewsInfoParam)throws Exception {
		NewsInfo NewsInfo = NewsInfoDao.queryNewsInfo(NewsInfoParam).get(0);
		return NewsInfo;
	}
    /**
     * 保存新闻信息
     */
	public void insertNewsInfo(NewsInfo NewsInfoParam) throws Exception {
        NewsInfoDao.insertNewsInfo(NewsInfoParam);
	} 
	/**
	 * 修改新闻信息
	 */
	public void modifyNewsInfo(NewsInfo NewsInfoParam) throws Exception {
       NewsInfoDao.modifyNewsInfo(NewsInfoParam);
	}
	/**
	 * 删除新闻信息
	 */
	public void deleteNewsInfo(List<Integer> NewsInfoIds)throws Exception {
       NewsInfoDao.deleteNewsInfos(NewsInfoIds);		
	}

}
