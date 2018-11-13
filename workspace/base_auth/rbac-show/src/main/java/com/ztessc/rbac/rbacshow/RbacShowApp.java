package com.ztessc.rbac.rbacshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ztessc.base.util.redis.RedisCache;

@SpringBootApplication
public class RbacShowApp {

	public static void main(String[] args) {
		SpringApplication.run(RbacShowApp.class, args);
	}

	@Bean
	public RedisCache redisCache(){
		return new RedisCache();
	}
}
