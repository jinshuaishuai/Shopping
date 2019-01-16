package com.jin.util;

import java.io.Serializable;

public class Page<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7817234702175564357L;
	//每页显示的记录条数,默认每页显示10条数据
	private Integer limit = 10;
	//当前页
	private Integer currentPage;
	//总页数
	private Long totalPages;
	//总的数据条数
	private Long totalRecords;
	//数据记录
	private E records;
	
	
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getCurrentPage() {
		this.currentPage = currentPage <= 1 ? 1 : currentPage;
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	public Long getTotalPages() {
		this.totalPages = this.totalRecords % limit == 0 ? 
				this.totalRecords / limit :(this.totalRecords / limit)+1;
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}
	public E getRecords() {
		return records;
	}
	public void setRecords(E records) {
		this.records = records;
	}
	
	
}
