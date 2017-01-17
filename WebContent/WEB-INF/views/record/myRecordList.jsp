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
	<title>reocrdList</title>
	<style type="text/css">
	body{
			background-image: url(./resources/images/bedge_grunge.png);
		    width:1300px;
		    height:100%;
		}
	</style>
</head>
<!-- 2017.1.4 修正 jiaojiao.xiao -->
<body>
	<div class="nav"></div>
	<h2 style="text-align: center;">借 阅 记 录</h2>
	<table class="t2" border="1">
		<thead>
			<tr>
				<th>记录编号</th>
				<th>书籍索引</th>
				<th>书籍名稱</th>
				<th>借阅时间</th>
				<th>归还时间</th>
				<th>借阅截止日期</th>
				<th>借阅状态</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%int i = 1; %>
			<s:if test="#request.recordList!=null">
				<s:iterator value="#request.recordList" var="record">
					<tr>
						<td><%=i %></td>
						<td><s:property value="#record.book.indexNum"/></td>
						<td><s:property value="#record.book.bookName"/></td>
						<td><s:property value="#record.borrowDate"/></td>
						<td><s:property value="#record.returnDate"/></td>
						<td><s:property value="#record.effectiveDate"/></td>
						<td><s:property value="#record.borrowStatus"/></td>
						<td>
							<s:if test="#record.borrowStatus=='申请借阅中'">
							 	 <a onclick="confirm('确认已经拿到书了吗？')" href="record/borrowSuccessConfirm?record.id=<s:property value='#record.id'/>">
									已借阅
								 </a>
							</s:if>
							<s:if test="#record.borrowStatus=='阅读中'">
								<a href="record/returnBook?record.id=<s:property value='#record.id'/>">
									已读完
								</a>		
							</s:if> 
							<s:if test="#record.borrowStatus=='已读完'">
									已读完	
							</s:if> 
						</td>
					</tr>
					<%i++; %>
				</s:iterator>
			</s:if>
		</tbody>
	</table>
	
	<!-- 分页 -->
	<div class="pagination">
	<s:if test="#session.userinfo.role=='admin'">
	    <s:if test="pagination.currentPage!=1">
	        <a href="record/RecordList?pagination.currentPage=<s:property value='pagination.currentPage-1'/>">上一页</a>
	    </s:if>
	    <s:iterator var="i" begin="1" end="pagination.totalPage">
            <a href="record/RecordList?pagination.currentPage=<s:property value='i'/>"><s:property value='i'/></a>
        </s:iterator>
	    <s:if test="pagination.currentPage!=pagination.totalPage">
	        <a href="record/RecordList?pagination.currentPage=<s:property value='pagination.currentPage+1'/>">下一页</a>  
	    </s:if>
    </s:if>
    
    <s:if test="#session.userinfo.role=='normal'">
	    <s:if test="pagination.currentPage!=1">
	        <a href="record/personalRecordList?pagination.currentPage=<s:property value='pagination.currentPage-1'/>">上一页</a>
	    </s:if>
	    <s:iterator var="i" begin="1" end="pagination.totalPage">
           	 第 <a href="record/personalRecordList?pagination.currentPage=<s:property value='i'/>"><s:property value='i'/></a> 页
        </s:iterator>
        <s:if test="pagination.currentPage!=pagination.totalPage">
	        <a href="record/personalRecordList?pagination.currentPage=<s:property value='pagination.currentPage+1'/>">下一页</a>  
	    </s:if>
	    
    </s:if>
       	 当前页：<s:property value="pagination.currentPage"/>页 / <s:property value="pagination.totalPage"/>页
	</div>
</body>
</html>