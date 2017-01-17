package com.accenture.aflac.lms.dao;

import java.util.List;

import com.accenture.aflac.lms.dao.entity.Record;

public interface RecordDao extends BaseDao<Record,Long> {
  	
    //带条件的分页查询，条件存储在record中，offset是从第几条记录开始，length是需要查询的数据条数
  	List<Record> findAll(Record record,int offset,int length);
  	
    //在限定条件下数据在数据库中的总行数
  	int countRows(Record record);
  	
  	//2017.1.4 修正 jiaojiao.xiao
  	//根据图书索引号和记录表的状态查找记录
  	Record findRecordByBookNumAndBorrowStatus(Record record);
}
