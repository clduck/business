package com.business.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.mgr.usermgr.UserInfoDao;
import com.business.model.UserInfo;
import com.business.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	private Log logger = LogFactory.getLog(LoginServiceImpl.class);
	@Autowired
	private UserInfoDao userInfoDao;

	public void insertUserInfoService(UserInfo userInfo) {
		try {
			userInfoDao.insertUserInfo(userInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<UserInfo> getUserInfos() {
		// TODO Auto-generated method stub
		return null;
	}

}
