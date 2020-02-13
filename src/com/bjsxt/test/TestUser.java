package com.bjsxt.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bjsxt.bean.User;
import com.bjsxt.dao.UserDao;
import com.bjsxt.daoImpl.UserDaoImpl;
import com.bjsxt.service.UserService;
import com.bjsxt.serviceImpl.UserServiceImpl;
import com.bjsxt.util.MyBatisUtil;

public class TestUser {
	
	/**
	 * 
	 * @Title: testLogin   
	 * @Description: 
	 * @throws
	 */
	@Test
	public void testLogin() {
		
//		SqlSession session = MyBatisUtil.getSqlsession();
//		UserMapper mapper = session.getMapper(UserMapper.class);		
//		User user = mapper.selUserByName("aaa"); 
//			System.out.println(user);
		User u = new User();
		u.setPassword("111");
		u.setUsername("aaa");
		UserDao dao = new UserDaoImpl();
		boolean b = dao.checkLogin(u);
		System.out.println(b);
		}		
	
	@Test
	public void testReg() {
		User u = new User();
		u.setPassword("123");
		u.setUsername("ddd");
		u.setAge(18);
		u.setSex("男");
		u.setBirthday("2000-07-19");
//		UserDao dao = new UserDaoImpl();
//		Boolean b = dao.checkRepeat(u);
//		System.out.println(b);
//		if(b==true) {
//			int i = dao.regUser(u);
//			System.out.println("i= "+i);
//		}
		
		boolean a = new UserServiceImpl().regUser(u);
		System.out.println(a);
	}
	
	@Test
	public void selUserInfo() {
		UserService us = new UserServiceImpl();
		List<User> list = us.selUserInfo();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testt() {
		SqlSession session = MyBatisUtil.getSqlsession();
		List<User> list = session.selectList("com.bjsxt.mapper.UserMapper.selUserInfo");
		for (User user : list) {
			System.out.println(user);
		}
	}
}

