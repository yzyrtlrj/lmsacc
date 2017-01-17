package com.accenture.aflac.lms.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.accenture.aflac.lms.common.PaginationUtil;
import com.accenture.aflac.lms.dao.entity.Book;
import com.accenture.aflac.lms.dao.entity.Record;
import com.accenture.aflac.lms.dao.entity.User;
import com.accenture.aflac.lms.dao.vo.Pagination;
import com.accenture.aflac.lms.service.BookService;
import com.accenture.aflac.lms.service.RecordService;
import com.opensymphony.xwork2.ActionSupport;

public class RecordAction extends ActionSupport implements SessionAware,RequestAware{
	
    private Map<String, Object> session;
	
	private Map<String, Object> request;
	
	private RecordService recordService;
	
	private BookService bookService;
	
	private Record record;
	
	private Pagination pagination=new Pagination();

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

	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}
	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	//クリック　→  "申请借阅"
	public String borrowBook(){
		//?????
		if(record.getBook()==null){
			return ERROR;
		}
		Book book=bookService.findById(record.getBook().getIndexNum());
		//将图书表中书的状态设置为"已借出"
		book.setBookStatus("已借出");
		record.setBook(book);
		record.setBorrowDate(new Date((new java.util.Date()).getTime()));
		//设置还书截止日期为当前时间加30天
		record.setEffectiveDate(new Date(new java.util.Date().getTime()-30*24*60*60*1000));
		//将记录表中书的状态设置为"申请借阅中"
		record.setBorrowStatus("申请借阅中");
		User user=(User) session.get("userinfo");
		record.setUser(user);
		//记录创建时间
		record.setCreateDate(new Date((new java.util.Date()).getTime()));
		//记录创建者
		record.setCreateUser(user.getEid());
		int i=recordService.add(record);
		if (i>0) {
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	//2017.1.4 修正 jiaojiao.xiao
	//修改当前借阅者记录和前一借阅者记录,クリック　→ "已借阅"
	public String borrowSuccessConfirm(){
		//修改前一借阅者记录表的借阅状态
		Record beforeRecord = recordService.findRecordByBookNumAndBorrowStatus(record);
		if(beforeRecord!=null){
			beforeRecord.setBorrowStatus("已归还");
			recordService.update(beforeRecord);
		}
		//修改当前借阅者记录
		record=recordService.findById(record.getId());			//!
		User user=(User) session.get("userinfo");
		record.setUser(user);
		Book book=bookService.findById(record.getBook().getIndexNum());
		record.setBook(book);
		//将记录表中书的状态设置为"阅读中"
		record.setBorrowStatus("阅读中");
		//记录更新的时间
		record.setUpdateDate(new Date((new java.util.Date()).getTime()));
		//记录更新者
		record.setUpdateUser(user.getEid());
		int i=recordService.update(record);
		if(i>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//クリック　→　"已读完"
	public String returnBook(){
		record=recordService.findById(record.getId());
		User user=(User) session.get("userinfo");
		record.setUser(user);
		Book book=bookService.findById(record.getBook().getIndexNum());
		//将图书表中书的状态设置为"可借"
		book.setBookStatus("可借");
		record.setBook(book);
		record.setBorrowStatus("已读完");
		//记录实际还书日期
		record.setReturnDate(new Date((new java.util.Date()).getTime()));
		//记录更新的时间
		record.setUpdateDate(new Date((new java.util.Date()).getTime()));
		//记录更新者
		record.setUpdateUser(user.getEid());
		int i=recordService.update(record);
		if(i>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	//个人借阅记录
	public String personalRecordList(){
		User user=(User) session.get("userinfo");
		record=new Record();
		record.setUser(user);
		pagination.setCount(recordService.countRows(record));
		PaginationUtil.execute(pagination);
		List<Record> recordList=recordService.findByUser(record, pagination);
		request.put("recordList", recordList);
		return SUCCESS;
	}
	
	//所有人的借阅记录
	public String RecordList(){
		pagination.setCount(recordService.countRows());
		PaginationUtil.execute(pagination);
		List<Record> recordList=recordService.findAll(pagination);
		request.put("recordList", recordList);
		return SUCCESS;
	}

}
