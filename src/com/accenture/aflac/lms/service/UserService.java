package com.accenture.aflac.lms.service;

import java.util.List;

import com.accenture.aflac.lms.dao.entity.Record;
import com.accenture.aflac.lms.dao.entity.User;
import com.accenture.aflac.lms.dao.vo.Pagination;

public interface UserService {
	
    List<User> findAll();
    
    List<User> findAll(Pagination p);
	
    //根据主键查找
    User findById(Long id);

	int add(User entity);

	int update(User entity);
    
	int delete(User entity);
	
	Boolean validateUserExist(String eid);
	
	User validateUserLogin(User user);
	
	//查找违规用户，并按照违规次数降序排列
	List<User> findIllegalUser();
	
	//按图书的索引号从relation表查找到当前拥有该书的用户
	List<User> findUserByBookIndexNum(Record record);
	
	//统计数据在数据库中的总行数
  	int countRows();

}
