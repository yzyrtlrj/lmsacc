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
	<link rel="stylesheet" href="./css/common.css" />
	<link rel="stylesheet" href="./css/login.css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<title>userLogin</title>
	<script type="text/javascript">
	    function clean() {
			document.getElementById("password").value="";
			document.getElementById("username").value="";
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
								<td>
									<s:textfield id="username" name="eid" label="用户名" />		
								</td>
								<td>
									<s:password id="password" name="password" label="密 码" />
								</td>	
							</tr>
							<tr>
								<td colspan="2">
									<input type="submit" value="Login" class="btu"/>
									<input type="button" value="Reset" class="btu_reset" onclick="clean()"/>
								</td>
							</tr>
							<tr>
								<td colspan="2"><a href="#">忘记密码</a></td>
							</tr>
						</table>
					</form>
			</div>
		<div id="footer"></div>
	</div>
</body>
</html>