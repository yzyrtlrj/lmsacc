package com.accenture.aflac.lms.dao;

import java.util.List;

import com.accenture.aflac.lms.entity.Record;

public interface RecordDao extends BaseDao<Record>{

	void save(Record record);

	int countRowsByUserId(Long userId);

	List<Record> findByUserIdAndPage(Long userId, int begin, int limit);

	Record findByBookIdAndBorrowStatus(Long id, String borrowStatus);

}
