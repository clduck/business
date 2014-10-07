package com.business.mgr.usermgr;

import java.sql.SQLException;
import java.util.List;

import com.business.model.UserInfo;
import com.business.model.Wch;

/**
 * 
 * @author duck
 * 
 */
public interface UserInfoDao {
	/**
	 * 
	 * time : 2011-10-22 return : void description : 保存用户信息
	 */
	public void insertUserInfo(UserInfo userInfo) throws SQLException;
	/**
	 * 
	 * time : 2011-10-22 return : void description : 修改用户信息
	 */
	public void modifyUserInfo(UserInfo userInfo) throws SQLException;
	/**
	 * 
	 * time : 2011-10-22 return : void description : 获取用户信息
	 */
	public List<UserInfo> queryUserInfo(UserInfo userInfo) throws SQLException;
	
    public List<Wch> queryWch (Wch wch) throws SQLException;
    
    public List<Wch> wchSelectByLike(List<String> wchInfoIds)throws SQLException;
    
    public void  updateWch(Wch wch)throws SQLException;
    
    public void insertWch(Wch wch) throws SQLException;
}
