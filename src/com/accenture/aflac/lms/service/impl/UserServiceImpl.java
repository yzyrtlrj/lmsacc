package com.accenture.aflac.lms.service.impl;

import java.util.List;

import com.accenture.aflac.lms.common.MD5Util;
import com.accenture.aflac.lms.common.PaginationUtil;
import com.accenture.aflac.lms.dao.UserDao;
import com.accenture.aflac.lms.dao.entity.Record;
import com.accenture.aflac.lms.dao.entity.User;
import com.accenture.aflac.lms.dao.vo.Pagination;
import com.accenture.aflac.lms.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public List<User> findAll(Pagination p) {
		// TODO Auto-generated method stub
		PaginationUtil.execute(p);
		return userDao.findAll(p.getOffset(), p.getLength());
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public int add(User entity) {
		// TODO Auto-generated method stub
		return userDao.add(entity);
	}

	@Override
	public int update(User entity) {
		// TODO Auto-generated method stub
		return userDao.update(entity);
	}

	@Override
	public int delete(User entity) {
		// TODO Auto-generated method stub
		//将数据的删除标志位置为1
		entity.setDeleteStatus(1);
		return userDao.delete(entity);
	}

	@Override
	public Boolean validateUserExist(String eid) {
		// TODO Auto-generated method stub
		String hql="from User user where user.eid=?";
		Object[] params={eid};
		List<User> users=(List<User>) userDao.findByHQL(hql, params);
		return (users==null)?false:true;
	}

	@Override
	public User validateUserLogin(User user) {
		// TODO Auto-generated method stub
		String hql="from User u where u.eid=?";
		Object[] params={user.getEid()};
		List<User> list=(List<User>) userDao.findByHQL(hql, params);
		if(list!=null && list.size()==1){
			if(list.get(0).getPassword().equals(MD5Util.encoderToMD5(user.getPassword()))){
			    return list.get(0);
			}
		}
		return null;
	}

	@Override
	public List<User> findIllegalUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByBookIndexNum(Record record) {
		// TODO Auto-generated method stub
		if(record==null || record.getBook()==null||record.getBook().getIndexNum()==null){
			return null;
		}
		String hql="from User user where user.id in"+
		"(select record.user.id from Record record where record.book.indexNum=?)";
		Object[] params={record.getBook().getIndexNum()};
		return (List<User>) userDao.findByHQL(hql, params);
	}

	@Override
	public int countRows() {
		// TODO Auto-generated method stub
		return userDao.countRows();
	}

}
