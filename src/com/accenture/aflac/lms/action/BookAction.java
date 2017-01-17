package com.accenture.aflac.lms.action;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.accenture.aflac.lms.common.PaginationUtil;
import com.accenture.aflac.lms.dao.entity.Book;
import com.accenture.aflac.lms.dao.entity.User;
import com.accenture.aflac.lms.dao.vo.Pagination;
import com.accenture.aflac.lms.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport implements SessionAware,RequestAware{
	
	private Map<String, Object> session;
	
	private Map<String, Object> request;
	
	private BookService bookService;
	
	private Book book;
	
	private Pagination pagination=new Pagination(); 
	
	private File uploadImage;// 得到上传的文件
	private String uploadImageContentType;// 得到文件的类型
	private String uploadImageFileName;// 得到文件的名称

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}

	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}

	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}


	public String bookList(){
		//从数据库中取出所有图书分类存在request域中，供页面按分类查询图书时使用
		List<String> catagoryList=bookService.findALLCatagory();
		request.put("catagoryList", catagoryList);
		pagination.setCount(bookService.countRows());
		PaginationUtil.execute(pagination);
		List<Book> bookList=bookService.findAll(pagination);
		request.put("bookList", bookList);
		return "bookList";
	}
	
	public String bookDetail(){
		book=bookService.findById(book.getIndexNum());
		return SUCCESS;
	}
	
	public String searchBook(){
		List<String> catagoryList=bookService.findALLCatagory();
		request.put("catagoryList", catagoryList);
		pagination.setCount(bookService.countRows());
		PaginationUtil.execute(pagination);
		List<Book> bookList=bookService.searchByCondition(book,pagination);
		request.put("bookList", bookList);
		return SUCCESS;
	}
	
	public String addBookInput(){
		return SUCCESS;
	}
	public String addBook(){
		String realpath = ServletActionContext.getServletContext().getRealPath("/resource/images");
		File file = new File(realpath);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			FileUtils
					.copyFile(uploadImage, new File(file, uploadImageFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 设置上传后文件的文件路径
		book.setBookPicturePath("/resource/images/" + uploadImageFileName);
		book.setCreateDate(new Date((new java.util.Date().getTime())));
		User user=(User) session.get("userinfo");
		book.setCreateUser(user.getEid());
		int i = bookService.add(book);
		if(i>0){
			
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	public String deleteBook(){
		book=bookService.findById(book.getIndexNum());
		int i = bookService.delete(book);
		if(i>0){
			
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	public String updateBookInput(){
		book=bookService.findById(book.getIndexNum());
		return SUCCESS;
	}
	
	public String updateBook(){
		int i = bookService.update(book);
		if(i>0){
			
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//2017.1.4 修正 jiaojiao.xiao
	public String updateBookStatus(){
		int i = bookService.update(book);
		if(i>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
