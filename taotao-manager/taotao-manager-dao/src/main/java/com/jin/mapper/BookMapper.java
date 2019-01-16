package com.jin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jin.pojo.Book;

public interface BookMapper {
	/**
	 * 根据图书id查询图书
	 * @param id	图书编号
	 * @return		返回一个图书对象
	 */
	public Book selectBookById(Integer id);
	
	public List<Book> selectBookByBookVoWithPage(@Param("params") Map<String, Object> params);
	
	/**
	 * 保存修改后的图书信息
	 * @param book
	 */
	public void updateBookInfoById(Book book);
}
