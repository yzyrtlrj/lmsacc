package com.accenture.aflac.lms.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.accenture.aflac.lms.dao.UserDao;
import com.accenture.aflac.lms.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
	//注入sessionFactory
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	//DAO层用户登录的方法
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql="from User where eid=? and password=?";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, user.getEid(),user.getPassword());
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	//DAO层根据书的ID和借阅状态为"阅读中"或"待归还"查询书籍当前拥有人
	@Override
	public User findByBookIdAndBorrowStatus(Long id, String borrowStatus, String borrowStatus2) {
		// TODO Auto-generated method stub
		String hql="select u from Record r join r.user u where r.book.id=? and (r.borrowStatus=? or r.borrowStatus=?)";
		List<User> list=(List<User>) this.getHibernateTemplate().find(hql, id,borrowStatus,borrowStatus2);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	

}
