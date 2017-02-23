package com.accenture.aflac.lms.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.accenture.aflac.lms.entity.Book;
import com.accenture.aflac.lms.entity.Record;
import com.accenture.aflac.lms.entity.User;
import com.accenture.aflac.lms.service.BookService;
import com.accenture.aflac.lms.service.RecordService;
import com.accenture.aflac.lms.service.UserService;
import com.accenture.aflac.lms.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class RecordAction extends ActionSupport implements ModelDriven<Record>{
	//模型驱动使用的对象
	private Record record=new Record();

	@Override
	public Record getModel() {
		// TODO Auto-generated method stub
		return record;
	}
	
	//注入RecordService
	@Autowired
	private RecordService recordService;
	
	public void setRecordService(RecordService recordService) {
		this.recordService = recordService;
	}
	
	//注入BookService
	@Autowired
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	//接收当前页数
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}

	//借阅图书
	public String borrowBook(){
		record.setUser(getUser());
		recordService.save(record);
		//将借阅书籍的状态修改为不可借
		Book book=bookService.findById(record.getBook().getId());
		book.setBookStatus("不可借");
		//记录更新数据时间
		book.setUpdateTime(new Date());
		//记录更新数据的人
		book.setUpdateUser(getUser().getEid());
		bookService.update(book);
		return "borrowBook";
	}
	
	//我的借阅记录
	public String personRecord(){
		Long userId=((User)ServletActionContext.getRequest().getSession().getAttribute("userinfo")).getId();
		PageBean<Record> pageBean=recordService.findByUserIdAndPage(userId,page);
		//将pageBean存放到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "personRecord";
	}
	
	//确认成功借书，此时将上一个借书人的记录状态变成"已读完"
	public String borrowSuccessConfirm(){
		//根据主键获得数据库中的那条记录
		record=recordService.findById(record.getId());
	    //将该条记录的状态改成"阅读中"
		record.setBorrowStatus("阅读中");
		//记录更新数据时间
		record.setUpdateTime(new Date());
		//记录更新数据的人
		record.setUpdateUser(getUser().getEid());
		//更新记录
		recordService.update(record);
		//根据bookId和记录状态为"待归还"查询上一个借书人
		record=recordService.findByBookIdAndBorrowStatus(record.getBook().getId(),"待归还");
		if(record!=null){
			//即上一个未确认归还图书的人存在
			//将该条记录的状态改成"已归还"
			record.setBorrowStatus("已归还");
			//记录更新数据时间
			record.setUpdateTime(new Date());
			//记录更新数据的人
			record.setUpdateUser(getUser().getEid());
			//更新记录
			recordService.update(record);
		}
		return "borrowSuccessConfirm";
	}
	
	//归还图书
	public String returnBook(){
		//根据主键获得数据库中的那条记录
		record=recordService.findById(record.getId());
	    //将该条记录的状态改成"待归还"
		record.setBorrowStatus("待归还");
		//记录书籍归还时间
		record.setReturnDate(new Date());
		//记录更新数据时间
		record.setUpdateTime(new Date());
		//记录更新数据的人
		record.setUpdateUser(getUser().getEid());
		//更新记录
		recordService.update(record);
		
		//将归还书籍的状态修改为可借
		Book book=bookService.findById(record.getBook().getId());
		book.setBookStatus("可借");
		//记录更新数据时间
		book.setUpdateTime(new Date());
		//记录更新数据的人
		book.setUpdateUser(getUser().getEid());
		bookService.update(book);
		return "returnBook";
	}
	
	//用户申请续借一次
	public String renew(){
		//根据主键获得数据库中的那条记录
		record=recordService.findById(record.getId());
		//将借阅记录的renewStatus值设置为1
		record.setRenewStatus(1);
		//将借阅记录中归还图书的日期往后延长一个周期
		record.setEffectiveDate(new Date(record.getEffectiveDate().getTime()+1000*60*60*24*30));
		//记录更新数据时间
		record.setUpdateTime(new Date());
		//记录更新数据的人
		record.setUpdateUser(getUser().getEid());
		recordService.update(record);
		return "renew";
	}
	
	//从session中获取当前用户
	private User getUser(){
		return (User)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
	}
	
	

}
