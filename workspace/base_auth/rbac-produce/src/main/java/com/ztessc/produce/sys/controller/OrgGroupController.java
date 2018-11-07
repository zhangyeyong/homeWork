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

import com.ztessc.base.common.Page;
import com.ztessc.base.entity.OrgGroup;
import com.ztessc.base.entity.QueryOrgGroup;
import com.ztessc.base.entity.QueryUser;
import com.ztessc.produce.common.base.constant.SystemStaticConst;
import com.ztessc.produce.common.base.controller.GenericController;
import com.ztessc.produce.common.base.service.GenericService;
import com.ztessc.produce.sys.service.OrgGroupService;
import com.ztessc.produce.sys.service.UserService;

/**
 * 
 * All rights Reserved, Designed By www.ztessc.com
 * 
 * @Title: OrgGroupController.java
 * @Package com.ztessc.produce.sys.controller
 * @Description:
 * @author: 张业勇
 * @date: 2018年11月7日
 * @version V1.0
 * @Copyright: 2018 www.ztessc.com Inc. All rights reserved.
 */
@RestController
@RequestMapping("/group")
public class OrgGroupController extends GenericController<OrgGroup, QueryOrgGroup> {

	@Autowired
	private OrgGroupService orgGroupService;
	@Autowired
	private UserService userService;

	@Override
	protected GenericService<OrgGroup, QueryOrgGroup> getService() {
		return orgGroupService;
	}

	@Override
	public Map<String, Object> get(@RequestBody OrgGroup entity) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		entity = orgGroupService.get(entity);
		if (entity == null) {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG, "获取数据失败！");
		} else {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG, "获取数据成功！");
			entity.setOrgGroup(orgGroupService.findByNode(entity.getParentNode()));
			result.put("entity", entity);
		}
		return result;
	}

	@Override
	public Map<String, Object> update(@RequestBody OrgGroup entity) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>();
		OrgGroup update = new OrgGroup();
		update.setGroupId(entity.getGroupId());
		update = orgGroupService.get(update);
		update.setName(entity.getName());
		update.setGroupCode(entity.getGroupCode());
		update.setNum(entity.getNum());
		boolean success = orgGroupService.update(update);
		if (success) {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
			result.put(SystemStaticConst.MSG, "修改数据成功！");
			result.put("entity", entity);
		} else {
			result.put(SystemStaticConst.RESULT, SystemStaticConst.FAIL);
			result.put(SystemStaticConst.MSG, "修改数据失败！");
		}
		return result;
	}

	/**
	 * 功能描述：获取组织架构底下的相应的用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> userList(@RequestBody QueryUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		Page page = userService.findByGroupUserPage(user);
		result.put("totalCount", page.getTotal());
		result.put("result", page.getRows());
		return result;
	}

	/**
	 * 功能描述：获取组织架构的整颗菜单树
	 * 
	 * @return
	 */
	@RequestMapping(value = "/loadGroupTree", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> loadGroupTree() {
		Map<String, Object> result = new HashMap<String, Object>();
		List<OrgGroup> orgGroupList = orgGroupService.query(null);
		result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
		result.put(SystemStaticConst.MSG, "加载组织机构数据成功！");
		result.put("data", orgGroupList);
		return result;
	}

	@Override
	public Map<String, Object> save(@RequestBody OrgGroup entity) throws Exception {
		String max_node = getMaxNode(orgGroupService.getMaxOrgGroup(entity.getOrgGroup().getNode()),
				entity.getOrgGroup().getNode());
		entity.setParentNode(entity.getOrgGroup().getNode());
		entity.setNode(max_node);
		return super.save(entity);
	}

	private String getMaxNode(String node, String parentNode) {
		String max_node = "";
		if (node == null) {
			max_node = parentNode + "001";
		} else {
			String n = (Integer.parseInt(node.substring(node.length() - 3)) + 1) + "";
			switch (n.length()) {
			case 1:
				max_node = parentNode + "00" + n;
				break;
			case 2:
				max_node = parentNode + "0" + n;
				break;
			case 3:
				max_node = parentNode + "" + n;
				break;
			}
		}
		return max_node;
	}

}
