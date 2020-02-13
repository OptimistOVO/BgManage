package com.bjsxt.service;

import java.util.List;

import com.bjsxt.bean.User;

public interface UserService {
	/*
	 * 登录验证
	 */
	boolean checkLogin(User u);

	boolean regUser(User u);

	List<User> selUserInfo();

}
