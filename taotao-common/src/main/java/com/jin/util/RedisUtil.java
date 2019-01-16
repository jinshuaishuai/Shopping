package com.jin.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisUtil {
	private RedisTemplate<Object,Object> redisTemplate;

	public RedisTemplate<Object,Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<Object,Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public  void set(String key,Object value){
		ValueOperations opsForValue = redisTemplate.opsForValue();
		opsForValue.set(key, value);
		
	}
	
	public  Object get(String key){
		ValueOperations opsForValue = redisTemplate.opsForValue();
		return opsForValue.get(key);
	}
}
