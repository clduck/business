package com.business.service;

import java.util.List;

import com.business.model.CommonObject;
import com.business.model.ProductInfo;
import com.business.model.param.ProductParam;

public interface ProductInfoService {

	/**
	 *  @author cl
	 *  @time : 2012-1-13 
	 *  @return : CommonObject
	 *  @description : 获取产品信息列表分页
	 */
	public CommonObject getProductInfos(ProductParam productInfoParam,int start,int num) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<ProductInfo>
	 *  @description :获取产品信息
	 */
	public ProductInfo getProductInfo(ProductInfo productInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入产品信息
	 *  @return : void
	 *
	 */
	public void insertProductInfo(ProductInfo productInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改产品信息
	 *  @return : void
	 *
	 */
	public void modifyProductInfo(ProductInfo productInfoParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除产品信息
	 *  @return : void
	 *
	 */
	public void deleteProductInfo(List<Integer> productInfoIds) throws Exception;
}
