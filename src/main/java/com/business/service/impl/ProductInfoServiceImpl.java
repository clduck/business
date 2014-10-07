package com.business.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.ProductInfoDao;
import com.business.model.CommonObject;
import com.business.model.ProductInfo;
import com.business.model.param.ProductParam;
import com.business.service.ProductInfoService;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
	private Log logger = LogFactory.getLog(ProductInfoServiceImpl.class);
	@Autowired
	private ProductInfoDao productInfoDao;

	public CommonObject getProductInfos(ProductParam productInfoParam,
			int start, int num) throws Exception {
		CommonObject object = new CommonObject();
		int total = productInfoDao.queryProductInfoCount(productInfoParam);
		List<ProductInfo> list = productInfoDao.queryProductInfo(productInfoParam, start, num);
		object.setRows(list);
		object.setTotal(total);
		return object;
	}

	public ProductInfo getProductInfo(ProductInfo productInfoParam) throws Exception {
		return productInfoDao.queryProductInfos(productInfoParam).get(0);
	}

	public void insertProductInfo(ProductInfo productInfoParam) throws Exception {
		productInfoDao.insertProductInfo(productInfoParam);

	}

	public void modifyProductInfo(ProductInfo productInfoParam) throws Exception {
		productInfoDao.modifyProductInfo(productInfoParam);

	}

	public void deleteProductInfo(List<Integer> productInfoIds) throws Exception {
		productInfoDao.deleteProductInfos(productInfoIds);
	}

}
