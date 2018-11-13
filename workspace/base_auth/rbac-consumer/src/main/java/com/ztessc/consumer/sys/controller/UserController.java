package com.ztessc.consumer.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.QueryUser;
import com.ztessc.base.entity.User;
import com.ztessc.consumer.common.base.controller.GenericController;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.sys.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User,QueryUser> {

    @Autowired
    private UserService userService;

    @Override
    protected GenericService<User, QueryUser> getService() {
        return userService;
    }

     /**
     * 功能描述：更新用户状态为禁用/启用
     * @param entity
     * @return
     */
    @RequestMapping(value="/userControl",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> userControl(User entity){
        return userService.userControl(entity);
    }

    /**
     * 功能描述：加载所有的权限数据
     * @return
     */
    @RequestMapping(value = "/loadRoles",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> loadRoles(){
        return userService.loadRoles();
    }


}
