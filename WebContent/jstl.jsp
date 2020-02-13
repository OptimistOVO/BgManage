<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
  <div class="padding border-bottom">
    <button type="button" class="button border-yellow" onclick="window.location.href='#add'"><span class="icon-plus-square-o"></span> 添加用户</button>
  </div>
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">id</th>
      <th width="15%">用户名</th>
      <th width="10%">密码</th>
      <th width="10%">性别</th>
      <th width="10%">年龄</th>
      <th width="10%">出生日期</th>
      <th width="10%">操作</th>
    </tr>
<c:out value="${list}" default="null"></c:out>
<%-- <c:forEach items="${list}" var="u">
<tr>
      <td>${u.id}</td>
      <td>${u.username}</td>
      <td>${u.password}</td>
      <td>1</td>
      <td>产品分类</td>
      <td>1</td>
      <td><div class="button-group"> <a class="button border-main" href="cateedit.html"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
    </tr>
</c:forEach> --%>
    
  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){			
		
	}
}
</script>
</body>
</html>