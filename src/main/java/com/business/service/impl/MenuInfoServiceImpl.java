package com.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.adminMgr.MenuInfoDao;
import com.business.model.MenuInfo;
import com.business.model.vo.menuInfoVo;
import com.business.service.MenuInfoService;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {
	private Log logger = LogFactory.getLog(MenuInfoServiceImpl.class);
	@Autowired
	private MenuInfoDao menuInfoDao;

	/**
	 * 获取处理后的菜单数据
	 */
	public List<menuInfoVo> getMenuInfos(MenuInfo menuInfoParam)throws Exception{
		List<MenuInfo> menuInfos =  menuInfoDao.queryMenuInfo(menuInfoParam);
		List<menuInfoVo> menuInfoVos = new ArrayList<menuInfoVo>();
		for (int i = 0; i < menuInfos.size(); i++) {
			if (-1 == menuInfos.get(i).getSuperMenu()) {
				menuInfoVo vo = new menuInfoVo();
				vo.setMenuInfo(menuInfos.get(i));
				menuInfoVos.add(vo);
			}
		}
		for (int i = 0; i < menuInfoVos.size(); i++) {
			List<MenuInfo> subMenuInfo = new ArrayList<MenuInfo>();
			for (int j = 0; j < menuInfos.size(); j++) {
				if (menuInfoVos.get(i).getMenuInfo().getMenuID() == menuInfos.get(j).getSuperMenu()) {
					subMenuInfo.add(menuInfos.get(j));
				}
			}
			menuInfoVos.get(i).setSubMenuInfos(subMenuInfo);
		}
		return menuInfoVos;
	}


}
