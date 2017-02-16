<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list.css" />
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<title>Manage</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<SCRIPT type="text/javascript">
			 function stop(){
				return false;
			}
		</SCRIPT>
	</head>

	<body style="background-color: rgba(220, 220, 220, 0.2);">
		<h1 style="text-align: center;">Library Management System</h1>
		<hr />
		<div class="nav" style="margin-left:880px;">
			<a href="${pageContext.request.contextPath}/book_list.action?page=1" target="myFrame">圖書借閱</a>
			<s:if test="#session.userinfo.role=='admin'">
				<a href="user/showAllUsers.action?pagination.currentPage=1" target="myFrame">管理用戶</a>
				<a href="${pageContext.request.contextPath}/book_list.action?page=1" target="myFrame">管理圖書</a>
				<a href="record/RecordList?pagination.currentPage=1" target="myFrame">借閱管理</a>
			</s:if>
			<a href="${pageContext.request.contextPath}/record_personRecord.action?Page=1" target="myFrame">我的借阅记录</a>
			<a href="${pageContext.request.contextPath}/user_logout.action">注销</a>
		</div>
		<div style="margin:10px;">
			<iframe name="myFrame" width="100%" height="500px" scrolling="auto"
			frameborder="0" class="myFrame">

			</iframe>
		</div>
		
	</body>
</html>
