package com.ztessc.consumer.sys.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ztessc.base.entity.QueryTree;
import com.ztessc.base.entity.Tree;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.common.config.FullLogConfiguration;

@FeignClient(value="RBAC-PRODUCE",configuration = FullLogConfiguration.class,path = "/tree")
public interface TreeService extends GenericService<Tree,QueryTree> {

    /**
     * 功能描述：加载首页菜单节点的数据
     * @return
     */
    @RequestMapping(value="/mainTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> mainTree(@RequestParam("token") String token);

    /**
     * 功能描述：直接加载整个菜单树的数据(且必须要有管理员权限才可以加载该菜单树的数据)
     * @return
     */
    @RequestMapping(value = "/loadUserTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String,Object> loadUserTree();

}
