package com.accenture.aflac.lms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 作用：用来存储于书籍的信息，与数据库中的用户表（lms_book）相对应
 */
public class Book extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	//定义图书的索引号
	private String indexNum;
    //定义图书的名字
    private String bookName;
    //定义图书的isbn编号
    private String isbn; 
    //定义书籍的分类
    private String categoryName;
    //记录书籍是否可借，0即可借，1为不可借
    private String bookStatus;
    //图书的作者
    private String author;  
    //定义图书的价格 
    private Double price;               
    //图书的出版社
    private String press;                            
    //书籍图片的存放路径
    private String bookPicturePath; 
    //图书内容简介
    private String summary;             
    //书籍的出版日期
    private Date publishDate;
    
	public String getIndexNum() {
		return indexNum;
	}
	public void setIndexNum(String indexNum) {
		this.indexNum = indexNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getcategoryName() {
		return categoryName;
	}
	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getBookPicturePath() {
		return bookPicturePath;
	}
	public void setBookPicturePath(String bookPicturePath) {
		this.bookPicturePath = bookPicturePath;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
    
    

}
