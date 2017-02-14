package com.accenture.aflac.lms.dao;

import com.accenture.aflac.lms.dao.entity.User;

public interface UserDao extends BaseDao<User>{

	User login(User user);

	User findByBookIdAndBorrowStatus(Long id, String borrowStatus, String borrowStatus2);

}
