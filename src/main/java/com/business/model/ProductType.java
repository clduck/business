package com.business.model;

import java.io.Serializable;

public class ProductType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productTypeID;
	private String productTypeName;
	private Integer viewFlag;
	private Integer parentID;
	private String sortPath;
	private Integer clickNumber;
	private String picture;
	private String summary; // 概要
	private Integer sequence;
	private Integer leaf;
	private Integer status;
	private Integer oldParentID;

	public Integer getProductTypeID() {
		return productTypeID;
	}

	public void setProductTypeID(Integer productTypeID) {
		this.productTypeID = productTypeID;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public Integer getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(Integer viewFlag) {
		this.viewFlag = viewFlag;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getSortPath() {
		return sortPath;
	}

	public void setSortPath(String sortPath) {
		this.sortPath = sortPath;
	}

	public Integer getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getLeaf() {
		return leaf;
	}

	public void setLeaf(Integer leaf) {
		this.leaf = leaf;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOldParentID() {
		return oldParentID;
	}

	public void setOldParentID(Integer oldParentID) {
		this.oldParentID = oldParentID;
	}

}
