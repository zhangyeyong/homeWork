package com.ztessc.consumer.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.QueryTree;
import com.ztessc.base.entity.Tree;
import com.ztessc.consumer.common.base.controller.GenericController;
import com.ztessc.consumer.common.base.service.GenericService;
import com.ztessc.consumer.sys.service.TreeService;

@RestController
@RequestMapping("/tree")
public class TreeController  extends GenericController<Tree,QueryTree> {

    @Autowired
    private TreeService treeService;

    @Override
    protected GenericService<Tree, QueryTree> getService() {
        return treeService;
    }

    /**
     * 功能描述：加载首页菜单节点的数据
     * @return
     */
    @RequestMapping(value = "/mainTree",method = RequestMethod.POST)
    public Map<String,Object> mainTree(String token){
        return treeService.mainTree(token);
    }

    /**
     * 功能描述：直接加载整个菜单树的数据(且必须要有管理员权限才可以加载该菜单树的数据)
     * @return
     */
    @RequestMapping(value = "/loadUserTree",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,Object> loadUserTree(){
        return treeService.loadUserTree();
    }
}
