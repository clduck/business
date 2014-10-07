package com.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.ProductTypeDao;
import com.business.model.ProductType;
import com.business.service.ProductTypeService;
import com.business.util.common.ConstConfig;
import com.business.util.tree.EasyUITreeBean;
import com.business.util.tree.EasyUITreeUtils;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	private Log logger = LogFactory.getLog(ProductTypeServiceImpl.class);
	@Autowired
	private ProductTypeDao productTypeDao;

	/**
	 * 构造产品树型结构数据
	 */
	public List<EasyUITreeBean> getProductTypeTreeData() throws Exception {
		List<ProductType> typeList = productTypeDao.queryProductTypes(new ProductType());
		return productTypeList2DwrTreeBean(typeList,ConstConfig.EASYUI_TREE_ROOT_VALUE);
	}
	/**
	 * ProductTypeList to DwrTreeList
	 * @param list 产品类型列表
	 * @param id  去除父亲节点的id
     * @return List 产品类型列表（DWR树）
	 */
	private List<EasyUITreeBean> productTypeList2DwrTreeBean(List<ProductType> typeList, Integer id) {
		List<EasyUITreeBean> treeBeanList   = new ArrayList<EasyUITreeBean>();
		   EasyUITreeBean root = new EasyUITreeBean();
		   root.setId("0");
		   root.setPid("-1");
		   root.setText("根节点（点击选择）");
		   root.setState(ConstConfig.EASYUI_TREE_STATE_OPEN);
		   root.setAttributes("");
		   treeBeanList.add(root);
    	 for (ProductType productType : typeList) {
			EasyUITreeBean bean = new EasyUITreeBean();
			bean.setId(productType.getProductTypeID()+"");
			bean.setPid(productType.getParentID()+"");
			bean.setText(productType.getProductTypeName());
			bean.setAttributes("");
			///如果是有子节点的树节点，则默认把节点闭合
			if (productType.getLeaf() == ConstConfig.EASYUI_TREE_TYPE_LEAF) {
				bean.setState(ConstConfig.EASYUI_TREE_STATE_CLOSED);
			}
			treeBeanList.add(bean);
		 }
		return EasyUITreeUtils.makeDwrChildTree(treeBeanList, id.toString());
	}
   /**
    * 获取产品类别信息
    */
	public ProductType getProductType(ProductType productTypeParam) throws Exception {
		List<ProductType> list = productTypeDao.queryProductTypes(productTypeParam);
		if (list.isEmpty() || list ==null) {
			return null;
		}else{
			return list.get(0);
		}
	}
   /**
    * 插入产品类别信息
    */
	public void insertProductType(ProductType productTypeParam) throws Exception {
		//获取父节点的sortPath
		ProductType  parentProductTypeParam = new ProductType();
		parentProductTypeParam.setProductTypeID(productTypeParam.getParentID());
		
		ProductType parentProductType = getProductType(parentProductTypeParam);
		//如果添加的是一级产品类型，则父节点的sortPath 为0
		String sortPath = "0,";
		if (parentProductType != null) {
			sortPath = parentProductType.getSortPath();
		}
		parentProductTypeParam.setSortPath(sortPath);
		Integer productTypeId  = productTypeDao.insertProductType(productTypeParam);
		sortPath = sortPath+productTypeId+",";
		productTypeParam = new ProductType();
		productTypeParam.setProductTypeID(productTypeId);
		productTypeParam.setSortPath(sortPath);
		//重新更新产品类型的sortPath
		productTypeDao.modifyProductType(productTypeParam);
		
		//修改父节点的leaf状态
		parentProductTypeParam.setLeaf(0);
		productTypeDao.modifyProductType(parentProductTypeParam);
	} 
    /**
     * 更新产品类别信息
     */
	public void modifyProductType(ProductType productTypeParam) throws Exception {
		//获取父节点的sortPath
		ProductType  parentProductTypeParam = new ProductType();
		parentProductTypeParam.setProductTypeID(productTypeParam.getParentID());
		ProductType parentProductType = getProductType(parentProductTypeParam);
		String newSortPath = "";
		if (parentProductType != null) {
			 newSortPath = parentProductType.getSortPath()+productTypeParam.getProductTypeID()+",";
		}else{
			 newSortPath = "0,"+productTypeParam.getProductTypeID()+",";
		}
		
		String oldSortPath = productTypeParam.getSortPath();
		Map<String, String> sortPathMap = new HashMap<String, String>();
		sortPathMap.put("oldSortPath", oldSortPath);
		sortPathMap.put("newSortPath", newSortPath);
		
		productTypeParam.setSortPath(newSortPath);
		parentProductTypeParam.setLeaf(0);
		productTypeDao.modifyProductType(parentProductTypeParam);
		productTypeDao.modifyProductType(productTypeParam);
		productTypeDao.modifySortPath(sortPathMap);
        productTypeDao.modifyParentLeaf(productTypeParam.getOldParentID());	
	}
   /**
    * 删除产品类别信息
    */
	public void deleteProductType(Integer productTypeId) throws Exception {
		ProductType productTypeParam = new ProductType();
		productTypeParam.setProductTypeID(productTypeId);
		ProductType productType = getProductType(productTypeParam);
		productTypeParam.setSortPath(productType.getSortPath());
		productTypeDao.deleteProductTypes(productTypeParam);	
		productTypeDao.modifyParentLeaf(productType.getParentID());
	}


}
