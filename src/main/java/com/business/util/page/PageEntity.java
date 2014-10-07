package com.business.util.page;


public class PageEntity<T> {
	private T t; // 传入的参数
	private String orderColumn;
	private String orderTurn = "ASC";
	
	private Integer totalRows; // 总行数
	private Integer pageSize = 20; // 每页显示的行数
	private Integer pageNo = 1; // 当前页号
	private Integer totalPages = 0; // 总页数
	private Integer startRow; // 当前页在数据库中的起始行
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	public String getOrderTurn() {
		return orderTurn;
	}
	public void setOrderTurn(String orderTurn) {
		this.orderTurn = orderTurn;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	
	

}
