package com.bjsxt.daoImpl;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.bean.User;
import com.bjsxt.dao.UserDao;
import com.bjsxt.mapper.UserMapper;
import com.bjsxt.util.MyBatisUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkLogin(User u) {
		boolean flag = false;
		String username = u.getUsername();
		String password = u.getPassword();
		SqlSession session = MyBatisUtil.getSqlsession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selUserByName(username);
		if (user != null) {// 判断返回的user是否为null，，防止空指针异常
			if (user.getPassword().equals(password)) {
				flag = true;
			}
		}
		session.close();
		return flag;
	}
	
	/**
	 * 判断注册账号是否重复
	 */
	@Override
	public Boolean checkRepeat(User u) {
		String username = u.getUsername();
		System.out.println("daoimpl"+username);
		SqlSession session = MyBatisUtil.getSqlsession();
		//此处不用接口绑定，减少代码量
		User user = session.selectOne("com.bjsxt.mapper.UserMapper.selUserByName", username);
		if(user==null) {//该账号可以使用
			return true;
		}
		//该账号已被注册
		return false;
	}

	@Override
	public int regUser(User u) {

		SqlSession session = MyBatisUtil.getSqlsession();
		//获取UserMapper对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		//
		int i = mapper.regUser(u);
		if(i>0) {
			session.commit();
			return 1;
		}
		return -1;
	}

}
