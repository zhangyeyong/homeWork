package com.ztessc.produce.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ztessc.base.entity.QueryUser;
import com.ztessc.base.entity.User;
import com.ztessc.base.entity.UserRole;
import com.ztessc.base.util.json.JsonHelper;
import com.ztessc.produce.common.base.constant.SystemStaticConst;
import com.ztessc.produce.common.base.controller.GenericController;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.service.UserRoleService;
import com.ztessc.produce.sys.service.UserService;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: UserController.java
 * @Package com.ztessc.produce.sys.controller
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@RestController
@RequestMapping("/user")
public class UserController extends GenericController<User, QueryUser> {

	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;

	@Override
	protected GenericService<User, QueryUser> getService() {
		return userService;
	}

	@Override
	public Map<String, Object> get(@RequestBody User entity) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		entity = userService.get(entity);
		if (entity == null) {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG, "获取数据失败！");
		} else {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG, "获取数据成功！");
			// TODO 不支持新语法，需要调整
			// entity.setRoleArray(JsonHelper.list2json(Optional.ofNullable(userService.findByLogin(entity.getLogin()))
			// .filter(u -> u != null).orElse(new User()).getRoles()));
			result.put("entity", entity);
		}
		return result;
	}

	/**
	 * 功能描述：更新用户状态为禁用/启用
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/userControl", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> userControl(@RequestBody User entity) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		if (userService.userControl(entity)) {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG, "更新用户状态成功！");
			result.put("entity", entity);
		} else {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG, "更新用户状态失败！");
		}
		return result;
	}

	/**
	 * 功能描述：加载所有的权限数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loadRoles", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> loadRoles() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<UserRole> userRoleList = userRoleService.query(null);
		result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
		result.put("list", userRoleList);
		return result;
	}

}
