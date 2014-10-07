package com.business.util.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页结果
 * @author hwt
 *
 */
public class PagingResult<T> {
	//当前页
	private int currentPage;
	//总共记录条数
	private int totalSize;
	//结果集
	private List<T> rows = new ArrayList<T>();
	//分页结果
	private PageEntity<T> pager;
	//排序
	private String sort;
	//描述
	private String direction;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public PageEntity<T> getPager() {
		return pager;
	}
	public void setPager(PageEntity<T> pager) {
		this.pager = pager;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	
}
