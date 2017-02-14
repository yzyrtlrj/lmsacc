package com.accenture.aflac.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.aflac.lms.dao.UserDao;
import com.accenture.aflac.lms.dao.entity.User;
import com.accenture.aflac.lms.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	//注入UserDao
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//业务层用户登录的方法
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	//业务层根据书的ID和借阅状态为"阅读中"或"待归还"查询书籍当前拥有人
	@Override
	public User findByBookIdAndBorrowStatus(Long id, String borrowStatus, String borrowStatus2) {
		// TODO Auto-generated method stub
		return userDao.findByBookIdAndBorrowStatus(id,borrowStatus,borrowStatus2);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
}
