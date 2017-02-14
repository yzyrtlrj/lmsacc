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
		<form action="${pageContext.request.contextPath}/book_searchBook.action?page=1">
			<table>
				<tr>
					<td>根据书名进行查询<input type="text" name="bookName" /></td>
					<td>根据分类进行查询 <select name="categoryName">
							<option></option>
							<s:if test="#session.categoryList!=null">
								<s:iterator value="#session.categoryList" var="categoryName">
								    <!-- 下面这句默认选中即selected还没有经过测试，需要完成分页功能后再测试一次 -->
									<option value="<s:property value="#categoryName"/>" <s:if test="model.categoryName=#category">selected</s:if>>
										<s:property value="#categoryName"/>
									</option>
								</s:iterator>
							</s:if>
					</select>
					</td>
					<td>根据书籍索引号进行查询<input type="text" name="indexNum" /></td>
					<td><input type="submit" value="开始查询" class="search" /></td>
				</tr>
			</table>
		</form>
	</div>
	<h2 style="text-align: center;">图 书 信 息</h2>
	<table class="t2" border="1">
		<thead>
			<tr>
				<th>书籍索引号</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>出版日期</th>
				<th>书籍状态</th>
				<th colspan="2"></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator var="book" value="pageBean.list">
				<tr>
					<td><s:property value="#book.indexNum"/> </td>
					<td><s:property value="#book.bookName" /></td>
					<td><s:property value="#book.author" /></td>
					<td><s:property value="#book.press" /></td>
					<td><s:property value="#book.publishDate" /></td>
					<td><s:property value="#book.bookStatus" /></td>
					<td>
	                    <a 
	                    	href="${pageContext.request.contextPath}/book_detail.action?id=<s:property value='#book.id'/>">查看详情
	                    </a>
                   
               		</td>
               		<td>
                	<s:if test="#book.bookStatus=='可借'">
	                	<a 
	                		href="record_borrowBook.action?book.id=<s:property value='#book.id'/>">申请借阅
	                	</a>
                	</s:if>
                	<s:else>
                		<span style="color:red;">不可借</span>
                	</s:else>
               		</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	
	<!-- 分页 -->
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