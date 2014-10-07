package com.business.model;

import java.io.Serializable;

public class Wch implements Serializable {

	private Integer id;
	private String gjz;
	private String jzlevel;
	private String sstatol;
	private String type;
	private String gjz1;

	public String getGjz() {
		return gjz;
	}

	public void setGjz(String gjz) {
		this.gjz = gjz;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJzlevel() {
		return jzlevel;
	}

	public void setJzlevel(String jzlevel) {
		this.jzlevel = jzlevel;
	}

	public String getSstatol() {
		return sstatol;
	}

	public void setSstatol(String sstatol) {
		this.sstatol = sstatol;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGjz1() {
		return gjz1;
	}

	public void setGjz1(String gjz1) {
		this.gjz1 = gjz1;
	}

}
