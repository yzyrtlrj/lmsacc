package com.accenture.aflac.lms.dao;

import com.accenture.aflac.lms.dao.entity.Admin;

public interface AdminDao<T> extends BaseDao<T>{

	Admin login(Admin admin);

}
