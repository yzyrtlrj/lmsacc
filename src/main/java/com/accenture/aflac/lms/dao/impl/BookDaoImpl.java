package com.accenture.aflac.lms.dao.impl;

import com.accenture.aflac.lms.util.PageHibernateCallback;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.stereotype.Repository;
import com.accenture.aflac.lms.dao.BookDao;
import com.accenture.aflac.lms.entity.Book;
@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao{
	
	//注入sessionFactory
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	//统计总记录数
	@Override
	public int countRows() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Book";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	//DAO层查询图书列表带有分页
	@Override
	public List<Book> findByPage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql="from Book order by bookStatus desc";
		List<Book> list= this.getHibernateTemplate().execute(new PageHibernateCallback<Book>(hql, null, begin, limit));
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	//DAO层查询所有图书分类的方法
	@Override
	public List<String> findAllCategory() {
		// TODO Auto-generated method stub
		String hql="select distinct categoryName from Book";
		List<String> list=(List<String>) this.getHibernateTemplate().find(hql);
		if(list!=null && list.size()>0){
			return list;
		}
		return null;
	}

	

	

}
