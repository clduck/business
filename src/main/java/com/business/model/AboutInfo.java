package com.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.business.model.param.AboutInfoParam;

/**
 * @name 企业信息
 * @author cl
 * 
 */
public class AboutInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//属性begin
	/*
	 *  
	 */
	private java.lang.Long seqId;
	/*
	 * 创建时间 
	 */
	private java.util.Date createTime;
	/*
	 * 创建人 
	 */
	private java.lang.Long createUserId;
	/*
	 * 更新时间 
	 */
	private java.util.Date updateTime;
	/*
	 * 更新人 
	 */
	private java.lang.Long updateUserId;
	/*
	 * 排序 
	 */
	private java.lang.Integer dataOrder;
	/*
	 * 1正常2删除 
	 */
	private java.lang.Integer isDel;
	
	private Integer aboutID;
	private String aboutName;
	private Integer viewFlag;
	private String content;
	private Integer clickNumber;
	private Integer sequence;
	private String groupID;
	private String exclusive;
	private Integer childFlag;
	private Date addTime = new Date();
	private Integer parentID;
	private String sortPath;
	private Integer status;
	private AboutInfoParam conditions;

	public Integer getAboutID() {
		return aboutID;
	}

	public void setAboutID(Integer aboutID) {
		this.aboutID = aboutID;
	}

	public String getAboutName() {
		return aboutName;
	}

	public void setAboutName(String aboutName) {
		this.aboutName = aboutName;
	}

	public Integer getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(Integer viewFlag) {
		this.viewFlag = viewFlag;
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

	public Integer getSequence() {
		return sequence;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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

	public Integer getChildFlag() {
		return childFlag;
	}

	public void setChildFlag(Integer childFlag) {
		this.childFlag = childFlag;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public AboutInfoParam getConditions() {
		return conditions;
	}

	public void setConditions(AboutInfoParam conditions) {
		this.conditions = conditions;
	}
	

	public java.lang.Long getSeqId() {
		return seqId;
	}

	public void setSeqId(java.lang.Long seqId) {
		this.seqId = seqId;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public java.lang.Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(java.lang.Long createUserId) {
		this.createUserId = createUserId;
	}

	public java.lang.Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(java.lang.Long updateUserId) {
		this.updateUserId = updateUserId;
	}

	public java.lang.Integer getDataOrder() {
		return dataOrder;
	}

	public void setDataOrder(java.lang.Integer dataOrder) {
		this.dataOrder = dataOrder;
	}

	public java.lang.Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(java.lang.Integer isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();

		StringBuffer sb = new StringBuffer();
		sb.append(" 详细信息   ");
		sb.append(" ;aboutID : " + aboutID);
		sb.append(" ;aboutName : " + aboutName);
		return sb.toString();
	}

}
