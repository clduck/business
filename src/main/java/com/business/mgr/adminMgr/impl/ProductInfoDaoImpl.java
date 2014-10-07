package com.business.mgr.adminMgr.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.business.mgr.AbstractDao;
import com.business.mgr.adminMgr.ProductInfoDao;
import com.business.model.ProductInfo;
import com.business.model.param.ProductParam;
@Transactional
@Repository
public class ProductInfoDaoImpl extends AbstractDao implements ProductInfoDao {

	@SuppressWarnings("unchecked")
	public List<ProductInfo> queryProductInfos(ProductInfo productInfoParam)
			throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.ProductInfo.queryProductInfo",productInfoParam);
	}

	@SuppressWarnings("unchecked")
	public List<ProductInfo> queryProductInfo(ProductParam productInfoParam,
			int start, int nums) throws SQLException {
		return getSqlSession().selectList("com.cn.duck.model.ProductInfo.queryProduct", productInfoParam, new RowBounds(start, nums));
	}

	public int queryProductInfoCount(ProductParam productParam) throws SQLException {
		return  (Integer) getSqlSession().selectOne("com.cn.duck.model.ProductInfo.queryProductCount",productParam);
	}


	public Integer insertProductInfo(ProductInfo productInfoParam)
			throws SQLException {
		return getSqlSession().insert("com.cn.duck.model.ProductInfo.insertProductInfo", productInfoParam);
	}

	public void modifyProductInfo(ProductInfo productInfoParam)
			throws SQLException {
       getSqlSession().update("com.cn.duck.model.ProductInfo.modifyProductInfo", productInfoParam);
	}

	public void deleteProductInfos(List<Integer> productIds)
			throws SQLException {
       getSqlSession().delete("com.cn.duck.model.ProductInfo.deleteProductInfos", productIds);
	}


}
