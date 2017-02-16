<%@page import="org.apache.struts2.components.Include"%>
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
	<link rel="stylesheet" href="../resources/css/common.css" />
	<link rel="stylesheet" href="../resources/css/list.css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<title>bookList</title>
	<style type="text/css">
		body{
			background-image: url(./resources/images/bedge_grunge.png);
		    width:1300px;
		    height:100%;
		}
	</style>
</head>
<body>
	<div id="searchCondition">
		<form action="book/searchBook">
			<table >
				<tr>
					<td>根据书名进行查询<input type="text" name="book.bookName" /></td>
					<td>根据作者进行查询<input type="text" name="book.author" /></td>
					<td>根据分类进行查询 <select name="book.catagoryName">
							<option></option>
							<s:if test="#request.catagoryList!=null">
								<s:iterator value="#request.catagoryList" var="catagoryName">
									<option value="<s:property value="#catagoryName"/>"><s:property
											value="#catagoryName" /></option>
								</s:iterator>
							</s:if>
					</select>
					</td>
					<td>根据书籍索引号进行查询<input type="text" name="book.indexNum" /></td>
					<td><input type="submit" value="开始查询" class="search" /></td>
				</tr>
			</table>
		</form>
	</div>
	<h2 style="text-align: center;">图 书  信  息</h2>
	<div style="margin-left:1180px;">
		<a href="book/addBookInput">添加图书</a>
	</div>
	<table class="t2" border="1">
		<thead>
			<tr>
				<th>序号</th>
				<th>书籍索引号</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>出版日期</th>
				<th>书籍状态</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>
		<%int i = 1; %>
			<s:if test="#request.bookList!=null">
				<s:iterator value="#request.bookList" var="book">
					<tr>
						<td><%=i %></td>
						<td><s:property value="#book.indexNum" /></td>
						<td><s:property value="#book.bookName" /></td>
						<td><s:property value="#book.author" /></td>
						<td><s:property value="#book.press" /></td>
						<td><s:property value="#book.publishDate" /></td>
						<td><s:property value="#book.bookStatus" /></td>
						<td>
		                    <a 
		                    	href="book/bookDetail?book.indexNum=<s:property value='#book.indexNum'/>">详情
		                    </a>
                    
                		</td>
		                <td>
		                    <a 
		                    	href="book/updateBookInput?book.indexNum=<s:property value='#book.indexNum'/>">修改
		                    </a>
		                    
		                </td>
		                <td>
		                    <a 
		                    	href="book/deleteBook?book.indexNum=<s:property value='#book.indexNum'/>">删除
		                    </a>
		                    
		                </td>
					</tr>
					<%i++; %>
				</s:iterator>
			</s:if>
		</tbody>
	</table>
	
	<<!-- 分页 -->
	<div class="pagination">
    <s:if test="pageBean.page!=1">
        <a href="book_list.action?page=<s:property value='pageBean.page-1'/>">上一页</a>
    </s:if>
    <s:iterator var="i" begin="1" end="pageBean.totalPage">
       <a href="book_list.action?page=<s:property value='i'/>"><s:property value='i'/></a> 
    </s:iterator>
    <s:if test="pageBean.page!=pageBean.totalPage">
        <a href="book_list.action?page=<s:property value='pageBean.page+1'/>">下一页</a>  
    </s:if>
            当前页：<s:property value="pageBean.page"/>页/ <s:property value="pageBean.totalPage"/>页
	</div>
</body>
</html>