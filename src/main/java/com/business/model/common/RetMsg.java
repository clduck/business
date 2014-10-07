package com.business.model.common;

import java.util.List;

/**
 * 
 * @author cl
 * 
 */
public class RetMsg implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int code = 0;// 0 success other fail
	private String msg = "";
	private Object retobj = null;
	private List retlist = null;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getRetobj() {
		return retobj;
	}

	public void setRetobj(Object retobj) {
		this.retobj = retobj;
	}

	public List getRetlist() {
		return retlist;
	}

	public void setRetlist(List retlist) {
		this.retlist = retlist;
	}
}
