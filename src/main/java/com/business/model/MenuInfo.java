package com.business.model;

import java.io.Serializable;

public class MenuInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer menuID;
	private Integer menuType;
	private String menuName;
	private Integer superMenu;
	private Integer menuStatus;
	private String menuUrl;
	private String description;

	public Integer getMenuID() {
		return menuID;
	}

	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getSuperMenu() {
		return superMenu;
	}

	public void setSuperMenu(Integer superMenu) {
		this.superMenu = superMenu;
	}

	public Integer getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
