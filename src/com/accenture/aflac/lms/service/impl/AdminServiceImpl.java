package com.accenture.aflac.lms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.aflac.lms.dao.AdminDao;
import com.accenture.aflac.lms.dao.entity.Admin;
import com.accenture.aflac.lms.service.AdminService;
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	//注入AdminDao
	@Autowired
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	//业务层管理员登录的方法
	@Override
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.login(admin);
	}
	
	
}
