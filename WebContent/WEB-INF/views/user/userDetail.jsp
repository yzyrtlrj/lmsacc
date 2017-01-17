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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>userList</title>
</head>
<body>
	<table border="1">
	    <tr>
	        <td>NO</td>
	        <td><s:property value="user.id"/></td>
	    </tr>
	    
	    <tr>
	        <td>姓名</td>
	        <td><s:property value="user.realName"/></td>
	    </tr>
	    
	    <tr>
	        <td>性別</td>
	        <td><s:property value="user.sex"/></td>
	    </tr>
	    
	    <tr>
	        <td>EID</td>
	        <td><s:property value="user.eid"/></td>
	    </tr>
	    
	    <tr>
	        <td>TEL</td>
	        <td><s:property value="user.tel"/></td>
	    </tr>
	    
	    <tr>
	        <td>項目名</td>
	        <td><s:property value="user.projectName"/></td>
	    </tr>
	    
	    <tr>
	        <td>最大可借本数</td>
	        <td><s:property value="user.borrowCountLimit"/></td>
	    </tr>
       
    </table>
</body>
</html>