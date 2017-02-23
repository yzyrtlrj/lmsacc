package com.accenture.aflac.lms.dao;

import java.util.List;

import com.accenture.aflac.lms.dao.entity.Book;

public interface BookDao extends BaseDao<Book>{

	int countRows();
	
	int countBooksByConditionSearch(Book book);

	List<Book> findByPage(int begin, int limit);

	List<String> findAllCategory();

	List<Book> findByConditions(Book book,int begin, int limit);

	


}
