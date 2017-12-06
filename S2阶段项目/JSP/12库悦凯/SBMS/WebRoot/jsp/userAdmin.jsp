<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
}
</script>
</head><body>




<div class="menu">

<table>
<tbody><tr><td><form method="post" action="user.do">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input value="查 询" type="submit">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='jsp/userAdd.jsp'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>

    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
  </tr>
  
  <c:forEach items="${pageBeanU.data}" var="user">
  	<tr>
  		<td>${user.userId}</td>
  		<td>${user.userName}</td>
  		<td>${user.userSex}</td>
  		<td>${user.userAge}</td>
  		<td>${user.telephone}</td>
  		<td>${user.address}</td>
  		<td>${user.type}</td>
  		<td><a href="user?cmd=del&&userId=${user.userId}">删除</a></td>
  	</tr>
  </c:forEach>
</tbody></table>
</div>
<form id="form" action="user?cmd=getPageBeanU">
		<label class="input-button">跳转到</label>
    	<select name="p" onchange="getPageBeanByP();">
    		<c:forEach var="j" begin="1" end="${pageBeanU.getPagetotal()}">
    			<c:if test="${pageBeanU.getP() == j}">
    				<option selected="selected" value="${j}">第${j}页</option>
    			</c:if>
    			<c:if test="${pageBeanU.getP() != j}">
    				<option value="${j}">第${j}页</option>
    			</c:if>
    		</c:forEach>
    	</select>
    </form>
</div>
</body></html>
