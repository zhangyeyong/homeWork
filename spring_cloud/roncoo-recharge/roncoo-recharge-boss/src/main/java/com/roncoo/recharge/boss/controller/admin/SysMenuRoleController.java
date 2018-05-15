/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.roncoo.recharge.boss.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.recharge.boss.bean.qo.SysMenuRoleQO;
import com.roncoo.recharge.boss.bean.vo.SysMenuRoleVO;
import com.roncoo.recharge.boss.service.SysMenuRoleService;
import com.roncoo.recharge.boss.service.SysMenuService;
import com.roncoo.recharge.util.base.BaseController;
import com.xiaoleilu.hutool.util.CollectionUtil;

/**
 * 菜单角色关联表
 *
 * @author wujing
 * @since 2017-12-26
 */
@Controller
@RequestMapping(value = "/admin/sysMenuRole")
public class SysMenuRoleController extends BaseController {

	private final static String TARGETID = "admin-sysMenuRole";

	@Autowired
	private SysMenuRoleService service;

	@Autowired
	private SysMenuService sysMenuService;

	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public void setGet(@ModelAttribute SysMenuRoleQO qo, ModelMap modelMap) {
		List<SysMenuRoleVO> list = service.listByRoleId(qo.getRoleId());
		modelMap.put("menuRoleList", list);
		modelMap.put("bean", qo);
		modelMap.put("ids", getIds(list));
		modelMap.put("menuList", sysMenuService.listMenuForRole(list, qo.getPlatformId()));
	}

	@ResponseBody
	@RequestMapping(value = "/save")
	public String save(@ModelAttribute SysMenuRoleQO qo, @RequestParam(value = "ids") String ids) {
		if (service.save(qo, ids) > 0) {
			return success(TARGETID);
		}
		return error("添加失败");
	}

	private String getIds(List<SysMenuRoleVO> list) {
		StringBuilder sb = new StringBuilder();
		if (CollectionUtil.isNotEmpty(list)) {
			for (SysMenuRoleVO p : list) {
				sb.append(p.getId()).append(",");
			}
			sb = sb.delete(sb.length() - 1, sb.length());
		}
		return sb.toString();
	}

}
