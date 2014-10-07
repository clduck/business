package com.business.model;

import java.io.Serializable;
import java.util.Date;

public class DownloadInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer downloadID;
	private String downloadName;
	private Integer viewFlag;
	private Integer sortID;
	private String sortName;
	private String sortPath;
	private String filesize;
	private String fileUrl;
	private Integer commendFlag;
	private String groupID;
	private Integer exclusive;
	private String content;
	private Integer clickNumber;
	private Date addTime;
	private String addTimeStr;
	private Date updateTime;
	private String updateTimeStr;
	private String seoKeywords;
	private String seoDescription;

	public Integer getDownloadID() {
		return downloadID;
	}

	public void setDownloadID(Integer downloadID) {
		this.downloadID = downloadID;
	}

	public String getDownloadName() {
		return downloadName;
	}

	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName;
	}

	public Integer getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(Integer viewFlag) {
		this.viewFlag = viewFlag;
	}

	public Integer getSortID() {
		return sortID;
	}

	public void setSortID(Integer sortID) {
		this.sortID = sortID;
	}

	public String getSortPath() {
		return sortPath;
	}

	public void setSortPath(String sortPath) {
		this.sortPath = sortPath;
	}

	public String getFilesize() {
		return filesize;
	}

	public void setFilesize(String filesize) {
		this.filesize = filesize;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Integer getCommendFlag() {
		return commendFlag;
	}

	public void setCommendFlag(Integer commendFlag) {
		this.commendFlag = commendFlag;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public Integer getExclusive() {
		return exclusive;
	}

	public void setExclusive(Integer exclusive) {
		this.exclusive = exclusive;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getAddTimeStr() {
		return addTimeStr;
	}

	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

}
