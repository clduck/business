package com.business.service;

import java.io.Serializable;
import java.util.List;

import sun.security.action.GetBooleanAction;

import com.business.mgr.IBaseDAO;
import com.business.util.page.PageEntity;
import com.business.util.page.PagingResult;

/**
 * serverice基类
 * 
 * @author chenli
 * 
 * @param <T>
 */
public abstract class BaseService<T> implements IBaseService<T> {

	public abstract IBaseDAO<T, Long> getDaseDao();

	@Override
	public PagingResult<T> getPages(PageEntity<T> paeEntity) throws Exception {
		// TODO Auto-generated method stub
		return getDaseDao().selectPagination(paeEntity);
	}

	@Override
	public List<T> getList(T entity) throws Exception {
		// TODO Auto-generated method stub
		return getDaseDao().selectParam(entity);
	}

	@Override
	public void insertObject(T entity) throws Exception {
		// TODO Auto-generated method stub
		getDaseDao().insert(entity);
	}

	@Override
	public void modifyObject(T entity) throws Exception {
		// TODO Auto-generated method stub
		getDaseDao().update(entity);
	}

	@Override
	public void deleteObject(T entity) throws Exception {
		// TODO Auto-generated method stub
		getDaseDao().deleteParam(entity);
	}
	@Override
	public void deleteBatch(List<Long> ids) throws Exception{
		// TODO Auto-generated method stub
		getDaseDao().deleteBatch(ids);
	}
	@Override
	public T getObject(Long id) throws Exception{
		// TODO Auto-generated method stub
		return getDaseDao().selectPk(id);
	}
	
}