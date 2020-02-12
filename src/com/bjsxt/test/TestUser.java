package com.bjsxt.test;

import org.junit.Test;

import com.bjsxt.bean.User;
import com.bjsxt.dao.UserDao;
import com.bjsxt.daoImpl.UserDaoImpl;
import com.bjsxt.serviceImpl.UserServiceImpl;

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
}

