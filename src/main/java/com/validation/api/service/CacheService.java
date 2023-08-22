package com.validation.api.service;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
	private final RedisTemplate<Object, Object> redisTemplate;

	public CacheService(RedisTemplate<Object, Object> redisTemplate) {
		super();
		this.redisTemplate = redisTemplate;
	}
	
	public void put(String key, Object value) {
		redisTemplate.opsForValue().set(key, value);
		redisTemplate.expire(key, 1,TimeUnit.HOURS); //set the data in cache for 1 hour
	}
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
}
