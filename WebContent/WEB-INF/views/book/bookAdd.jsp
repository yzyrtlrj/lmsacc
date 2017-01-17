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
<link rel="stylesheet" type="text/css" href="resources/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="resources/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="resources/jquery-easyui/demo/demo.css">
<script type="text/javascript" src="resources/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="resources/jquery-easyui/jquery.easyui.min.js"></script>

</head>
<body>
    <form action="book/addBook" method="post" enctype="multipart/form-data">
        <table>
	        <tr>
	            <td><s:textfield name="book.indexNum" label="书籍索引号"/></td>
	        </tr>
	       
	        <tr>
	            <td><s:textfield name="book.bookName" label="书名"/></td>
	        </tr>
	      
	        <tr>
	            <td><s:textfield name="book.isbn" label="ISBN"/></td>
	        </tr>
	      
	        <tr>	            
	            <td><s:textfield name="book.author" label="作者"/></td>
	        </tr>
	        
	        <tr>	            
	            <td><s:textfield name="book.price" label="价格"/></td>
	        </tr>	         
	        <tr>
	         	 <td><s:textfield name="book.catagoryName" label="类别"/></td>
	        </tr>
	          
	        <tr>	            
	            <td><s:textfield name="book.press" label="出版社"/></td>
	        </tr>
	        <tr>            
	            <td><s:textfield name="book.bookStatus" label="书籍状态"/></td>
	        </tr>
	        <tr>            
	            <td><s:file name="uploadImage" label="上传图片" label=""/></td>
	        </tr>
	        <tr>            
	            <td><s:textfield name="book.remark" label=""/></td>
	        </tr>
	        <tr class="easyui-panel">          
	            <td><s:textfield name="book.publishDate" label="出版日期"/></td>
	        </tr>
	        <tr>   
	            <td><s:textfield name="book.summary" label="简介"/></td>
	        </tr>
	        <tr><td><s:submit value="添加"/></td></tr>
        </table>            
    </form>
    
      
   
</body>
</html>