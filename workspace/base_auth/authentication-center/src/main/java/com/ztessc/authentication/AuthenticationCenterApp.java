package com.ztessc.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.ztessc.base.util.redis.RedisCache;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationCenterApp {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationCenterApp.class, args);
	}

	/**
	 * 注入RedisCache工具类
	 * @return
	 */
	@Bean
	public RedisCache redisCache(){
		return new RedisCache();
	}
}
