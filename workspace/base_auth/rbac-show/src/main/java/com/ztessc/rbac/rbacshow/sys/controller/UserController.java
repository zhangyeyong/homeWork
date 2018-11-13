package com.ztessc.rbac.rbacshow.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ztessc.base.entity.User;
import com.ztessc.rbac.rbacshow.common.base.GenericController;

/*
* 类描述：
* @auther linzf
* @create 2018/2/6 0006 
*/
@Controller
@RequestMapping("/user")
public class UserController extends GenericController<User> {
}
