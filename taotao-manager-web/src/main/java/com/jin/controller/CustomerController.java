package com.jin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jin.pojo.Customer;
import com.jin.service.CustomerService;

/**
 * @version 2018/09/24 9:22:23
 * @author lenovo
 *
 */

@Controller
public class CustomerController {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/findCustomerById/{id}")
	@ResponseBody
	public Customer findCustomerById(@PathVariable("id") String id){
		LOGGER.info("id的值为:-------------->{}",id);
		if(null == id){
			LOGGER.error("页面传递过来的id有错误-------------->{}",id);
			System.exit(0);
		}
		return customerService.findCustomerById(Integer.parseInt(id));
	}
}
