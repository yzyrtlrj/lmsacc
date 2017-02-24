package com.accenture.aflac.lms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.aflac.lms.dao.BookDao;
import com.accenture.aflac.lms.entity.Book;
import com.accenture.aflac.lms.service.BookService;
import com.accenture.aflac.lms.util.PageBean;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	//注入BookDao
	@Autowired
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	//业务层查询图书列表带有分页
	@Override
	public PageBean<Book> findByPage(int page) {
		// TODO Auto-generated method stub
		PageBean<Book> pageBean=new PageBean<>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit=20;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=0;
		totalCount=bookDao.countRows();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		totalPage=(totalCount+limit-1)/limit;
		pageBean.setTotalPage(totalPage);
		//从哪开始
		int begin=(page-1)*limit;
		List<Book> list=bookDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层根据主键查询书籍
	@Override
	public Book findById(Long id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id);
	}

	//业务层修改图书信息的方法
	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
	}

	//业务层查询所有图书分类的方法
	@Override
	public List<String> findAllCategory() {
		// TODO Auto-generated method stub
		return bookDao.findAllCategory();
	}

	@Override
	public PageBean<Book> findByConditions(Book book,int page) {
		// TODO Auto-generated method stub
		PageBean<Book> pageBean=new PageBean<>();   //设置当前页数
		pageBean.setPage(page);   //设置每一页显示的记录数
		pageBean.setLimit(20);    //设置总记录数--20
		int totalCount=0;
		totalCount=bookDao.countBooksByConditionSearch(book);        //?????
		pageBean.setTotalCount(totalCount);    //设置总页数
		
		int totalPage=0;
		totalPage=(totalCount+pageBean.getLimit()-1)/pageBean.getLimit();
		pageBean.setTotalPage(totalPage);    //从哪开始
		
		int begin=(page-1)*pageBean.getLimit();
		List<Book> bookList=bookDao.findByConditions(book, begin, pageBean.getLimit());
		pageBean.setList(bookList);
		return pageBean;
	}
	
	

	
	

}
