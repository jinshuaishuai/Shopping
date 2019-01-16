package com.jin.utils;

import java.io.Serializable;
import java.util.HashMap;
/**
 * 返回数据的封装
 * @author shuai.jin
 * @version 2018-08-17 10:25
 */
public class R extends HashMap<String, Object> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3105887962526555111L;

	public R() {
		super();
	}
	
	public static R ok(){
		return new R();
	}
	
	public R put(String key,Object value){
		super.put(key, value);
		return this;
	}
	
}
