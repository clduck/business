package com.business.mgr.adminMgr;

import java.sql.SQLException;
import java.util.List;

import com.business.model.MemGroup;

/**
 * 
 * @author duck
 * 
 */
public interface MemGroupDao  {
	/**
	 * 
	 * time : 2011-10-22 return : void description : 获取群组信息
	 */
	public List<MemGroup> queryMemGroup(MemGroup memGroupParam) throws SQLException;


}
