package com.accenture.aflac.lms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 记录借阅数据的实体
 */
public class Record extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	//记录书籍的借出日期
    private Date borrowDate;
    //记录书籍的归还日期
    private Date returnDate;
    //记录归还书籍的最后期限
    private Date effectiveDate;
    //借阅记录的状态，1.申请借阅中(待取书)，2.阅读中，3.阅读完（待归还）4.已归还
    private String borrowStatus;
  //用户的续借状态，0.可续借，1.不可续借 
    private Integer renewStatus;          
    //书籍的借阅人
    private User user;
    //借阅的书籍
    private Book book;
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getBorrowStatus() {
		return borrowStatus;
	}
	public void setBorrowStatus(String borrowStatus) {
		this.borrowStatus = borrowStatus;
	}
	public Integer getRenewStatus() {
		return renewStatus;
	}
	public void setRenewStatus(Integer renewStatus) {
		this.renewStatus = renewStatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
    
    
}
