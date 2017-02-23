package com.accenture.aflac.lms.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.accenture.aflac.lms.dao.entity.Book;
import com.accenture.aflac.lms.dao.entity.User;
import com.accenture.aflac.lms.service.BookService;
import com.accenture.aflac.lms.service.UserService;
import com.accenture.aflac.lms.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
@Scope("prototype")
public class BookAction extends ActionSupport implements ModelDriven<Book>{
	//模型驱动使用的对象
	private Book book=new Book();

	@Override
	public Book getModel() {
		// TODO Auto-generated method stub
		return book;
	}
	
	//注入BookService
	@Autowired
	private BookService bookService;
	
	//接收当前页数
	private int page;
	
	public void setPage(int page) {
		this.page = page;
	}
	
	//注入UserService
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//图书列表，带分页
	public String list(){
		//尝试从session中获得categoryList，除第一次要从数据库中查询外其他时候可从session中获取
		List<String> categoryList=(List<String>) ServletActionContext.
				getRequest().getSession().getAttribute("categoryList");
		if(categoryList==null){
			//查询所有书籍的分类，并存放到session中
		    categoryList=bookService.findAllCategory();
			ServletActionContext.getRequest().getSession().setAttribute("categoryList", categoryList);
		}
		PageBean<Book> pageBean=bookService.findByPage(page);
		//将pageBean存放到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		if("admin".equals(getUser().getRole())){
			return "manageBook";
		}
		return "bookList";
	}
	
	public String detail(){
		//根据主键查询书籍
		book=bookService.findById(book.getId());
		//根据书的ID和借阅状态为"阅读中"或"待归还"查询书籍当前拥有人
		User bookOwner=userService.findByBookIdAndBorrowStatus(book.getId(),"阅读中","待归还");
		//将书籍的拥有者封装到值栈中
		ActionContext.getContext().getValueStack().set("bookOwner", bookOwner);
		return "bookDetail";
	}
	
	private User getUser(){
		return (User)ServletActionContext.getRequest().getSession().getAttribute("userinfo");
	}
}
