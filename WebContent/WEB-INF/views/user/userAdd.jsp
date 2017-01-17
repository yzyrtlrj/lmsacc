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
	
	<form action="user/updateUser">
       
                     姓名&nbsp;&nbsp;&nbsp;
       <s:textfield name="user.realName"/><br/>
       
                     性別&nbsp;&nbsp;&nbsp;
       <s:textfield name="user.sex"/><br/>
       
       EID&nbsp;&nbsp;&nbsp;
       <s:textfield name="user.eid"/><br/>
       
       TEL&nbsp;&nbsp;&nbsp;
       <s:textfield name="user.tel"/><br/>
       
                    項目名&nbsp;&nbsp;&nbsp;
       <s:textfield name="user.projectName"/><br/>
       
                    最大可借本数&nbsp;&nbsp;&nbsp;
       <s:textfield name="user.borrowCountLimit"/><br/>
       
       <s:submit value="添加"/>
       
	</form>
</body>
</html>