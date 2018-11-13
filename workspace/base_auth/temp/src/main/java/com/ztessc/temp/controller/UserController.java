package com.ztessc.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.temp.dto.UserDto;
import com.ztessc.temp.mapper.UserDtoMapper;
import com.ztessc.temp.pojo.User;

/**
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserController.java
 * @Package com.ztessc.temp.controller
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月10日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@RestController("/user")
public class UserController {

	@Autowired
	private UserDtoMapper userDtoMapper;

	@PostMapping("/userDto")
	public void getUser(UserDto userDto) {
		//for test
		User user = userDtoMapper.dtoToUser(userDto);
		System.out.println(user);
	}

	@PostMapping("/user")
	public void getUserDto(User user) {
		UserDto userDto = userDtoMapper.userToDto(user);
		System.out.println(user);
		System.out.println(userDto);
	}

}
