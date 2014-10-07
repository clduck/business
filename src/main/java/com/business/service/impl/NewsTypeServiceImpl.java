package com.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.NewsTypeDao;
import com.business.model.CommonObject;
import com.business.model.NewsType;
import com.business.service.NewsTypeService;
import com.business.util.common.ConstConfig;
import com.business.util.tree.EasyUITreeBean;
import com.business.util.tree.EasyUITreeUtils;

@Service
public class NewsTypeServiceImpl implements NewsTypeService {
	private Log logger = LogFactory.getLog(NewsTypeServiceImpl.class);
	@Autowired
	private NewsTypeDao newsTypeDao;

	/**
	 * 获取处理后的新闻类别信息数据
	 */
	public CommonObject getNewsTypes(NewsType NewsTypeParam, int start,int num) throws Exception {
		CommonObject object = new CommonObject();
		int total = newsTypeDao.queryNewsTypeCount();
		List<NewsType> list = newsTypeDao.queryNewsType(NewsTypeParam, start,num);
		object.setTotal(total);
		object.setRows(list);
		return object;
	}
	/**
	 * 获取新闻类别信息
	 */
	public NewsType getNewsType(NewsType NewsTypeParam)throws Exception {
		List<NewsType> list =  newsTypeDao.queryNewsType(NewsTypeParam);
		if (list.isEmpty() || list == null) {
		    return null;	
		}else{
			return list.get(0);
		}
	}
    /**
     * 保存新闻类别信息
     */
	public void insertNewsType(NewsType newsTypeParam) throws Exception {
		
		//获取父节点的sortPath
		NewsType  parentNewsTypeParam = new NewsType();
		parentNewsTypeParam.setNewsTypeID(newsTypeParam.getParentID());
		
		NewsType parentNewsType = getNewsType(parentNewsTypeParam);
		//如果添加的是一级新闻类型，则父节点的sortPath 为0
		String sortPath = "0,";
		if (parentNewsType != null) {
			sortPath = parentNewsType.getSortPath();
		}
		newsTypeParam.setSortPath(sortPath);
		Integer newsTypeId  = newsTypeDao.insertNewsType(newsTypeParam);
		sortPath = sortPath+newsTypeId+",";
		newsTypeParam = new NewsType();
		newsTypeParam.setNewsTypeID(newsTypeId);
		newsTypeParam.setSortPath(sortPath);
		//重新更新新闻类型的sortPath
		newsTypeDao.modifyNewsType(newsTypeParam);
		
		//修改父节点的leaf状态
		parentNewsTypeParam.setLeaf(0);
		newsTypeDao.modifyNewsType(parentNewsTypeParam);
		
	} 
	/**
	 * 修改新闻类别信息
	 */
	public void modifyNewsType(NewsType newsTypeParam) throws Exception {
		//获取父节点的sortPath
		NewsType  parentNewsTypeParam = new NewsType();
		parentNewsTypeParam.setNewsTypeID(newsTypeParam.getParentID());
		NewsType parentNewsType = getNewsType(parentNewsTypeParam);
		String newSortPath = "";
		if (parentNewsType != null) {
			 newSortPath = parentNewsType.getSortPath()+newsTypeParam.getNewsTypeID()+",";
		}else{
			 newSortPath = "0,"+newsTypeParam.getNewsTypeID()+",";
		}
		
		String oldSortPath = newsTypeParam.getSortPath();
		Map<String, String> sortPathMap = new HashMap<String, String>();
		sortPathMap.put("oldSortPath", oldSortPath);
		sortPathMap.put("newSortPath", newSortPath);
		
		newsTypeParam.setSortPath(newSortPath);
		parentNewsTypeParam.setLeaf(0);
		newsTypeDao.modifyNewsType(parentNewsTypeParam);
		newsTypeDao.modifyNewsType(newsTypeParam);
		newsTypeDao.modifySortPath(sortPathMap);
        newsTypeDao.modifyParentLeaf(newsTypeParam.getOldParentID());		
	}
	/**
	 * 删除新闻类别信息
	 */
	public void deleteNewsType(Integer NewsTypeId)throws Exception {
		NewsType newsTypeParam = new NewsType();
		newsTypeParam.setNewsTypeID(NewsTypeId);
		NewsType newsType = getNewsType(newsTypeParam);
		newsTypeParam.setSortPath(newsType.getSortPath());
		newsTypeDao.deleteNewsTypes(newsTypeParam);	
		newsTypeDao.modifyParentLeaf(newsType.getParentID());
	}
	/**
	 * 构造新闻类别树结构数据
	 */
	public List<EasyUITreeBean> getNewsTypeTreeData() throws Exception {
		List<NewsType> typeList = newsTypeDao.queryNewsTypes(new NewsType());
 		List<EasyUITreeBean> beans = newsTypeList2DwrTreeBean(typeList, ConstConfig.EASYUI_TREE_ROOT_VALUE);
		return beans;
	}
	/**
	 * NewsTypeList to DwrTreeList
	 * @param list 新闻类型列表
	 * @param id  去除父亲节点的id
     * @return List 新闻类型列表（DWR树）
	 */
	private List<EasyUITreeBean> newsTypeList2DwrTreeBean(List<NewsType> typeList, Integer id) {
		List<EasyUITreeBean> treeBeanList   = new ArrayList<EasyUITreeBean>();
		   EasyUITreeBean root = new EasyUITreeBean();
		   root.setId("0");
		   root.setPid("-1");
		   root.setText("根节点（点击选择）");
		   root.setState(ConstConfig.EASYUI_TREE_STATE_OPEN);
		   root.setAttributes("");
		   treeBeanList.add(root);
    	 for (NewsType newsType : typeList) {
			EasyUITreeBean bean = new EasyUITreeBean();
			bean.setId(newsType.getNewsTypeID()+"");
			bean.setPid(newsType.getParentID()+"");
			bean.setText(newsType.getSortName());
			bean.setAttributes("");
			///如果是有子节点的树节点，则默认把节点闭合
			if (newsType.getLeaf() == ConstConfig.EASYUI_TREE_TYPE_LEAF) {
				bean.setState(ConstConfig.EASYUI_TREE_STATE_CLOSED);
			}
			treeBeanList.add(bean);
		 }
		return EasyUITreeUtils.makeDwrChildTree(treeBeanList, id.toString());
	}

}
