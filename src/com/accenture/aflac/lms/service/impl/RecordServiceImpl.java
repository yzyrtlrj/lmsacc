package com.accenture.aflac.lms.service.impl;

import java.util.List;

import com.accenture.aflac.lms.common.PaginationUtil;
import com.accenture.aflac.lms.dao.RecordDao;
import com.accenture.aflac.lms.dao.entity.Record;
import com.accenture.aflac.lms.dao.vo.Pagination;
import com.accenture.aflac.lms.service.RecordService;

public class RecordServiceImpl implements RecordService{
	
	private RecordDao recordDao;

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Override
	public List<Record> findAll() {
		// TODO Auto-generated method stub
		return recordDao.findAll();
	}

	@Override
	public List<Record> findAll(Pagination p) {
		// TODO Auto-generated method stub
		PaginationUtil.execute(p);
		return recordDao.findAll(p.getOffset(),p.getLength());
	}

	@Override
	public Record findById(Long id) {
		// TODO Auto-generated method stub
		return recordDao.findById(id);
	}

	@Override
	public int add(Record entity) {
		// TODO Auto-generated method stub
		return recordDao.add(entity);
	}

	@Override
	public int update(Record entity) {
		// TODO Auto-generated method stub
		return recordDao.update(entity);
	}

	@Override
	public int delete(Record entity) {
		// TODO Auto-generated method stub
		//将数据的删除标志位置为1
		entity.setDeleteStatus(1);
		return recordDao.delete(entity);
	}

	@Override
	public List<Record> findByBook(Record entity,Pagination pagination) {
		// TODO Auto-generated method stub
		return recordDao.findAll(entity, pagination.getOffset(), pagination.getLength());
	}

	@Override
	public List<Record> findByUser(Record entity,Pagination pagination) {
		// TODO Auto-generated method stub
		return recordDao.findAll(entity, pagination.getOffset(), pagination.getLength());
	}

	@Override
	public int countRows() {
		// TODO Auto-generated method stub
		return recordDao.countRows();
	}

	@Override
	public int countRows(Record entity) {
		// TODO Auto-generated method stub
		return recordDao.countRows(entity);
	}
	
	//2017.1.4 修正 jiaojiao.xiao
	@Override
	public Record findRecordByBookNumAndBorrowStatus(Record record) {
		// TODO Auto-generated method stub
		Record beforeRecord = recordDao.findRecordByBookNumAndBorrowStatus(record); 
		return beforeRecord;
	}

}
