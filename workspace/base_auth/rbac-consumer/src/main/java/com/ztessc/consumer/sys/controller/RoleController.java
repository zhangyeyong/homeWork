package com.ztessc.consumer.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.QueryUserRole;
import com.ztessc.base.entity.UserRole;
import com.ztessc.consumer.common.base.controller.GenericController;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.sys.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<UserRole, QueryUserRole> {

    @Autowired
    private RoleService roleService;

    @Override
    protected GenericService<UserRole, QueryUserRole> getService() {
        return roleService;
    }

    @RequestMapping(value = "/loadRoleTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> loadRoleTree(UserRole entity){
        return roleService.loadRoleTree(entity);
    }
}
