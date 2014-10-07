package com.business.model;

import java.io.Serializable;

public class MemGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String groupId;
	private String groupName;
	private Integer groupLevel;
	private String explain;
	private String addTime;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getGroupLevel() {
		return groupLevel;
	}

	public void setGroupLevel(Integer groupLevel) {
		this.groupLevel = groupLevel;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

}
