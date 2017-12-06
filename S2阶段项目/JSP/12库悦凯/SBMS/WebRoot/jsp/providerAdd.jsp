<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'providerAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>
	</div>
	<form id="form1" method="post" action="provider?cmd=addProvider" onsubmit="return checkit();">
		<div class="content">
		<font color="red"></font>
			<input name="flag" value="doAdd" type="hidden">
			<table class="box">

			<tbody><tr>
					<td class="field">供应商编号：</td>
					<td><input name="providerId" id="providerId" 
								class="text" type="text"> 
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="field">供应商名称：</td>
					<td><input name="providerName" id="providerName" 
								class="text" type="text"> 
						<font color="red">*</font>
					</td>

				</tr>
			<tr>
					<td class="field">供应商描述：</td>
					<td>
						<textarea name="providerDetail" id="providerDetail" 
								cols="45" rows="5"></textarea>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="field">供应商联系：</td>
					<td><input name="contact" id="contact" 
								class="text" type="text">
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="field">供应商电话：</td>
					<td><input name=telephone id="telephone" 
								class="text" type="text">
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td class="field">供应商地址：</td>
					<td><input name="address" id="address"
								class="text" type="text">
						<font color="red">*</font>
					</td>
				</tr>
			</tbody></table>
		</div>

		<div class="buttons">
			<input name="button" id="button" 
			value="提交" class="input-button" type="submit" onclick="checkForm();"> 
			<input name="button" id="button" 
			onclick="window.location='jsp/providerAdmin.jsp';" value="返回" class="input-button"> 
		</div>
	</form>
</div>
<script type="text/javascript">
	function checkForm(){
		var form1 = document.getElementById("form1");
		if(
			check("providerId")&&
			check("providerName")&&
			check("providerDetail")&&
			check("contact")&&
			check("telephone")&&
			check("address")
		){
			alert("信息填写完整，谢谢配合！");
		}else{
			alert("请填写完整的信息");
		}
	}
	function check(id){
		var aaa = document.getElementById(id).value;
		if(aaa != null && aaa != ""){
			return true;
		}else{
			return false;
		}
	}
</script>
</body>
</html>
