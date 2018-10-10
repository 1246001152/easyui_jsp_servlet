package com.grade.entity;

public class PageBean {
	
	private int pageIndex; // 页码
	private int pageCount; // 每页条数
	private int index; // 起始索引
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getIndex() {
		return (pageIndex-1)*pageCount;
	}
}
