package com.business.model.vo;

import java.util.List;

import com.business.model.MenuInfo;

public class menuInfoVo {
	private MenuInfo menuInfo;
	private List<MenuInfo> subMenuInfos;

	public MenuInfo getMenuInfo() {
		return menuInfo;
	}

	public void setMenuInfo(MenuInfo menuInfo) {
		this.menuInfo = menuInfo;
	}

	public List<MenuInfo> getSubMenuInfos() {
		return subMenuInfos;
	}

	public void setSubMenuInfos(List<MenuInfo> subMenuInfos) {
		this.subMenuInfos = subMenuInfos;
	}

}