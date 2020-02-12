package com.bjsxt.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 作为Base类，不应该在浏览器中被访问，所以不能在xml中配置
 *同样不应该被实例化，所以 变成抽象类
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//设置请求编码格式
    	req.setCharacterEncoding("utf-8");
    	//设置响应编码格式
    	resp.setContentType("text/html;charset=utf-8");
    	//接收请求信息
    	String methodName = req.getParameter("method");
    	System.out.println("methodName"+methodName);
    	//调用方法处理请求-->反射
    	try {
    		//反射获得方法所在类的类对象 this是子类的 子类执行父类方法
        	Class clazz = this.getClass();
        	//反射获取要被调用的方法对象
			Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			//执行方法
			method.invoke(this, req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
    	}
}
