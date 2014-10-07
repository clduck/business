package com.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.DownloadTypeDao;
import com.business.model.DownloadType;
import com.business.service.DownloadTypeService;
import com.business.util.common.ConstConfig;
import com.business.util.tree.EasyUITreeBean;
import com.business.util.tree.EasyUITreeUtils;
@Service
public class DownloadTypeServiceImpl implements DownloadTypeService {
	private Log logger = LogFactory.getLog(DownloadTypeServiceImpl.class);
	@Autowired
	private DownloadTypeDao downloadTypeDao;

	/**
	 * 构造下载树型结构数据
	 */
	public List<EasyUITreeBean> getDownloadTypeTreeData() throws Exception {
		List<DownloadType> typeList = downloadTypeDao.queryDownloadTypes(new DownloadType());
		return downloadTypeList2DwrTreeBean(typeList,ConstConfig.EASYUI_TREE_ROOT_VALUE);
	}
	/**
	 * DownloadTypeList to DwrTreeList
	 * @param list 下载类型列表
	 * @param id  去除父亲节点的id
     * @return List 下载类型列表（DWR树）
	 */
	private List<EasyUITreeBean> downloadTypeList2DwrTreeBean(List<DownloadType> typeList, Integer id) {
		List<EasyUITreeBean> treeBeanList   = new ArrayList<EasyUITreeBean>();
		   EasyUITreeBean root = new EasyUITreeBean();
		   root.setId("0");
		   root.setPid("-1");
		   root.setText("根节点（点击选择）");
		   root.setState(ConstConfig.EASYUI_TREE_STATE_OPEN);
		   root.setAttributes("");
		   treeBeanList.add(root);
    	 for (DownloadType downloadType : typeList) {
			EasyUITreeBean bean = new EasyUITreeBean();
			bean.setId(downloadType.getDownloadTypeID()+"");
			bean.setPid(downloadType.getParentID()+"");
			bean.setText(downloadType.getSortName());
			bean.setAttributes("");
			///如果是有子节点的树节点，则默认把节点闭合
			if (downloadType.getLeaf() == ConstConfig.EASYUI_TREE_TYPE_LEAF) {
				bean.setState(ConstConfig.EASYUI_TREE_STATE_CLOSED);
			}
			treeBeanList.add(bean);
		 }
		return EasyUITreeUtils.makeDwrChildTree(treeBeanList, id.toString());
	}
   /**
    * 获取下载类别信息
    */
	public DownloadType getDownloadType(DownloadType downloadTypeParam) throws Exception {
		List<DownloadType> list = downloadTypeDao.queryDownloadTypes(downloadTypeParam);
		if (list.isEmpty() || list ==null) {
			return null;
		}else{
			return list.get(0);
		}
	}
   /**
    * 插入下载类别信息
    */
	public void insertDownloadType(DownloadType downloadTypeParam) throws Exception {
		//获取父节点的sortPath
		DownloadType  parentDownloadTypeParam = new DownloadType();
		parentDownloadTypeParam.setDownloadTypeID(downloadTypeParam.getParentID());
		
		DownloadType parentDownloadType = getDownloadType(parentDownloadTypeParam);
		//如果添加的是一级下载类型，则父节点的sortPath 为0
		String sortPath = "0,";
		if (parentDownloadType != null) {
			sortPath = parentDownloadType.getSortPath();
		}
		parentDownloadTypeParam.setSortPath(sortPath);
		Integer downloadTypeId  = downloadTypeDao.insertDownloadType(downloadTypeParam);
		sortPath = sortPath+downloadTypeId+",";
		downloadTypeParam = new DownloadType();
		downloadTypeParam.setDownloadTypeID(downloadTypeId);
		downloadTypeParam.setSortPath(sortPath);
		//重新更新下载类型的sortPath
		downloadTypeDao.modifyDownloadType(downloadTypeParam);
		
		//修改父节点的leaf状态
		parentDownloadTypeParam.setLeaf(0);
		downloadTypeDao.modifyDownloadType(parentDownloadTypeParam);
	} 
    /**
     * 更新下载类别信息
     */
	public void modifyDownloadType(DownloadType downloadTypeParam) throws Exception {
		//获取父节点的sortPath
		DownloadType  parentDownloadTypeParam = new DownloadType();
		parentDownloadTypeParam.setDownloadTypeID(downloadTypeParam.getParentID());
		DownloadType parentDownloadType = getDownloadType(parentDownloadTypeParam);
		String newSortPath = "";
		if (parentDownloadType != null) {
			 newSortPath = parentDownloadType.getSortPath()+downloadTypeParam.getDownloadTypeID()+",";
		}else{
			 newSortPath = "0,"+downloadTypeParam.getDownloadTypeID()+",";
		}
		
		String oldSortPath = downloadTypeParam.getSortPath();
		Map<String, String> sortPathMap = new HashMap<String, String>();
		sortPathMap.put("oldSortPath", oldSortPath);
		sortPathMap.put("newSortPath", newSortPath);
		
		downloadTypeParam.setSortPath(newSortPath);
		parentDownloadTypeParam.setLeaf(0);
		downloadTypeDao.modifyDownloadType(parentDownloadTypeParam);
		downloadTypeDao.modifyDownloadType(downloadTypeParam);
		downloadTypeDao.modifySortPath(sortPathMap);
        downloadTypeDao.modifyParentLeaf(downloadTypeParam.getOldParentID());	
	}
   /**
    * 删除下载类别信息
    */
	public void deleteDownloadType(Integer downloadTypeId) throws Exception {
		DownloadType downloadTypeParam = new DownloadType();
		downloadTypeParam.setDownloadTypeID(downloadTypeId);
		DownloadType downloadType = getDownloadType(downloadTypeParam);
		downloadTypeParam.setSortPath(downloadType.getSortPath());
		downloadTypeDao.deleteDownloadTypes(downloadTypeParam);	
		downloadTypeDao.modifyParentLeaf(downloadType.getParentID());
	}


}
