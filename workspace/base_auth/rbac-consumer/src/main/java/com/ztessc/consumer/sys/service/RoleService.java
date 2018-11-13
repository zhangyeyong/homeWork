package com.ztessc.consumer.sys.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ztessc.base.entity.QueryUserRole;
import com.ztessc.base.entity.UserRole;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.common.config.FullLogConfiguration;

@FeignClient(value="RBAC-PRODUCE",configuration = FullLogConfiguration.class,path = "/role")
public interface RoleService extends GenericService<UserRole, QueryUserRole> {

    @RequestMapping(value = "/loadRoleTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> loadRoleTree(UserRole entity);

}
