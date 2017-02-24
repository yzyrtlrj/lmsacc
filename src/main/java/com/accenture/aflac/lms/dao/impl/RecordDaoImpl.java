package com.accenture.aflac.lms.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.aflac.lms.dao.BaseDao;
import com.accenture.aflac.lms.dao.RecordDao;
import com.accenture.aflac.lms.entity.Record;
import com.accenture.aflac.lms.util.PageHibernateCallback;
@Repository
public class RecordDaoImpl extends BaseDaoImpl<Record> implements RecordDao{
	
	//注入sessionFactory
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	//DAO层添加记录
	@Override
	public void save(Record record) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(record);
	}

	//DAO层根据userId统计记录数
	@Override
	public int countRowsByUserId(Long userId) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Record r where r.user.id=?";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql, userId);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//DAO层根据userId获得记录集合并分页
	@Override
	public List<Record> findByUserIdAndPage(Long userId, int begin, int limit) {
		// TODO Auto-generated method stub
		String hql="from Record r where r.user.id=?";
		List<Record> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Record>(hql, new Object[]{userId}, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	//DAO层根据bookId和borrowStatus查询记录
	@Override
	public Record findByBookIdAndBorrowStatus(Long id, String borrowStatus) {
		// TODO Auto-generated method stub
		String hql="from Record r where r.book.id=? and r.borrowStatus=?";
		List<Record> list=(List<Record>) this.getHibernateTemplate().find(hql, id,borrowStatus);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
