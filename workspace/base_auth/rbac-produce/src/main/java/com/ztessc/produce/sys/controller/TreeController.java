package com.ztessc.produce.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.QueryTree;
import com.ztessc.base.entity.Tree;
import com.ztessc.base.entity.User;
import com.ztessc.base.util.redis.RedisCache;
import com.ztessc.produce.common.base.constant.SystemStaticConst;
import com.ztessc.produce.common.base.controller.GenericController;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.common.util.user.UserInfo;
import com.ztessc.produce.sys.service.TreeService;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: TreeController.java
 * @Package com.ztessc.produce.sys.controller
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@RestController
@RequestMapping("/tree")
public class TreeController extends GenericController<Tree, QueryTree> {

	@Autowired
	private TreeService treeService;

	@Autowired
	private RedisCache redisCache;

	@Override
	protected GenericService<Tree, QueryTree> getService() {
		return treeService;
	}

	/**
	 * 功能描述：加载首页菜单节点的数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mainTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> mainTree(String token) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Tree> trees = UserInfo.loadUserTree(treeService, (User) redisCache.getObject(token, User.class));
		result.put("data", trees);
		result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
		return result;
	}

	/**
	 * 功能描述：直接加载整个菜单树的数据(且必须要有管理员权限才可以加载该菜单树的数据)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loadUserTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> loadUserTree() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Tree> treeList = treeService.query(null);
		result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
		result.put(SystemStaticConst.MSG, "加载菜单数据成功！");
		result.put("data", treeList);
		return result;
	}

}
