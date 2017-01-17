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
<title>Insert title here</title>
<style type="text/css">
/*img{width:109.8px;height:149.7px;}*/
img{width:113.7px;height:152.7px;}
body{
	background-image: url(./resources/images/bedge_grunge.png);
}

</style>
</head>
<body>
	<div style="margin-left: 200px;margin-top: 30px;font-weight: bold;">
		<div style="font-size: 12pt;float: left;">
		    <table style="text-align: right;line-height: 30px;">
		        <tr>
		            <td>书籍索引号:</td>
		            <td> <s:property value="book.indexNum"/></td>
		        </tr>
		        <tr>
		            <td>书名:</td>
		            <td> <s:property value="book.bookName"/></td>
		        </tr>
		        <tr>
		            <td>ISBN:</td>
		            <td> <s:property value="book.isbn"/></td>
		        </tr>
		        <tr>
		            <td>作者:</td>
		            <td> <s:property value="book.author"/></td>
		        </tr>
		        <tr>
		            <td>价格:</td>
		            <td> <s:property value="book.price"/></td>
		        </tr>
		        <tr>
		            <td>类别:</td>
		            <td> <s:property value="book.catagory.catagoryName"/></td>
		        </tr>
		        <tr>
		            <td>出版社:</td>
		            <td> <s:property value="book.press"/></td>
		        </tr>
		        <tr>
		            <td>图片:</td>
		            <td> <img alt="图片无法显示" src="resources/<s:property value='book.bookPicturePath'/>"></td>
		        </tr>
		        <tr>
		            <td>出版日期:</td>
		            <td> <s:property value="book.publishDate"/></td>
		        </tr>    
		        <tr>
		            <td>图书借阅人:</td>
		            
		        </tr>      
		    </table>
	    </div>
	    <div style="margin-left: 100px;float: left;width: 400px;height: 100%;">
	    	简介:<br>
	    	<p style="line-height: 30px;">&nbsp;&nbsp;<s:property value="book.summary"/></p> 
	    </div>
	</div>
</body>
</html>