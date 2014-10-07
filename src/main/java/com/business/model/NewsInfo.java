package com.business.model;

import java.io.Serializable;
import java.util.Date;

public class NewsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer newsID;
	private String newsName;
	private Integer viewFlag;
	private Integer sortID;
	private String sortPath;
	private String groupID;
	private String exclusive;
	private Integer noticeFlag;
	private String source;
	private String content;
	private Integer clickNumber;
	private Date addTime;
	private String addTimeStr;
	private Integer pictureFlag;
	private String pictures;
	private String seoKeywords;
	private String seoDescription;
	private String sortName;
	private Integer status;

	public Integer getNewsID() {
		return newsID;
	}

	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
	}

	public String getNewsName() {
		return newsName;
	}

	public void setNewsName(String newsName) {
		this.newsName = newsName;
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

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getExclusive() {
		return exclusive;
	}

	public void setExclusive(String exclusive) {
		this.exclusive = exclusive;
	}

	public Integer getNoticeFlag() {
		return noticeFlag;
	}

	public void setNoticeFlag(Integer noticeFlag) {
		this.noticeFlag = noticeFlag;
	}

	public Integer getClickNumber() {
		return clickNumber;
	}

	public void setClickNumber(Integer clickNumber) {
		this.clickNumber = clickNumber;
	}

	public Integer getPictureFlag() {
		return pictureFlag;
	}

	public void setPictureFlag(Integer pictureFlag) {
		this.pictureFlag = pictureFlag;
	}

	public String getPictures() {
		return pictures;
	}

	public void setPictures(String pictures) {
		this.pictures = pictures;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

}
