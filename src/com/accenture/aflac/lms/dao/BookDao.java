package com.accenture.aflac.lms.dao;

import java.util.List;

import com.accenture.aflac.lms.dao.entity.Book;

public interface BookDao extends BaseDao<Book, String> {
	
	//带条件的分页查询，条件存储在book中，offset是从第几条记录开始，length是需要查询的数据条数
    List<Book> findAll(Book book,int offset,int length);

}
