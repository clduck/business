package com.business.model.param;

import java.util.Date;
import java.util.List;

/**
 * aboutInfo 参数类
 * 
 * @author chenli
 * 
 */
public class AboutInfoParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.Long seqId;
	private Integer aboutID;
	private String aboutName;
	private Integer viewFlag;
	private String content;
	private Integer clickNumber;
	private Integer sequence;
	private String groupID;
	private String exclusive;
	private Integer childFlag;
	private Date addTime;
	private Date updateTime;
	private Integer parentID;
	private String sortPath;
	private Integer status;
	private String orderColumn;
	private String orderTurn;
	private List<Long> ids;

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

	public java.lang.Long getSeqId() {
		return seqId;
	}

	public void setSeqId(java.lang.Long seqId) {
		this.seqId = seqId;
	}

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

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	
}
