package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.business.model.ProductType;

/**
 * 
 * @author duck
 * 
 */
public interface ProductTypeDao  {
	/**
	 * 
	 * @time : 2011-10-22 
	 * @return : 
	 * @void description : 获取产品类别信息
	 */
	public List<ProductType> queryProductTypes(ProductType productTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入产品类别信息
	 *  @return : void
	 *
	 */
	public Integer insertProductType(ProductType productTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改产品类别信息
	 *  @return : void
	 *
	 */
	public void modifyProductType(ProductType productTypeParam) throws SQLException;
	
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除产品类别信息
	 *  @return : void
	 *
	 */
	public void deleteProductTypes(ProductType productTypeParam) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-25 
	 *  @author :cl
	 *  @description : 修改产品类型的sortPath
	 *  @return : void
	 *
	 */
	public void modifySortPath(Map<String, String> sortPathMap) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-26 
	 *  @author :cl
	 *  @description : 修改父节点的leaf状态
	 *  @return : void
	 *
	 */
	public void modifyParentLeaf(Integer parentID) throws SQLException;
	/**
	 * 
	 *  @time : 2012-2-26 
	 *  @author :cl
	 *  @description : 修改父节点的leaf状态
	 *  @return : void
	 *
	 */
	public List<ProductType> selectSortPath(ProductType productTypeParam) throws SQLException;
}
