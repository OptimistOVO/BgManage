项目名称:
	尚学堂后台管理系统
项目需求:
	实现用户登录
	实现用户退出
	实现用户注册
功能分析：
	用户登录:
		根据用户名和密码查询用户信息。查到则登录成功，查不到则登录失败。
	用户退出:
		销毁session
	用户注册:
		将用户注册信息插入数据库
数据库设计:
	用户表：user
		用户id id
		用户名    username
		用户密码 password
#		用户性别 sex
#		用户年龄 age
#		出生日期 birthday

SQL语句设计：
	用户登录
		select * from t_user where uname=? and pwd=?
	用户注册
		insert into t_user values(default,?,?,?,?,?)
代码实现：
	参照源码
-----------------------------------------------------
问题1：
	现在我们一个请求或者一个独立的业务逻辑都单独进行一个Servlet的创建进行请求处理。
	但是一个网站的功能是非常的多，如果每个都创建单独的Servlet进行处理，这样造成
	Servlet过多。造成资源浪费。
解决:
	服务器在接收到浏览器发送的请求后，会调用对应的Servlet进行请求处理。
	然后调用Servlet中的Service方法进行处理。
	我们将不同功能的处理封装成对应的方法。
	在service方法中调用其对应的功能处理方法进行请求处理。
	这样Servlet我们只需要一个。
新的问题：
	如何在service方法中实现根据请求动态的调用其功能处理方法呢？
解决:
	使用反射。		
注意：
	请求中需要附带要执行的方法名称。
----------------------------------------------------
问题2：
	现在使用反射我们实现了在service方法中动态的根据请求调用对应的方法进行请求处理。
	但是真实开发过程中，虽然不会每个功能都创建一个servlet，但是也不会只使用一个Servlet，我们的Servlet不只是一个，
	一般是一个独立的功能模块一个Servlet。我们需要在这些Servlet中的service方法中都要将反射代码声明一遍。
解决：
	向上抽取BaseServlet类
实现：
	我们自己的Servlet---->
			向上抽取父类BaseServlet(service)
				注意：我们希望BaseServlet不能被访问到(不能web.xml中配置BaseServlet)
					我们希望BaseServlet不能被实例化(改为抽象类)
					---->HttpServlet
BaseServlet使用:
	1、创建Servlet继承BaseServlet即可。
	2、在自己的servlet中不要声明service方法，只要书写请求处理功能方法即可。
	3、正常请求我们自己的servlet
	注意：
		请求必须附带要被执行的方法名
-----------------------------------------------
JSP+Servlet+MyBatis项目整合练习总结和期望:
总结：
	1、套用模版进行页面快速构建
		在自己的项目中创建jsp文件
		然后将模版中的前端相关代码赋值到自己的jsp文件中
		将静态资源复制到webRoot下
	2、MVC的开发流程
		M:model		   service dao pojo
		v:view		   jsp js css html
		c:controller   Servlet
	3、Servlet+jsp+MyBatis的功能开发流程
		1、浏览器发起页面请求直接给jsp
		2、浏览器发起功能请求给servlet，servlet调用service，service进行业务逻辑处理，
		   service调用dao，dao层进行数据库操作(Mybatis)，dao层将处理结果返回给service
		   service再将结果返回给servlet,(或者继续请求转发或者重定向其他Servlet继续处理) ,
		       请求转发或者重定向给jsp，jsp做出页面响应。
	4、request和session作用域的使用
		request：请求转发的数据流转的载体
		session：重定向的数据流转的载体(但是session可以解决同一个用户的不同请求的数据库共享问题)。
	5、浏览器发起请求到服务器请求发起的方式(重点记忆)
		非ajax请求
			form表单提交:action数据提交地址，method：数据提交方式
			超链接标签：href：为数据提交地址，可以直接使用？拼接请求数据，类似form表单的get请求方式。
			js中的window.location.herf：为数据提交地址，可以直接使用？拼接请求数据，类似form表单的get请求方式。
		注意：
			使用以上请求方式发起的请求，浏览器在接收到响应内容后，会将原有内容覆盖，显示响应结果。
	6、BaseServlet的抽取和使用
		反射
		抽象类
---------------------------------------------------------
项目缺陷：
	1、在jsp中获取从Servlet流转过来的数据特别麻烦
	2、在jsp页面中使用java代码块进行逻辑处理书写和阅读极不方便
	3、使用session进行数据流转是很方便的，但是session失效了，所有依赖session的功能都会出问题。
	4、响应结果都是覆盖原有内容显示给用户


















