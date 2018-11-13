package com.ztessc.rbac.rbacshow.sys.mapper.impl;

import org.springframework.stereotype.Component;

import com.ztessc.base.entity.User;
import com.ztessc.rbac.rbacshow.sys.mapper.UserMapper;

/**
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserMapperImpl.java
 * @Package com.ztessc.rbac.rbacshow.sys.mapper
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月10日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public User userToBase(com.ztessc.rbac.rbacshow.sys.entity.User user) {
        if ( user == null ) {
            return null;
        }

        User userRtn = new User();

        userRtn.setId(user.getId());
        userRtn.setUserName(user.getUserName());
        userRtn.setRoles(user.getRoles());

        return userRtn;
	}

}
