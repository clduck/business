package com.business.service;

import java.util.List;

import com.business.model.UserInfo;

public interface LoginService {

	public void insertUserInfoService(UserInfo userInfo);

	public List<UserInfo> getUserInfos();
}
