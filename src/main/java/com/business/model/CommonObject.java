package com.business.model;

import java.util.ArrayList;
import java.util.List;

public class CommonObject {

	private int total;
	private List<? extends Object> rows = new ArrayList<Object>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<? extends Object> getRows() {
		return rows;
	}

	public void setRows(List<? extends Object> rows) {
		this.rows = rows;
	}
}
