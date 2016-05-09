package com.oums.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.UserPo;
import com.oums.bean.vo.UserVo;
import com.oums.dao.IBaseDao;
import com.oums.dao.IUserDao;
import com.oums.service.IUserService;
import com.oums.util.MD5Util;

@Service("userServer")
public class UserServiceImpl implements IUserService {

	@Autowired
	IBaseDao basicDao;
	
	@Autowired
	IUserDao userDao;

	@Override
	public ReturnMessage addUser(UserVo userVo) {
		System.out.println("����server����");
		ReturnMessage returnMessage = new ReturnMessage();

		if (userVo.getUserName() != null || userVo.getPassword() != null)
			try {
				UserPo po = new UserPo();
				po.setUserName(userVo.getUserName());
				// ����
				po.setPassword(MD5Util.MD5(userVo.getPassword()));
				basicDao.add(po);
				returnMessage.setFlat(true);
				returnMessage.setContent("ע��ɹ�  " + userVo);
			} catch (Exception e) {
				e.printStackTrace();
				returnMessage.setFlat(false);
				returnMessage.setContent("ע��ʧ��");
			}

		else {
			returnMessage.setFlat(false);
			returnMessage.setContent("�˺Ż�����Ϊ��");
		}

		return returnMessage;
	}

	@Override
	public ReturnMessage findUserByUserName(String userName) {
		ReturnMessage returnMessage = new ReturnMessage();
		System.out.println("����server����");
		if(userName != null)
		try{
			System.out.println("����try");
			//��Ҫһ��po vo ת��
			UserPo userPo = userDao.getUserByName(userName);
			UserVo userVo = new UserVo();
			userVo.setUserName(userPo.getUserName());
			userVo.setPassword(userPo.getPassword());
						
			returnMessage.setFlat(true);
			returnMessage.setObject(userVo);
		}catch (Exception e){
			System.out.println("����Exception");
			e.printStackTrace();
		}
		
		return returnMessage;
	}

	@Override
	public ReturnMessage test() {
		System.out.println("testService");
		userDao.test();
		return null;
	}

}
