package com.accenture.aflac.lms.dao;

import java.util.List;

import com.accenture.aflac.lms.entity.Book;

public interface BookDao extends BaseDao<Book>{

	int countRows();

	List<Book> findByPage(int begin, int limit);

	List<String> findAllCategory();

	

	


}
