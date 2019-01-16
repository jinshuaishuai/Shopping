package com.jin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jin.pojo.Book;
import com.jin.service.BookService;
import com.jin.util.Page;
import com.jin.utils.R;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	private Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping("/bookInfoUpdateById")
	@ResponseBody
	public String bookInfoUpdateById(Book book){
		logger.info("图书修改页面传递过来的页面信息为：-------------》",book);
		bookService.updateBookInfoById(book);
		return "true";
	}
	/**
	 * 根据id查询一本图书信息，然后跳转到修改图书信息页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/toUpdateBookInfoPage")
	public ModelAndView toUpdateBookInfoPage(String id){
		logger.info("表单传递过来的id值为：-------------》{}",id);
		ModelAndView mav = new ModelAndView();
		//调用根据id查询一本图书信息
		Book book = bookService.selectBookById(Integer.parseInt(id));
		mav.addObject("book", book);
		mav.setViewName("/bookInfo/bookInfoUpdatePage");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/queryBookList")
	public R queryBookList(@RequestParam Map<String,Object> params){
		logger.info("前台表单传递过来的数据为.......................:{}",params);
		int currentPage = params.get("page") == null ? 1 : Integer.parseInt((String)params.get("page"));
		int limit = params.get("limit") == null ? 10 : Integer.parseInt((String)params.get("limit"));
		
		Page<List<Book>> page = new Page<>();
		page.setCurrentPage(currentPage);
		page.setLimit(limit);
		
		Page<List<Book>> books = bookService.selectBookByBookVoWithPage(page,params);
		logger.info("总的记录条数为:{}",books.getTotalRecords());
		R r = R.ok().put("count",books.getTotalRecords()).put("data", books.getRecords()).put("code", 0);
		logger.info("返回到页面的r值为:r------>{}",r);
		return r;
	}
	/**
	 * 跳转到查询图书详情页面
	 * @return	返回一个页面视图
	 */
	@RequestMapping(value="/toQueryBookListPage")
	public String toQueryBookListPage(){
		return "queryBookList";
	}
	@RequestMapping("/findBookById/{bookId}")
	public Book findBookById(@PathVariable String bookId){
		Integer id = Integer.parseInt(bookId);
		
		Book book = bookService.selectBookById(id);
		return book;
		
	}
}
