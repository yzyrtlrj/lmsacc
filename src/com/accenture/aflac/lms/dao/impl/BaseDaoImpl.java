package com.accenture.aflac.lms.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.accenture.aflac.lms.dao.BaseDao;

public class BaseDaoImpl<E,K extends Serializable> extends HibernateDaoSupport  implements BaseDao<E,K>{
		
	protected Class<E> clazz;
	
	//实体名
	private String entityName;
	
	public BaseDaoImpl() {
		ParameterizedType parameterizedType=(ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz=(Class<E>)parameterizedType.getActualTypeArguments()[0];
		entityName=clazz.getSimpleName();
	}

	@Override
	public int add(E entity) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(entity);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int delete(E entity) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(entity);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int update(E entity) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(entity);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public E findById(K id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public List<E> findAll() {
		// TODO Auto-generated method stub
		return (List<E>) this.getHibernateTemplate().find("from "+entityName, null);
	}

	@Override
	public List<E> findAll(int offset, int length) {
		// TODO Auto-generated method stub
		return (List<E>)this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz).add(Restrictions.eq( "deleteStatus", new Integer(0) )), offset, length);
	}

	@Override
	public List<?> findByHQL(String hql, Object[] params) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql, params);
	}
	
	

	@Override
	public List<E> findBySQL(String sql) {
		// TODO Auto-generated method stub
		return this.getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
	}
	
	@Override
	public int countRows() {
		// TODO Auto-generated method stub
		String hql="select count(*) from "+entityName;
		List<Long> result=(List<Long>) this.getHibernateTemplate().find(hql, null);
		if(result!=null){
			return result.get(0).intValue();
		}
		return 0;
	}
	
}
