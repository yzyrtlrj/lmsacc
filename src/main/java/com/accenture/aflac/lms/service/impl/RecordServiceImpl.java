package com.accenture.aflac.lms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.aflac.lms.dao.RecordDao;
import com.accenture.aflac.lms.dao.entity.Record;
import com.accenture.aflac.lms.service.RecordService;
import com.accenture.aflac.lms.util.PageBean;
@Service
@Transactional
public class RecordServiceImpl implements RecordService{
	//注入RecordDao
	@Autowired
	private RecordDao recordDao;

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	@Override
	public void save(Record record) {
		// TODO Auto-generated method stub
		//记录借书时间
		record.setBorrowDate(new Date());
		//书籍归还最后期限
		record.setEffectiveDate(new Date(new Date().getTime()+1000*60*60*24*30));
		//将书籍的借阅状态设置为待取书: 1.申请借阅中(待取书)，2.阅读中，3.阅读完（待归还）4.已归还
		record.setBorrowStatus("申请借阅中");
		//设置记录的创建人
		record.setCreateUser(record.getUser().getEid());
		//设置记录的创建时间
		record.setCreateTime(new Date());
		record.setDeleteStatus(0);
		recordDao.save(record);
	}

	@Override
	public PageBean<Record> findByUserIdAndPage(Long userId, int page) {
		// TODO Auto-generated method stub
		PageBean<Record> pageBean=new PageBean<>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每一页显示的记录数
		int limit=20;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=0;
		totalCount=recordDao.countRowsByUserId(userId);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		totalPage=(totalCount+limit-1)/limit;
		pageBean.setTotalPage(totalPage);
		//从哪开始
		int begin=(page-1)*limit;
		List<Record> list=recordDao.findByUserIdAndPage(userId,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	//业务层根据主键查询记录
	@Override
	public Record findById(Long id) {
		// TODO Auto-generated method stub
		return recordDao.findById(id);
	}

	//业务层修改记录的信息
	@Override
	public void update(Record record) {
		// TODO Auto-generated method stub
		recordDao.update(record);
	}

	//业务层根据bookId和borrowStatus查询记录
	@Override
	public Record findByBookIdAndBorrowStatus(Long id, String borrowStatus) {
		// TODO Auto-generated method stub
		return recordDao.findByBookIdAndBorrowStatus(id,borrowStatus);
	}
	
	

}
