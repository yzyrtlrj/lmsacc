package com.accenture.aflac.lms.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.aflac.lms.dao.AdminDao;
import com.accenture.aflac.lms.dao.entity.Admin;
@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao<Admin>{

	//注入sessionFactory
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	//DAO层管理员登录的方法
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		String hql="from Admin where username=? and password=?";
		List<Admin> list=(List<Admin>) this.getHibernateTemplate().find(hql, admin.getUsername(),admin.getPassword());
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
}
