package com.accenture.aflac.lms.service;

import java.util.List;

import com.accenture.aflac.lms.dao.entity.Book;
import com.accenture.aflac.lms.util.PageBean;

public interface BookService {

	PageBean<Book> findByPage(int page);

	Book findById(Long id);

	void update(Book book);

	List<String> findAllCategory();
	
	PageBean<Book> findByConditions(Book book,int page);


}
