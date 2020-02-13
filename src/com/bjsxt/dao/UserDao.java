package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.bean.User;

public interface UserDao {

	boolean checkLogin(User u);

	Boolean checkRepeat(User u);

	int regUser(User u);

	List<User> selUserInfo();

}
