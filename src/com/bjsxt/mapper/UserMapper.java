package com.bjsxt.mapper;

import com.bjsxt.bean.User;

public interface UserMapper {
	/**
	 * 
	 * @Title: selUserByName   
	 * @Description:根据用户名查找用户信息
	 * @param username
	 * @return User      
	 * @throws
	 */
	User selUserByName(String username);
	
	int regUser(User u);
}
