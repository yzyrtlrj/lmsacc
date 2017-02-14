<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="./resources/css/common.css" />
	<link rel="stylesheet" href="./resources/css/login.css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<title>userLogin</title>
<script type="text/javascript">
    function beforeLogin() {
		var role=document.getElementsById("role").value;
		alert(role);
	}
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Library Management System</h1>
			<hr />
		</div>
		<div id="main">
					<div class="main_nav"><h2>Login</h2></div>
					<form action="${pageContext.request.contextPath}/user_login.action" method="post">	
						<table align="center" border="0" style="border:1px solid #000000;">
							<tr>
								<td colspan="2">
									<s:textfield name="eid" label="用户名" />
									<s:password name="password" label="密 码" />
								</td>	
							</tr>
							<tr colspan="2">
							    <td>
							        <select name="role" id="role">
									    <option value="normal">普通用户</option>
									    <option value="admin">管理员</option>
									</select>
							    </td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="Login" class="btu" onclick="beforeLogin()"/>
									<s:reset value="Reset" style="width:70px;"/>
									
								</td>
							</tr>
							<tr>
								<td colspan="2"><a href="#">找回密码</a></td>
							</tr>
						</table>
					</form>
			</div>
		<div id="footer"></div>
	</div>
</body>
</html>