package com.ztessc.consumer.sys.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ztessc.base.entity.OrgGroup;
import com.ztessc.base.entity.QueryOrgGroup;
import com.ztessc.base.entity.QueryUser;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.common.config.FullLogConfiguration;

@FeignClient(value="RBAC-PRODUCE",configuration = FullLogConfiguration.class,path = "/group")
public interface OrgGroupService  extends GenericService<OrgGroup, QueryOrgGroup> {

    /**
     * 功能描述：获取组织架构底下的相应的用户
     * @return
     */
    @RequestMapping(value = "/userList",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> userList(@RequestBody QueryUser user);

    /**
     * 功能描述：获取组织架构的整颗菜单树
     * @return
     */
    @RequestMapping(value = "/loadGroupTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> loadGroupTree();

}
