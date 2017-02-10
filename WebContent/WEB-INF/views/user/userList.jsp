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
<link rel="stylesheet" href="../resources/css/common.css" />
<link rel="stylesheet" href="../resources/css/list.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>userList</title>
<style type="text/css">
	body{
		background-image: url(./resources/images/bedge_grunge.png);
	    width:1300px;
	    height:100%;
	}
</style>
</head>
<body>
	<div id="searchCondition" style="margin-left:880px;">
		<form action="">
			按圖書檢索號查找用戶：<input type="text" value="圖書檢索號"></input>
			<input type="submit" value="搜索"></input>
		</form>
	</div>
	<h2 style="text-align: center;">用 户 信 息</h2>
	<div style="margin-left: 1190px; ">
		<a href="user/addUserInput">添加用戶</a>
	</div>
	<table class="t2" border="1">
        <thead>
            <tr>
            	<th>NO</th>
	            <th>EID</th>
	            <th>TEL</th>
	            <th>項目名</th> 
	            <th>最多可借本数</th>         
	            <th ></th>
	            <th ></th>
	            <th ></th>
            </tr>
        </thead>
        <tbody>
        <s:iterator value="#request.userList" var="user">
            <tr>
                <td><s:property value="#user.id"/></td>
                <td><s:property value="#user.eid"/></td>
                <td><s:property value="#user.tel"/></td>
                <td><s:property value="#user.projectName"/></td>
                <td><s:property value="#user.borrowCountLimit"/></td>
                <td>
                    <a 
                    	href="user/userDetail?user.id=<s:property value='#user.id'/>">查看详情
                    </a>
                 </td>
                 <td>
                	<a 
                		href="user/updateUserInput?user.id=<s:property value='#user.id'/>">修改
                	</a>
                </td>
                 <td>
                	<a 
                		href="user/deleteUser?user.id=<s:property value='#user.id'/>">删除
                	</a>
                </td>
            </tr>  
        </s:iterator>
        </tbody>
    </table>
    
    <!-- 分页 -->
    <div class="pagination">
    <s:if test="pagination.currentPage!=1">
		<a href="user/showAllUsers?pagination.currentPage=<s:property value='pagination.currentPage-1'/>">上一页</a>
    </s:if>
    <s:iterator var="i" begin="1" end="pagination.totalPage">
         <a href="user/showAllUsers?pagination.currentPage=<s:property value='i'/>"><s:property value='i'/></a> 
    </s:iterator>
    <s:if test="pagination.currentPage!=pagination.totalPage">
        <a href="user/showAllUsers?pagination.currentPage=<s:property value='pagination.currentPage+1'/>">下一页</a>  
    </s:if>
           当前页：<s:property value="pagination.currentPage"/>页 / <s:property value="pagination.totalPage"/>页
    </div>
    <hr/>
    
   	<a href="user/showAllUsers?pagination.currentPage=1">1</a>
   	<s:if test="pagination.currentPage>2">...</s:if>
   	<s:iterator var="i" begin="pagination.currentPage" end="pagination.currentPage+2">
   	    <s:if test="#i>1 && #i<pagination.totalPage-1">
	        <a href="user/showAllUsers?pagination.currentPage=<s:property value='i'/>"><s:property value='i'/></a> 
	    </s:if>
   	</s:iterator>
   	<s:if test="pagination.totalPage>3 && pagination.totalPage-2>pagination.currentPage">...</s:if>
   	<a href="user/showAllUsers?pagination.currentPage=<s:property value='pagination.totalPage'/>"><s:property value="pagination.totalPage"/></a>   
    
</body>
</html>