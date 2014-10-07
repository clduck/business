package com.business.model.param;


public class ProductParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startTime; //起始时间
	private String endTime;   //结束时间
	private String productName;//模糊搜索产品名称 
	private Integer productTypeID; //产品类别ID

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductTypeID() {
		return productTypeID;
	}

	public void setProductTypeID(Integer productTypeID) {
		this.productTypeID = productTypeID;
	}

}
