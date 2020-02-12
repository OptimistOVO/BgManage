package com.bjsxt.serviceImpl;

import com.bjsxt.bean.User;
import com.bjsxt.dao.UserDao;
import com.bjsxt.daoImpl.UserDaoImpl;
import com.bjsxt.service.UserService;

public class UserServiceImpl implements UserService {
	/**
	 * 登录验证
	 */
	@Override
	public boolean checkLogin(User u) {
		UserDao dao = new UserDaoImpl();
		return dao.checkLogin(u);
		
	}
	/**
	 * 用户注册功能
	 */
	@Override
	public boolean regUser(User u) {
		UserDao dao = new UserDaoImpl();
		Boolean b = dao.checkRepeat(u);
		if(b==true) {
			int i = dao.regUser(u);
			if(i>0) {
				return true;
			}
		}
		return false;
	}

}
