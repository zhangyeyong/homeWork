package com.ztessc.produce.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.QueryUserRole;
import com.ztessc.base.entity.Tree;
import com.ztessc.base.entity.UserRole;
import com.ztessc.produce.common.base.constant.SystemStaticConst;
import com.ztessc.produce.common.base.controller.GenericController;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.service.TreeService;
import com.ztessc.produce.sys.service.UserRoleService;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: RoleController.java
 * @Package com.ztessc.produce.sys.controller
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<UserRole, QueryUserRole> {

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private TreeService treeService;

	@Override
	protected GenericService<UserRole, QueryUserRole> getService() {
		return userRoleService;
	}

	@RequestMapping(value = "/loadRoleTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> loadRoleTree(@RequestBody UserRole entity) {
		entity = userRoleService.getUserRoleAssociate(entity);
		List<Tree> treeList = treeService.query(null);
		if (entity != null) {
			for (Tree tree : entity.getTreeList()) {
//				treeList.stream().forEach(t -> {
//					if (t.getId() == tree.getId()) {
//						t.setChecked(true);
//					}
//				});
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
		result.put("data", treeList);
		return result;
	}

}
