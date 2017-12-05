<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jkl</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h2 align="center">success.jsp</h2>
    <s:form action="loginUser" method="post">
    	<s:textfield key="label.name" name="user.name"></s:textfield>
    	<s:password key="label.password" name="user.password"></s:password>
    	<s:submit key="label.Login"></s:submit>
    </s:form>
    <s:url id="localeenUS" namespace="/" action="local">
    	<s:param name="request_locale">en_US</s:param>
    </s:url>
    <s:url id="localezhCN" namespace="/" action= "local">
    	<s:param name="request_loacle">zh_CN</s:param>
    </s:url>
    <s:a href="%{localeenUS}">English</s:a>
    <s:a href="%{localezhCN}">中文</s:a>
  </body>
</html>
