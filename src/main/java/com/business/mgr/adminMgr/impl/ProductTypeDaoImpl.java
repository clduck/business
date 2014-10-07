package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.ProductTypeDao;
import com.business.model.ProductType;
@Transactional
@Repository
public class ProductTypeDaoImpl extends AbstractDao implements ProductTypeDao {

	public List<ProductType> queryProductTypes(ProductType productTypeParam)
			throws SQLException {
	     return getSqlSession().selectList("com.cn.duck.model.ProductType.queryProductTypes", productTypeParam);
	}

	public Integer insertProductType(ProductType productTypeParam) throws SQLException {
		 getSqlSession().insert("com.cn.duck.model.ProductType.insertProductType", productTypeParam);
		return productTypeParam.getProductTypeID();
	}

	public void modifyProductType(ProductType productTypeParam) throws SQLException {
		 getSqlSession().update("com.cn.duck.model.ProductType.modifyProductType", productTypeParam);
	}

	public void deleteProductTypes(ProductType productTypeParam) throws SQLException {
        getSqlSession().delete("com.cn.duck.model.ProductType.deleteProductType", productTypeParam);
	}

	public void modifySortPath(Map<String, String> sortPathMap) throws SQLException {
		getSqlSession().delete("com.cn.duck.model.ProductType.modifySortPath", sortPathMap);
	}

	public void modifyParentLeaf(Integer parentID) throws SQLException {
		getSqlSession().delete("com.cn.duck.model.ProductType.modifyParentLeaf", parentID);
	}

	public List<ProductType> selectSortPath(ProductType productTypeParam) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.ProductType.selectSortPath", productTypeParam);
	}

}
