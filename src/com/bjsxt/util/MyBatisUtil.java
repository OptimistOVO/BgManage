package com.bjsxt.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory = null;
	static {
		try {
			factory =new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MyBatis.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlsession() {
		SqlSession session = null;
		if(factory!=null) {
			session = factory.openSession();
		}
		return session;
	}
}
