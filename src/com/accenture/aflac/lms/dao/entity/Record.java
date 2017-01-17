package com.accenture.aflac.lms.dao.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * 作用：用来存储关于借阅记录的相关信息，与数据库中借阅记录表（lms_record）相对应
 *
 */
public class Record extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//主键
	private Long id;
	
	//记录书籍的借出日期
    private Date borrowDate;
    
    //记录书籍的归还日期
    private Date returnDate;
    
    //记录归还书籍的最后期限
    private Date effectiveDate;
    
    //借阅记录的状态，如申请借阅中，阅读中、阅读完、已归还
    private String borrowStatus;  
    
    //记录与记录是多对一，即一个用户可以对应多条借阅记录
    private User user;
    
    //记录与书籍是多对一，即一本书可以对应多条借阅记录
    private Book book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
