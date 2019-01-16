package com.jin.service;

import java.util.List;

import com.jin.pojo.Customer;

public interface CustomerService {
	/**
	 * 根据id查询一个用户对象
	 * @param id
	 * @return
	 */
	public  Customer findCustomerById(Integer id);
	/**
	 * 查询所有用户对象
	 * @return	返回一个List<Customer>对象
	 */
	public List<Customer> findAllCustomer();
}
