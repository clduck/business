package com.business.util.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DwrTreeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	private String id = null;

	/**
	 * 父id
	 */
	private String pid = null;

	/**
	 * text
	 */
	private String text = null;

	/**
	 * 是否是叶子节点
	 */
	private Boolean leaf = null;

	/**
	 * 是否展开
	 */
	private Boolean expanded = null;

	/**
	 * 图标地址及名称
	 */
	private String icon = null;

	/**
	 * 传入传出参数 eg: menuId outSysId url
	 */
	private Map<String, String> mapParam = new HashMap<String, String>();;

	/**
	 * 孩子列表
	 */
	private List<DwrTreeBean> children = new ArrayList<DwrTreeBean>();

	/**
	 * append 参数
	 * 
	 * @param key
	 * @param value
	 */
	public void appendMapParam(String key, String value) {
		mapParam.put(key, value);
	}

	/**
	 * append 孩子节点
	 * 
	 * @param b
	 */
	public void appendChildren(DwrTreeBean b) {
		children.add(b);
	}

	public List<DwrTreeBean> getChildren() {
		return children;
	}

	public void setChildren(List<DwrTreeBean> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map getMapParam() {
		return mapParam;
	}

	public void setMapParam(Map<String, String> mapParam) {
		this.mapParam = mapParam;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getExpanded() {
		return expanded;
	}

	public void setExpanded(Boolean expanded) {
		this.expanded = expanded;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}
