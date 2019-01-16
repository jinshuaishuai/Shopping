package com.jin.service;

import java.util.List;
import java.util.Map;

import com.jin.pojo.Book;
import com.jin.util.Page;

/**
 * 书的接口
 * @version	2018-08-14 11:15:30
 * @author shuai.jin
 *
 */
public interface BookService {
	
	/**
	 * 根据图书id查询一本书
	 * @param id
	 * @return
	 */
	public Book selectBookById(Integer id);
	/**
	 * 按查询条件查询图书信息,并伴随着分页
	 * @param bookVo	封装了查询条件的VO对象.
	 * @param pageNum	当前页
	 * @param pageSize	每页显示的数据条数.
	 * @return			返回一个BookPage类型的pojo
	 */
//	public BookPage selectBookByBookVoWithPage(BookVo bookVo, int pageNum, int pageSize);
	/**
	 * 方法的重载:方法名相同,参数类型不一致,参数个数不一致.与方法的返回值无关
	 * @param page
	 * @param params
	 * @return
	 */
	public Page<List<Book>> selectBookByBookVoWithPage(Page<List<Book>> page, Map<String, Object> params);
	/**
	 * 根据id修改图书信息，修改的图书信息进行保存
	 * @param book
	 */
	public void updateBookInfoById(Book book);
}
