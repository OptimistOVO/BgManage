package com.bjsxt.dao;

import com.bjsxt.bean.User;

public interface UserDao {

	boolean checkLogin(User u);

	Boolean checkRepeat(User u);

	int regUser(User u);

}
