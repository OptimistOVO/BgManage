package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.bean.User;
import com.bjsxt.service.UserService;
import com.bjsxt.serviceImpl.UserServiceImpl;


@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
    
	
	/**
     * @throws IOException 
        * 
        * @Title: userLogin   
        * @Description:用户登录servlet
        * @param req
        * @param resp void      
        * @throws
        */
    public void userLogin(HttpServletRequest req,HttpServletResponse resp) throws IOException {
    	//获取请求信息
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	//处理请求信息
    	User u = new User();
    	u.setPassword(password);
    	u.setUsername(username);
    	System.out.println("UServlet---"+u);
    	
    	//创建service层对象
    	UserService us = new UserServiceImpl();
    	boolean check = us.checkLogin(u);
    	//创建session存放信息
    	HttpSession session = req.getSession();
    	if(check == true) {
    		session.setAttribute("username", username);
    		resp.sendRedirect("index.jsp");
    	}else {
    		session.setAttribute("flag", "LoginFalse");
    		resp.sendRedirect("login.jsp");
    	}
    	
    }
    
    /**
     * 
     * @Title: userOut   
     * @Description: 退出系统获取session并销毁
     * @param req
     * @param resp
     * @throws IOException void      
     * @throws
     */
    public void userOut(HttpServletRequest req,HttpServletResponse resp) throws IOException {
    	//获取session
    	HttpSession session = req.getSession();
    	//销毁session
    	session.invalidate();
    	//重定向到登录页面
    	resp.sendRedirect("login.jsp");
    }
    
    /**
     * 
     * @Title: userReg   
     * @Description:用户注册
     * @param req
     * @param resp
     * @throws IOException void      
     * @throws
     */
    public void userReg(HttpServletRequest req,HttpServletResponse resp) throws IOException {
    	//获取请求信息
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
    	String sex = req.getParameter("sex");
    	int age = Integer.parseInt(req.getParameter("age"));
    	String birthday = req.getParameter("birthday");
    	//包装信息
    	User u = new User();
    	u.setPassword(password);
    	u.setUsername(username);
    	u.setSex(sex);
    	u.setAge(age);
    	u.setBirthday(birthday);
    	//创建service层对象
    	UserService us = new UserServiceImpl();
    	boolean check = us.regUser(u);
    	HttpSession session = req.getSession();
    	if(check == true) {
    		session.setAttribute("flag", "regSuccess");
    		resp.sendRedirect("login.jsp");
    	}else {
    		session.setAttribute("flag", "regFaild");
    		resp.sendRedirect("register.jsp");
    	}
    }
    
    /**
     * @throws ServletException 
     * 
     * @Title: selUserInfo   
     * @Description: 显示所有用户信息到UserList.jsp
     * @param req
     * @param resp
     * @throws IOException void      
     * @throws
     */
    public void selUserInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
    	resp.getWriter().write("123");
    	
    	//创建service层对象
    	UserService us = new UserServiceImpl();
    	List<User> list = us.selUserInfo();
    	//处理结果
    	req.setAttribute("list", list);
    	//请求转发到userList.jsp  把req里的东西都发过去
    	req.getRequestDispatcher("userList.jsp").forward(req, resp);
    	return;
    }
}
