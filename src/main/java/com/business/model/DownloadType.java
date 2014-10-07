package com.business.model;

import java.io.Serializable;

public class DownloadType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer downloadTypeID;
	private String sortName;
	private Integer viewFlag;
	private Integer parentID;
	private String sortPath;
	private Integer clickNumber;
	private Integer leaf;
	private Integer status;
	private Integer oldParentID;

	public Integer getDownloadTypeID() {
		return downloadTypeID;
	}

	public void setDownloadTypeID(Integer downloadTypeID) {
		this.downloadTypeID = downloadTypeID;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
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
