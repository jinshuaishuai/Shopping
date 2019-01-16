package com.jin.pojo;

import java.io.Serializable;

/**
 * 
 * @author shuai.jin
 * @version 2018/09/24 8:50:24
 *
 */
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8772805359545497375L;
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
