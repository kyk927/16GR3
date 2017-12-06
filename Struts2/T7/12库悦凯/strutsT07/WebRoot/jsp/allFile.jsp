<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allFile.jsp' starting page</title>
    
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
    用户名:${userName}<br/>
    文件类型:${uploadfileContentType}<br/>
    文件名：${uploadfileFileName}<br/>
    下载一：<a href="/strutsT07/upload/${uploadfileFileName}">
    ${uploadfileFileName}
    </a>
    <br/>
    下载二：<a href="/strutsT07/upload/file!download?downfile_name=${uploadfileFileName}">
    ${uploadfileFileName}
    </a>&nbsp;&nbsp;&nbsp;此下载不识别中文请谨慎选择
  </body>
</html>
