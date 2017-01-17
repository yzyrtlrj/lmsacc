package com.accenture.aflac.lms.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.accenture.aflac.lms.dao.BaseDao;
import com.accenture.aflac.lms.dao.RecordDao;
import com.accenture.aflac.lms.dao.entity.Book;
import com.accenture.aflac.lms.dao.entity.Record;

public class RecordDaoImpl extends BaseDaoImpl<Record, Long> implements RecordDao{

	@Override
	public int countRows(Record record) {
		StringBuffer hql=new StringBuffer();
		hql.append("select count(*) from Record r");
		if(record!=null){
			hql.append(" where r.user.id="+record.getUser().getId());
		}
		List<Long> result=(List<Long>) this.getHibernateTemplate().find(hql.toString(), null);
		if(result!=null){
			return result.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Record> findAll(Record record, int offset, int length) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(clazz).add(Restrictions.eq( "deleteStatus", new Integer(0)));
		if(record!=null){
			if(record.getUser()!=null && record.getUser().getId()!=null){
				criteria.add(Restrictions.eq("user.id",record.getUser().getId()));
			}
			if(record.getBook()!=null && record.getBook().getIndexNum()!=null){
				criteria.add(Restrictions.eq("book.indexNum",record.getBook().getIndexNum()));
			}
		}
		return (List<Record>)this.getHibernateTemplate().findByCriteria(criteria, offset, length);

	}
	
	//2017.1.4 修正 jiaojiao.xiao
	@Override
	public Record findRecordByBookNumAndBorrowStatus(Record record) {
		// TODO Auto-generated method stub
		record = this.findById(record.getId());
		StringBuffer hql=new StringBuffer();
		hql.append("select r from Record r");
		if(record!=null){
			Object[] param = {"已读完"};
			hql.append(" where r.borrowStatus=?"+" and r.book.indexNum="+record.getBook().getIndexNum());
			List<Record> beforeRecord =(List<Record>) this.getHibernateTemplate().find(hql.toString(), param);
			if(beforeRecord!=null && beforeRecord.size()==1){
				return beforeRecord.get(0);
			}
		}	
		return null;
	}
	
	

}
