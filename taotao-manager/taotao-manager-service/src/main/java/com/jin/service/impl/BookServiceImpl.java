package com.jin.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jin.mapper.BookMapper;
import com.jin.pojo.Book;
import com.jin.service.BookService;
import com.jin.util.Page;
/**
 * @version 2018-08-14 11:17:30
 * @author shuai.jin
 *
 */
@Service
public class BookServiceImpl implements BookService {
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	private BookMapper bookMapper;

	public Book selectBookById(Integer id) {
		return bookMapper.selectBookById(id);
	}

	public Page<List<Book>>  selectBookByBookVoWithPage(Page<List<Book>> page, Map<String, Object> params) {
		
		PageHelper.startPage(page.getCurrentPage(), page.getLimit());
		
		/*RedisTemplate redisTemplate = redisUtil.getRedisTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		List<Book> allBook = null;
		//先从redis缓存中取数据
		Object obj = redisTemplate.opsForValue().get("allBook");
		if(null == obj || obj.toString().equals("null")){	//说明Redis缓存中没有该数据.
			synchronized (this) {
				obj = redisTemplate.opsForValue().get("allBook");
				if(null == obj || obj.toString().equals("null")){
					//如果redis缓存中没有该数据，则从数据库中查询
					allBook = bookMapper.selectBookByBookVoWithPage(params);
					
					//将List<POJO>转换为JSON格式的字符串.
					try {
						String str = objectMapper.writeValueAsString(allBook);
						//将该数据放回redis缓存中
						redisTemplate.opsForValue().set("allBook", str);
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
				}else{
					//将JSON格式的字符串转换为List<POJO>
					try {
						allBook = objectMapper.readValue(obj.toString(), new TypeReference<List<Book>>() {});
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			
			
		}else{
			//将JSON格式的字符串转换为List<POJO>
			try {
				allBook = objectMapper.readValue(obj.toString(), new TypeReference<List<Book>>() {});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		
		
		List<Book> allBook = bookMapper.selectBookByBookVoWithPage(params);
		PageInfo<Book> pageInfo = new PageInfo<Book>(allBook);
		
		page.setRecords(allBook);
		page.setCurrentPage(pageInfo.getPages());
		page.setTotalRecords(pageInfo.getTotal());
		return page;
	}

	@Transactional
	public void updateBookInfoById(Book book) {
		bookMapper.updateBookInfoById(book);
		/**
		 * 在业务层演示如果发生异常的话,配置的事务是否起作用,是会起作用的:
		 * 原因:在Spring的声明式配置事务的文件中,有个这样一段配置:
		 * <tx:method name="update*" propagation="REQUIRED"/>
		 * 这表明:以update开头的方法,都会有事务监控,只要异常出现在该方法中,都会有事务的回滚操作
		 * 
		 */
		int a = 0;
		a = 1 / 0;
		System.out.println(a);
	}
}
