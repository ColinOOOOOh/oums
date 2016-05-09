package com.oums.service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.UserVo;

public interface IUserService {

	/**
	 * ����
	 * @return
	 */
	ReturnMessage test();
	
	/**
	 * ע��
	 * @return
	 */
	ReturnMessage addUser(UserVo userVo);
	
	/**
	 * �����û��������û�
	 * @param userName
	 * @return
	 */
	ReturnMessage findUserByUserName(String userName);
	
}
