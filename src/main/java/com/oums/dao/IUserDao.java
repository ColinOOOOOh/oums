package com.oums.dao;

import com.oums.bean.po.UserPo;

/**
 * 
 * @author fantasy
 *
 */
public interface IUserDao {

	/**
	 * �����û��������û�
	 * @param user
	 * @return
	 */
	abstract UserPo getUserByName(String userName);
	
	/**
	 * 
	 */
	void test();
	
}
