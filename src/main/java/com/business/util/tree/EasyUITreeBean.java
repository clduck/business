package com.business.util.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author cl
 * @description:
 *  id: node id, which is important to load remote data 
 *  text: node text to show 
 *  state: node state, 'open' or 'closed', default is 'open'. When set to 'closed', the node have children nodes and will load them from remote site 
 *  checked: Indicate whether the node is checked selected. 
 *  attributes: custom attributes can be added to a node 
 *  children: an array nodes defines some children nodes 
 *
 */
public class EasyUITreeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
    
	private String id = null;
	private String pid = null;
	private String text = null;
	private String state = null;
	private Boolean checked = null;
	private Object attributes = new Object();
    private String iconCls = null; 
	private List<EasyUITreeBean> children = new ArrayList<EasyUITreeBean>();

	public void appendChildren(EasyUITreeBean b) {
		children.add(b);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public List<EasyUITreeBean> getChildren() {
		return children;
	}

	public void setChildren(List<EasyUITreeBean> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}




	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}
