package com.business.service;

import java.io.Serializable;
import java.util.List;

import com.business.util.page.PageEntity;
import com.business.util.page.PagingResult;

/**
 * serverice基类接口
 * @author chenli
 *
 * @param <T>
 */
public interface IBaseService<T> {

	/**
	 *  @author cl
	 *  @time : 2012-1-13 
	 *  @return : PagingResult
	 *  @description : 获取对象列表分页
	 */
	public PagingResult<T> getPages(PageEntity<T> pageEntity) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-14 
	 *  @return : List<T>
	 *  @description :获取对象
	 */
	public List<T> getList(T entity) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 插入对象
	 *  @return : void
	 *
	 */
	public void insertObject(T entity) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-17 
	 *  @author :cl
	 *  @description : 修改对象
	 *  @return : void
	 *
	 */
	public void modifyObject(T entity) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除对象
	 *  @return : void
	 *
	 */
	public void deleteObject(T entity) throws Exception;
	/**
	 * 
	 *  @time : 2012-1-30 
	 *  @author :cl
	 *  @description : 删除对象
	 *  @return : void
	 *
	 */
	public void deleteBatch(List<Long> ids) throws Exception;
	/**
	 * 
	 * @param l
	 * @return
	 * @throws Exception
	 */
	public T getObject(Long id) throws Exception;
	
}