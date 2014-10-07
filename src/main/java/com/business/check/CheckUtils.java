package com.business.check;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.business.mgr.usermgr.UserInfoDao;
import com.business.model.UserInfo;
/**
 * 
 * @author duck
 * @description 校验类
 *
 */
@Controller
@RequestMapping(value = "/check.do", method = RequestMethod.POST)
public class CheckUtils {
	private Log logger = LogFactory.getLog(CheckUtils.class);
	@Autowired
	private UserInfoDao userInfoDao;
	
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	/**
	 * 
	 *  time : 2011-11-3 
	 *  return : boolean
	 *  description :校验用户名是否存在。
	 */
	@RequestMapping(params="method=checkUserName")   
	public void checkUserName(@RequestParam("userName") String userName, HttpServletResponse response){
		logger.info("===========校验用户名是否可用=============");
		boolean flag = true;
		try {
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(userName.toString().trim());
			List<UserInfo> list = userInfoDao.queryUserInfo(userInfo);
			if (list.size() > 0) {
				flag = false;
			}
		 response.getWriter().print("{\"checked\":\""+flag+"\"}");   
		} catch (Exception e) {
            logger.error("校验用户名是否存在失败:", e);
		}
	}
}
