package com.accenture.aflac.lms.common;

import com.accenture.aflac.lms.dao.vo.Pagination;

/**
 * 
 * @author weiqing.lai
 * 
 * 作用：计算分页信息的工具类
 *
 */
public class PaginationUtil {
	
	/**
	 * 计算之前：p已知currentPage、count、length
	 * 需要计算的数据：totalPage、offset
	 * 方法调用完成后，方法中的每个属性都应该有值
	 */
	public static void execute(Pagination p){
		int currentPage=p.getCurrentPage();
		int count=p.getCount();
		int length=p.getLength();
		
		int totalPage=(count+length-1)/length;
		int offset=(currentPage-1)*length;
		
		p.setOffset(offset);
		p.setTotalPage(totalPage);
		
	}

}
