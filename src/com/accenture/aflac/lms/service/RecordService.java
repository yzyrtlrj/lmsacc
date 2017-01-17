package com.accenture.aflac.lms.service;

import java.util.List;

import com.accenture.aflac.lms.dao.entity.Record;
import com.accenture.aflac.lms.dao.vo.Pagination;

public interface RecordService {
	
    List<Record> findAll();
	
	List<Record> findAll(Pagination p);
	
	//根据主键查找
	Record findById(Long id);  

    int add(Record entity);
  
    int update(Record entity);
    
    int delete(Record entity);
    
    //普通用户
    List<Record> findByBook(Record entity,Pagination p);
    
    List<Record> findByUser(Record entity,Pagination p);
    
    //统计数据在数据库中的总行数
  	int countRows();
  	
    //限定条件下统计数据在数据库中的总行数
  	int countRows(Record entity);
  	
  	//2017.1.4 修正 jiaojiao.xiao
  	//根据图书索引号和记录表的状态查找记录
  	Record findRecordByBookNumAndBorrowStatus(Record record);

}
