package com.accenture.aflac.lms.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.accenture.aflac.lms.dao.BookDao;
import com.accenture.aflac.lms.dao.entity.Book;

public class BookDaoImpl extends BaseDaoImpl<Book, String> implements BookDao {

	@Override
	public List<Book> findAll(Book book, int offset, int length) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(clazz).add(Restrictions.eq( "deleteStatus", new Integer(0)));
		if(book.getBookName()!=""){
			criteria.add(Restrictions.eq("bookName",book.getBookName()));
		}
		if(book.getAuthor()!=""){
			criteria.add(Restrictions.eq("author",book.getAuthor()));
		}
		if(book.getCatagoryName()!=""){
			criteria.add(Restrictions.eq("catagoryName",book.getCatagoryName()));
		}
		if(book.getIndexNum()!=""){
			criteria.add(Restrictions.eq("indexNum",book.getIndexNum()));
		}
		return (List<Book>)this.getHibernateTemplate().findByCriteria(criteria, offset, length);

	}


}
