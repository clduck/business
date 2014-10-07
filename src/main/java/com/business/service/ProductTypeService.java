package com.business.service;

import java.util.List;

import com.business.model.ProductType;
import com.business.util.tree.EasyUITreeBean;

public interface ProductTypeService {

	/**
	 * 
	 *  @time : 2012-2-1 
	 *  @author :cl
	 *  @description : 构造产品类别树结构数据
	 *  @return : List<EasyUITreeBean>
	 *
	 */
    public List<EasyUITreeBean> getProductTypeTreeData() throws Exception; 
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<ProductType>
	 *  @description :获取产品类别信息
	 */
	public ProductType getProductType(ProductType productTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入产品类别信息
	 *  @return : void
	 *
	 */
	public void insertProductType(ProductType productTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改产品类别信息
	 *  @return : void
	 *
	 */
	public void modifyProductType(ProductType productTypeParam) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除产品类别信息
	 *  @return : void
	 *
	 */
	public void deleteProductType(Integer productTypeId) throws Exception;
}
