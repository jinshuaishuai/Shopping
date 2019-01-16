package com.jin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author shuai.jin
 * @version 2018-08-16 19:47:30
 */

@Controller
public class BaseController {
	
	
	private Logger logger = LoggerFactory.getLogger(BaseController.class);
	@RequestMapping("index")
	public String toIndexPage(){
		
		logger.info("获取浏览器传递的访问参数:---------->{}","跳转商城主页面");
		
		return "index";
	}
}
