package com.accenture.aflac.lms.service;

import java.util.List;

import com.accenture.aflac.lms.dao.entity.Book;
import com.accenture.aflac.lms.dao.vo.Pagination;

public interface BookService {
	
    List<Book> findAll();
	
	List<Book> findAll(Pagination p);
	
	//根据主键查找
    Book findById(String id);  

    int add(Book entity);
  
    int update(Book entity);
    
    int delete(Book entity);
    
    //普通用户
    List<Book> findByCatagory(Book entity);
    
    List<Book> findByBookName(Book entity);
    
    List<String> findALLCatagory();
    
    List<Book> searchByCondition(Book entity,Pagination p);
    
    //统计数据在数据库中的总行数
  	int countRows();

}
