package com.jin.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jin.util.RedisUtil;

public class RedisTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		
		RedisUtil redisUtil = (RedisUtil) ac.getBean("redisUtil");
		redisUtil.set("haha", "hello");
	}
}
