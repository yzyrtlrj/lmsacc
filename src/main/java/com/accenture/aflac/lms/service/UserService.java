package com.accenture.aflac.lms.service;

import com.accenture.aflac.lms.entity.User;

public interface UserService {

	User login(User user);

	User findByBookIdAndBorrowStatus(Long id, String borrowStatus, String borrowStatus2);

	void update(User user);

}
