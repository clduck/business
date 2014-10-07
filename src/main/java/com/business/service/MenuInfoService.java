package com.business.service;

import java.util.List;

import com.business.model.MenuInfo;
import com.business.model.vo.menuInfoVo;

public interface MenuInfoService {

	public List<menuInfoVo> getMenuInfos(MenuInfo menuInfoParam) throws Exception;
}
