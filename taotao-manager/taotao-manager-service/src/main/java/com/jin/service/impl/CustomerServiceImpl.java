package com.jin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.mapper.CustomerMapper;
import com.jin.pojo.Customer;
import com.jin.service.CustomerService;
/**
 * 用户Service的实现.
 * @version 2018/09/24 8:59:40
 * @author lenovo
 *
 */

@Service
public class CustomerServiceImpl implements CustomerService {
	private final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	private CustomerMapper customerMapper;
	public Customer findCustomerById(Integer id) {
		LOGGER.info("Controller层传递过来的id值为:----------------->{}",id);
		if(null == id){
			LOGGER.error("Controller层传递过来的id值有错误---------------->{}",id);
			System.exit(0);
		}
		return customerMapper.findCustomerById(id);
	}

	public List<Customer> findAllCustomer() {
		return customerMapper.findAllCustomer();
	}

}
