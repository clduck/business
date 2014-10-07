package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;

import com.business.model.ProductInfo;
import com.business.model.param.ProductParam;

/**
 * 
 * @author duck
 * 
 */
public interface ProductInfoDao  {
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取产品信息（分页）
	 */
	public List<ProductInfo> queryProductInfo(ProductParam productInfoParam,int start,int nums) throws SQLException;
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : void 
	 * @description : 获取产品总数（分页）
	 */
	public int queryProductInfoCount(ProductParam productParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-1 
	 *  @author :cl
	 *  @description : 获取产品信息（不分页）
	 *  @return : List<ProductInfo>
	 *
	 */
	public List<ProductInfo> queryProductInfos(ProductInfo productInfoParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入产品信息
	 *  @return : void
	 *
	 */
	public Integer insertProductInfo(ProductInfo productInfoParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改产品信息
	 *  @return : void
	 *
	 */
	public void modifyProductInfo(ProductInfo productInfoParam) throws SQLException;
	
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除产品信息
	 *  @return : void
	 *
	 */
	public void deleteProductInfos(List<Integer> productIds) throws SQLException;
}
