package com.jin.mapper;

import java.util.List;

import com.jin.pojo.Customer;

public interface CustomerMapper {
	
	/**
	 * 根据id查询一个用户对象
	 * @param id	Integer
	 * @return		一个Customer对象
	 */
	Customer findCustomerById(Integer id);
	
	/**
	 * 查询所有用户对象
	 * @return	返回一个List<Customer>对象
	 */
	List<Customer> findAllCustomer();
	
}
