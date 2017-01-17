<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../resources/css/list.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>userUpdate</title>
</head>
<body>
	<div style="margin-left: 500px;margin-top: 100px;">
		<form action="user/updateUser">
			<table style="text-align: right;">
			<tr>
				<td><s:textfield name="user.id" readonly="true" label="NO"/></td>
			</tr>
			<tr>
				<td> <s:textfield name="user.realName" readonly="true" label="姓名"/></td>
			</tr>
			<tr>
				<td> <s:textfield name="user.sex" readonly="true" label="性別" /></td>
			</tr>
			<tr>
				<td><s:textfield name="user.eid" readonly="true" label="EID" /></td>
			</tr>
			<tr>
				<td> <s:textfield name="user.tel" label="TEL"/></td>
			</tr>
			<tr>
				<td><s:textfield name="user.projectName" label="項目名"/></td>
			</tr>
			<tr>
				<td><s:textfield name="user.borrowCountLimit" label="最大可借本数"/></td>
			</tr>
			<tr>
				<td> <s:submit value="Update"/></td>
			</tr>
	       </table>
		</form>
	</div>
</body>
</html>