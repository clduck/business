package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;

import com.business.model.MenuInfo;

/**
 * 
 * @author duck
 * 
 */
public interface MenuInfoDao {
	/**
	 * 
	 * time : 2011-10-22 return : void description : 获取菜单信息
	 */
	public List<MenuInfo> queryMenuInfo(MenuInfo menuInfoParam) throws SQLException;

}
