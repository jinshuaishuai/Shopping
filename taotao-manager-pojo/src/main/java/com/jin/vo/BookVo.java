package com.jin.vo;

import java.io.Serializable;

public class BookVo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3228220121701491274L;
	private Integer bookId;			//根据书的id进行查询
	private String bookName;		//根据书名进行查询
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
	
	
	
}
