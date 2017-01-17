package com.accenture.aflac.lms.dao.vo;

public class Pagination {
	
	//当前页面
	private int currentPage=1;
	
	//总记录数
	private int count;
	
	//总页数
	private int totalPage;
	
	//页起始位置
	private int offset;
	
	//设置每页显示条数
	private int length=8;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	
	

}
