package com.accenture.aflac.lms.service;

import com.accenture.aflac.lms.entity.Record;
import com.accenture.aflac.lms.util.PageBean;

public interface RecordService {

	void save(Record record);

	PageBean<Record> findByUserIdAndPage(Long userId, int page);

	Record findById(Long id);

	void update(Record record);

	Record findByBookIdAndBorrowStatus(Long id, String string);

}
