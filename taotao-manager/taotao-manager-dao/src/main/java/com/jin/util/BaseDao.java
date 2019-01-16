package com.jin.util;

public interface BaseDao<T> {
	/**
	 * 通过长整型主键进行查询.
	 * @param id
	 * @return
	 */
	public T findByLongId(Long id);
	public T findByStrId(String id);
	
}
