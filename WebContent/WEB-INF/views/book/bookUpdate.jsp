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
img{width:109.8px;height:149.7px;}
</style>
</head>
<body>
    <form action="book/updateBook">
    
                    书籍索引号&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.indexNum" readonly="true"/><br/>
       
                    书名&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.bookName" readonly="true"/><br/>
       
       ISBN&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.isbn" readonly="true"/><br/>   
       
                     作者&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.author" readonly="true"/><br/>   
       
                    价格&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.price"/><br/>
       
                     类别&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.catagoryName" readonly="true"/><br/> 
       
                     出版社&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.press" readonly="true"/><br/> 
       
                     图片&nbsp;&nbsp;&nbsp;
       <img alt="图片无法显示" src="resources/<s:property value='book.bookPicturePath'/>"><br/>
       <s:textfield name="book.bookPicturePath" readonly="true" type="hidden"/><br/> 
       
                     简介&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.summary" readonly="true"/><br/> 
       
                     出版日期&nbsp;&nbsp;&nbsp;
       <s:textfield name="book.publishDate" readonly="true"/><br/> 
       
       <s:submit value="Update"/> 
                     
    </form>
    
      
   
</body>
</html>